package com.example.ipljerseystore.cartmapper;

import com.example.ipljerseystore.cartdto.CartRequestDto;
import com.example.ipljerseystore.cartdto.CartResponseDto;
import com.example.ipljerseystore.cartentity.Cart;
import com.example.ipljerseystore.productentity.Products;
import com.example.ipljerseystore.userentity.Users;

public class CartMapper {
    public static Cart dte(CartRequestDto cartRequestDto, Users users, Products products){
        Cart cart=new Cart();
        cart.setUsers(users);
        cart.setProducts(products);
        cart.setQuantity(cartRequestDto.getQuantity());
        return cart;
    }
    public static CartResponseDto etd(Cart cart){
        CartResponseDto cartResponseDto=new CartResponseDto();
        cartResponseDto.setCartId(cart.getCartId());
        cartResponseDto.setUserId(cart.getUsers().getUserId());
        cartResponseDto.setProductId(cart.getProducts().getProductId());
        cartResponseDto.setProductName(cart.getProducts().getProductName());
        cartResponseDto.setTeamName(cart.getProducts().getTeamName());
        cartResponseDto.setCategoryName(cart.getProducts().getCategory().getName().name());
        cartResponseDto.setSize(cart.getProducts().getProductSize());
        cartResponseDto.setImageUrl(cart.getProducts().getProductImage());
        cartResponseDto.setPrice(cart.getProducts().getProductPrice());
        cartResponseDto.setQuantity(cart.getQuantity());
        cartResponseDto.setSubtotal(cart.getProducts().getProductPrice()*cart.getQuantity());
        return cartResponseDto;
    }
}
