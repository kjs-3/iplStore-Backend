package com.example.ipljerseystore.cartservice;

import com.example.ipljerseystore.cartdto.CartRequestDto;
import com.example.ipljerseystore.cartdto.CartResponseDto;
import com.example.ipljerseystore.cartentity.Cart;
import com.example.ipljerseystore.cartmapper.CartMapper;
import com.example.ipljerseystore.cartrepository.CartRepository;
import com.example.ipljerseystore.productentity.Products;
import com.example.ipljerseystore.productrepository.ProductRepository;
import com.example.ipljerseystore.userentity.Users;
import com.example.ipljerseystore.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    public CartResponseDto addtocart(CartRequestDto cartRequestDto) {
        //failed to add in cart
        Users users=userRepository.findByUserId(cartRequestDto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found login correctly"));
        Products products=productRepository.findByProductId(cartRequestDto.getProductId())
                .orElseThrow(()->new RuntimeException("product not found"));
        if(products.getProductStock()<=0){
            throw new RuntimeException("out of stock");
        }
        Optional<Cart> existing=cartRepository.findByUsersUserIdAndProductsProductId(cartRequestDto.getUserId(),
                cartRequestDto.getProductId());
        //if already in cart
        if(existing.isPresent()){
            Cart cart=existing.get();
            cart.setQuantity(cartRequestDto.getQuantity()+cart.getQuantity());
            Cart add=cartRepository.save(cart);
            CartResponseDto cartResponseDto=CartMapper.etd(add);
            return cartResponseDto;
        }
        else{
            //adding new cart
            Cart cart=CartMapper.dte(cartRequestDto,users,products);
            Cart saved=cartRepository.save(cart);
            CartResponseDto cartResponseDto=CartMapper.etd(saved);
            return cartResponseDto;
        }
    }

    public List<CartResponseDto> getcartofuser(long id) {
        return cartRepository.findByUsersUserId(id)
                .stream()
                .map(CartMapper::etd)
                .collect(Collectors.toList());
    }

    public CartResponseDto updatequantity(long id, int quantity) {
        Cart cart=cartRepository.findByCartId(id)
                .orElseThrow(()->new RuntimeException("cart item not found"));
        if(quantity<=0){
            throw new RuntimeException("removed the cart item");
        }
        if(quantity> cart.getProducts().getProductStock()){
            throw new RuntimeException("we cant add more items only limited stock");
        }
        cart.setQuantity(quantity);
        Cart saved=cartRepository.save(cart);
        return CartMapper.etd(saved);
    }

    public String deletecart(long id) {
        cartRepository.findByCartId(id).orElseThrow(()->new RuntimeException("cart not found"));
        cartRepository.deleteById(id);
        return "deleted cart item successfully";
    }

    public String deleteallcartitems(long id) {
        cartRepository.deleteByUsersUserId(id);
        return "No Cart Items";
    }

    public Double totalamount(long id) {
        List<Cart> cart=cartRepository.findByUsersUserId(id);
        return cart.stream()
                .mapToDouble(carts-> carts.getQuantity()*
                        carts.getProducts().getProductPrice())
                .sum();
    }
}
