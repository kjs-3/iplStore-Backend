package com.example.ipljerseystore.orderservice;

import com.example.ipljerseystore.addressentity.Address;
import com.example.ipljerseystore.addressrepository.AddressRepository;
import com.example.ipljerseystore.cartentity.Cart;
import com.example.ipljerseystore.cartrepository.CartRepository;
import com.example.ipljerseystore.orderdto.OrderRequestDto;
import com.example.ipljerseystore.orderdto.OrderResponseDto;
import com.example.ipljerseystore.orderdto.OrderStatusUpdateDto;
import com.example.ipljerseystore.orderentity.Orders;
import com.example.ipljerseystore.orderitemrepository.OrderItemRepository;
import com.example.ipljerseystore.orderitemsentity.OrderItems;
import com.example.ipljerseystore.ordermapper.OrderMapper;
import com.example.ipljerseystore.orderrepository.OrderRepository;
import com.example.ipljerseystore.productentity.Products;
import com.example.ipljerseystore.productrepository.ProductRepository;
import com.example.ipljerseystore.userentity.Users;
import com.example.ipljerseystore.userrepository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public OrderResponseDto placeorder(OrderRequestDto orderRequestDto) {
        // take user
        Users users = userRepository.findByUserId(orderRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Sorry we cant Recognize you try login correctly..."));
        //if user is correct then take the address whcih they said to deliver the ordered items
        Address address = addressRepository.findById(orderRequestDto.getAddressID())
                .orElseThrow(() -> new RuntimeException("Address not registered try again"));
        //if both sucessfull then tak the cart items what that userid selected
        List<Cart> cartitems = cartRepository.findByUsersUserId(orderRequestDto.getUserId());
        if (cartitems.isEmpty()) {
            throw new RuntimeException("First Add Products To Place An Order");
        }
        //totalamount calc
        Double totalamt = cartitems.stream().
                mapToDouble(cart -> cart.getProducts().getProductPrice() * cart.getQuantity())
                .sum();
        //so what dto we have in orders we achieved that
        Orders orders = new Orders();
        orders.setUsers(users);
        orders.setAddress(address);
        orders.setTotalAmount(totalamt);
        orders.setStatus(Orders.OrderStatus.PENDING); //type enum
        Orders savedorders = orderRepository.save(orders);
        //to see order items
        List<OrderItems> orderItems = new ArrayList<>();
        //looping for cart to get each orderitems and see the product
        for (Cart cart : cartitems) {
            Products product = cart.getProducts();
            if (product.getProductStock() < cart.getQuantity()) {
                throw new RuntimeException("You have added products which is beyound our stock" +
                        " limit you can reduce it");
            }
            OrderItems orderItems1 = new OrderItems();
            orderItems1.setProducts(product);
            orderItems1.setOrders(savedorders);
            orderItems1.setQuantity(cart.getQuantity());
            orderItems1.setPrice(cart.getProducts().getProductPrice());
            orderItems.add(orderItems1);
            product.setProductStock(product.getProductStock() - cart.getQuantity());
            productRepository.save(product);
        }
            List<OrderItems> saveditems = orderItemRepository.saveAll(orderItems);
            savedorders.setOrderItemsList(saveditems);
            //after ordering i need to maku=e user cart clear
//            cartRepository.deleteByUsersUserId(orderRequestDto.getUserId());
        int rowsDeleted = cartRepository.deleteByUsersUserIdNative(orderRequestDto.getUserId());
        String deletionStatus = "Successfully removed " + rowsDeleted + " items from the user's cart.";
        System.out.println(deletionStatus);
            return OrderMapper.etd(savedorders);
        }
        public List<OrderResponseDto> getuserorders(long userid) {
             return orderRepository.findByUsers_UserId(userid).stream().map(OrderMapper::etd)
                     .collect(Collectors.toList());
    }

    public OrderResponseDto getorderbyid(long orderid) {
        Orders orders=orderRepository.findById(orderid).orElseThrow(()->
                new RuntimeException("orderId not found"));
        return OrderMapper.etd(orders);
    }

    public List<OrderResponseDto> getallorders() {
        return orderRepository.findAllByOrderByOrderIdDesc().stream()
                .map(OrderMapper::etd)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getorderbystatus(String status) {
        return orderRepository.findByStatus(Orders.OrderStatus.valueOf(status))//changing string to enum
                .stream().map(OrderMapper::etd)
                .collect(Collectors.toList());
    }


    public OrderResponseDto updatestatus(long orderid, String status) {
        Orders order=orderRepository.findById(orderid)
                .orElseThrow(()->new RuntimeException("orderId not found"));
        order.setStatus(Orders.OrderStatus.valueOf(status)); //enum
        Orders orders=orderRepository.save(order);
        return OrderMapper.etd(orders);
    }

    public OrderResponseDto cancelorder(long orderid) {
        Orders orders=orderRepository.findById(orderid)
                .orElseThrow(()->new RuntimeException("OrderId not found"));
        if(!orders.getStatus().equals(Orders.OrderStatus.PENDING)){
            throw new RuntimeException("Can't cancel your order because its status is confirmned");
        }
        for(OrderItems orderItems:orders.getOrderItemsList()){
            Products products=orderItems.getProducts();
            products.setProductStock(products.getProductStock()+orderItems.getQuantity());
            productRepository.save(products);
        }
        orders.setStatus(Orders.OrderStatus.CANCELLED); //giving defaukt value
        Orders savedorder=orderRepository.save(orders);
        return OrderMapper.etd(savedorder);
    }
}
