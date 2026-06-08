package com.example.ipljerseystore.usercontroller;

import com.example.ipljerseystore.userdto.LoginrequestDto;
import com.example.ipljerseystore.userdto.RegisterrequestDto;
import com.example.ipljerseystore.userdto.Userresponse;
import com.example.ipljerseystore.userservice.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins ="http://localhost:5173",allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService us;
    //Registration
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterrequestDto registerrequestDto){
        // name,email,pw,phno
        try{
            Userresponse userresponse =us.register(registerrequestDto);
            return ResponseEntity.ok(userresponse);
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    //login -->email,pw
    public ResponseEntity<?> login (@RequestBody LoginrequestDto loginrequestDto, HttpSession session){
        try{
            Userresponse userresponse =us.login(loginrequestDto);
            session.setAttribute("UserId",userresponse.getUserId());
            session.setAttribute("Username",userresponse.getUserName());
            session.setAttribute("UserRole",userresponse.getRole());
            return ResponseEntity.ok(userresponse);
        }
        catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("Logout Successfully");
    }
    @GetMapping("/loggeduser")
    public ResponseEntity<?> logeduser(HttpSession session){
        //who is using y website currently logged person
        Long userId= (long) session.getAttribute("UserId");
        if(userId==null){
            return ResponseEntity.status(401).body("No one Logged in...");
        }
        Userresponse userresponse=new Userresponse();
        userresponse.setUserId((Long) session.getAttribute("UserId"));
        userresponse.setUserName((String) session.getAttribute("Username"));
        userresponse.setRole((String) session.getAttribute("UserRole"));
        return ResponseEntity.ok(userresponse);
          }
}
