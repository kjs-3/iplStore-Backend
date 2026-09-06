package com.example.ipljerseystore.categorycontroller;

import com.example.ipljerseystore.categorydto.CategoryRequestDto;
import com.example.ipljerseystore.categorydto.CategoryResponseDto;
import com.example.ipljerseystore.categoryservice.CategoryService;
import com.example.ipljerseystore.session.Session;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
// @CrossOrigin(origins="http://localhost:5173","https://ipl-store-frontend-c1w5kdt9f-kjs-3s-projects.vercel.app","https://*.vercel.app",allowCredentials = "true")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/getcategories")
    public ResponseEntity<List<CategoryResponseDto>> getcategories() {
        return ResponseEntity.ok(categoryService.getcategories());
    }

    @GetMapping("/getcategorybyid/{id}")
    public ResponseEntity<?> getcategorybyid(@PathVariable("id") long id) {
        try {
            CategoryResponseDto categoryResponseDto =
                    categoryService.getcategorybyid(id);
            return ResponseEntity.ok(categoryResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/category/addcategory")
    public ResponseEntity<?> addcategory(@RequestBody CategoryRequestDto categoryRequestDto) {
       // if (!Session.isAdmin(session)) {
       //     return ResponseEntity.badRequest().body("Admin only can add data");
       // }
        try {
            CategoryResponseDto categoryResponseDto = categoryService.addcategory(categoryRequestDto);
            return ResponseEntity.ok(categoryResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PutMapping("/category/updatecategory/{id}")
    public ResponseEntity<?> updatecategory(@PathVariable("id") long id,
                                            @RequestBody CategoryRequestDto categoryRequestDto) {
       // if (!Session.isAdmin(session)) {
       //     return ResponseEntity.status(401).body("Admin alone should update admin login needed");
       // }
        try {
            CategoryResponseDto categoryResponseDto = categoryService.updatecategory(id, categoryRequestDto);
            return ResponseEntity.ok(categoryResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }

    @DeleteMapping("/category/deletecategory/{id}")
    public ResponseEntity<?> updatecategory(@PathVariable("id") long id) {
       // if (!Session.isAdmin(session)) {
       //     return ResponseEntity.status(401).body("Admin alone should update admin login needed");
       // }
        try {
            String message = categoryService.deletecategory(id);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
