package com.example.ipljerseystore.addresscontroller;

import com.example.ipljerseystore.addressdto.AddressRequestDto;
import com.example.ipljerseystore.addressdto.AddressResponseDto;
import com.example.ipljerseystore.addressservice.AddressService;
import com.example.ipljerseystore.session.Session;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
// @CrossOrigin(origins = "https://ipl-store-frontend-c1w5kdt9f-kjs-3s-projects.vercel.app","https://*.vercel.app","https://localhost:5173",allowCredentials = "true")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("/{userId}")
    public ResponseEntity<?> getalladdress(@PathVariable("userId") long id){
       // if(!Session.isLoggedin(session)){
       //    return ResponseEntity.status(401).body("To make You add address Login First");
       // }
            List<AddressResponseDto> addressResponseDto=addressService.getalladdress(id);
            return ResponseEntity.ok(addressResponseDto);
    }
    @GetMapping("/defaultaddress/{userId}")
    public ResponseEntity<?> getdefaultaddress(@PathVariable("userId") long id){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("To make You add address Login First");
       // }
        try{
            AddressResponseDto addressResponseDto =addressService.getdefaultaddress(id);
            return ResponseEntity.ok(addressResponseDto);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @PostMapping("/addaddress")
    public ResponseEntity<?> addaddress(@RequestBody AddressRequestDto addressRequestDto){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("To make You add address Login First");
       // }
        try{
            AddressResponseDto addressResponseDto=addressService.addaddress(addressRequestDto);
            return ResponseEntity.ok(addressResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @PutMapping("/update/{addressid}/{userid}")
    public ResponseEntity<?>setdefault(@PathVariable("addressid") long addressid,
                                           @PathVariable("userid")long userid){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("To make You add address Login First");
       // }
        try{
            AddressResponseDto addressResponseDto=addressService.setdefault(addressid,userid);
            return ResponseEntity.ok(addressResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }
    @DeleteMapping("/delete/{addressid}")
    public ResponseEntity<?> deleteaddress(@PathVariable("addressid") long addressid){
       // if(!Session.isLoggedin(session)){
       //     return ResponseEntity.status(401).body("To make You add address Login First");
       // }
        try{
            String message=addressService.deleteaddress(addressid);
            return ResponseEntity.ok(message);
        }
        catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
