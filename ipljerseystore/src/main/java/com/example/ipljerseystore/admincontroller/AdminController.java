package com.example.ipljerseystore.admincontroller;

import com.example.ipljerseystore.adminservice.AdminService;
import com.example.ipljerseystore.categoryservice.CategoryService;
import com.example.ipljerseystore.orderservice.OrderService;
import com.example.ipljerseystore.productrepository.ProductRepository;
import com.example.ipljerseystore.productservice.ProductService;
import com.example.ipljerseystore.session.Session;
import com.example.ipljerseystore.userrepository.UserRepository;
import com.example.ipljerseystore.userservice.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins="http://localhost:5173","https://ipl-store-frontend-c1w5kdt9f-kjs-3s-projects.vercel.app","https://*.vercel.app",allowCredentials = "true")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/admin/dashboard")
    public ResponseEntity<?> getdashboard(HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin can only view....");
//        }
        return ResponseEntity.ok(adminService.getdashboard());
    }
    @GetMapping("/admin/users")
    public ResponseEntity<?> getalluses(HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin login...!!");
//        }
        return ResponseEntity.ok(userService.getallusers());
    }
    @GetMapping("/admin/getallproducts")
    public ResponseEntity<?> getallproducts(HttpSession session){
        return ResponseEntity.ok(productService.getallproducts());
    }
    @GetMapping("/admin/getallcategories")
    public ResponseEntity<?> getcategories(){
        return ResponseEntity.ok(categoryService.getcategories());
    }

}
