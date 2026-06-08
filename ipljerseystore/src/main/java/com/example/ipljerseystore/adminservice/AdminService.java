package com.example.ipljerseystore.adminservice;

import com.example.ipljerseystore.admindto.AdminDto;
import com.example.ipljerseystore.orderentity.Orders;
import com.example.ipljerseystore.orderrepository.OrderRepository;
import com.example.ipljerseystore.productrepository.ProductRepository;
import com.example.ipljerseystore.userentity.Users;
import com.example.ipljerseystore.userrepository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    public AdminDto getdashboard() {
        AdminDto adminDto=new AdminDto();
        long totalusers=userRepository.countByRole(Users.Role.user);
        adminDto.setTotalUsers(totalusers);
        long totalproducts=productRepository.count();
        adminDto.setTotalProducts(totalproducts);
        long totalorders=orderRepository.count();
        adminDto.setTotalOrders(totalorders);
        long pendingorders=orderRepository.countByStatus(Orders.OrderStatus.PENDING);
        adminDto.setPendingOrders(pendingorders);
        long deliveredorders=orderRepository.countByStatus(Orders.OrderStatus.DELIVERED);
        adminDto.setDeliveredOrders(deliveredorders);
        double totalamt=orderRepository.findByStatus(Orders.OrderStatus.DELIVERED).stream()
                .mapToDouble(Orders::getTotalAmount).sum();
        adminDto.setTotalAmountGained(totalamt);
        return adminDto;
    }
}
