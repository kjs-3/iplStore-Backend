package com.example.ipljerseystore.cartcontroller;

import com.example.ipljerseystore.cartdto.CartRequestDto;
import com.example.ipljerseystore.cartdto.CartResponseDto;
import com.example.ipljerseystore.cartservice.CartService;
import com.example.ipljerseystore.session.Session;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ReactiveOffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
// @CrossOrigin(origins = "http://localhost:5173","https://ipl-store-frontend-c1w5kdt9f-kjs-3s-projects.vercel.app","https://*.vercel.app",allowCredentials = "true")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/addtocart")
    public ResponseEntity<?> addtocart(@RequestBody CartRequestDto cartRequestDto){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to add Items");
       // }
//        long userId=Session.getuserId(session);
//        cartRequestDto.setUserId(userId);
//        cartRequestDto.setUser_id(Session.getuserId(session));
        if(cartRequestDto.getUserId()==0){
            return ResponseEntity.status(401).body("Please Login to make your products add to cart");
        }
        try{
            CartResponseDto cartResponseDto=cartService.addtocart(cartRequestDto);
            return ResponseEntity.ok(cartResponseDto);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(500).body(Map.of("error",e.getMessage()));
        }
    }
    @GetMapping("/getcartofuser/{userid}")
    public ResponseEntity<?> getcartofuser(@PathVariable("userid") long id){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to get your Item list");
       // }
//        if(cartRequestDto.getUserId()==0){
//            return ResponseEntity.status(401).body("Please Login to get your Item list");
//        }
        try{
            List<CartResponseDto> cartResponseDto=cartService.getcartofuser(id);
            return  ResponseEntity.ok(cartResponseDto);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @PutMapping("/updatequantity/{cartid}")
    public ResponseEntity<?> updatequantity(@PathVariable("cartid") long id,
                                            @RequestParam int quantity){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to get your Item list");
       // }
        try{
          CartResponseDto cartResponseDto=cartService.updatequantity(id,quantity);
            return  ResponseEntity.ok(cartResponseDto);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @DeleteMapping("/deletecart/{cartid}")
    public ResponseEntity<?> deletecart(@PathVariable("cartid") long id){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to get this selected Item from list");
       // }
        try{
            String message=cartService.deletecart(id);
            return ResponseEntity.ok(message);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteallcart/{userid}")
    public ResponseEntity<?> deleteallcartitems(@PathVariable("userid")long id){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to delete all of your Item list");
       // }
        try{
            String message=cartService.deleteallcartitems(id);
            return ResponseEntity.ok(message);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @GetMapping("/totalamount/{userid}")
    public ResponseEntity<?> totalamount(@PathVariable("userid") long id){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("Please Login to check total amount in your Item list");
       // }
        try{
            Double amount=cartService.totalamount(id);
            return ResponseEntity.ok(amount);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }
}
