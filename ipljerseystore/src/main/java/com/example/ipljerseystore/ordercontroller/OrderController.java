package com.example.ipljerseystore.ordercontroller;

import com.example.ipljerseystore.orderdto.OrderRequestDto;
import com.example.ipljerseystore.orderdto.OrderResponseDto;
import com.example.ipljerseystore.orderdto.OrderStatusUpdateDto;
import com.example.ipljerseystore.orderservice.OrderService;
import com.example.ipljerseystore.session.Session;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/placeorder") //done by user
    public ResponseEntity<?> placeorder(@RequestBody OrderRequestDto orderRequestDto,
                                        HttpSession session){
//        if(!Session.isLoggedin(session)){
//            return ResponseEntity.status(400).body("Login to Place an Order...");
//        }
//        orderRequestDto.setUserId(Session.getuserId(session)); //ram what user id it saved
        try{
            OrderResponseDto orderResponseDto=orderService.placeorder(orderRequestDto);
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @GetMapping("/userorders/{userid}")
    public ResponseEntity<?> getuserorders(@PathVariable("userid") long userid,HttpSession session){
//            if(!Session.isLoggedin(session)){
//                return ResponseEntity.status(400).body("Login to get an OrderBYUSERID...");
//            }
            try{
                List<OrderResponseDto> orderResponseDto=orderService.getuserorders(userid);
                return ResponseEntity.ok(orderResponseDto);
            }
            catch(RuntimeException e){
                return ResponseEntity.status(400).body(e.getMessage());
            }

    }
    @GetMapping("/getorderbyid/{orderid}")
    public ResponseEntity<?> getorderbyid(@PathVariable("orderid") long orderid,HttpSession session){
//        if(!Session.isLoggedin(session)){
//            return ResponseEntity.status(400).body("Login to get an OrderBYID...");
//        }
        try{
            OrderResponseDto orderResponseDto=orderService.getorderbyid(orderid);
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }
    @GetMapping("/admin/getallorders")
    public ResponseEntity<?> getallorders(HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(400).body("Only admin can see all orders Admin access");
//        }
        try{
            List<OrderResponseDto> orderResponseDto=orderService.getallorders();
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }
    @GetMapping("/admin/getorderbystatus/{status}")
    public ResponseEntity<?> getordersbystatus(@PathVariable("status")String status,
                                               HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(400).body("Only admin can see all ordersBYSTATUS Admin access");
//        }
        try{
            List<OrderResponseDto> orderResponseDto=orderService.getorderbystatus(status);
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }
    @PutMapping("/admin/updateorderstatus/{orderId}")
    public ResponseEntity<?> updatestatus(@PathVariable("orderId") long orderid,
                                          HttpSession session,
                                          @RequestBody OrderStatusUpdateDto orderStatusUpdateDto){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(400).body("Only admin can update all orders Admin access");
//        }
        try{
           OrderResponseDto orderResponseDto=orderService.updatestatus(orderid,orderStatusUpdateDto.getStatus());
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }
    @PutMapping("/cancelorder/{orderid}")
    public ResponseEntity<?> cancelorder(@PathVariable("orderid") long orderid,HttpSession session){
//        if(!Session.isLoggedin(session)){
//            return ResponseEntity.status(400).body("Login to Cancel your OrderBYID...");
//        }
        try{
            OrderResponseDto orderResponseDto=orderService.cancelorder(orderid);
            return ResponseEntity.ok(orderResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }
}
