package com.example.ipljerseystore.productcontroller;

import com.example.ipljerseystore.productdto.ProductRequestDto;
import com.example.ipljerseystore.productdto.ProductResponseDto;
import com.example.ipljerseystore.productservice.ProductService;
import com.example.ipljerseystore.session.Session;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:5173","https://ipl-store-frontend-c1w5kdt9f-kjs-3s-projects.vercel.app","https://*.vercel.app",allowCredentials = "true")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/getallproducts")
    public ResponseEntity<List<ProductResponseDto>> getallproducts(){
        return ResponseEntity.ok(productService.getallproducts());
    }
    @GetMapping("/getproductbyid/{id}")
    public ResponseEntity<?> getproductbyid(@PathVariable("id") long id){
        try{
            ProductResponseDto productResponseDto=productService.getproductbyid(id);
            return ResponseEntity.ok(productResponseDto);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @GetMapping("/getbycategory")
    public ResponseEntity<List<ProductResponseDto>> getproductsbycategory(@RequestParam long categoryId){
        return ResponseEntity.ok( productService.getproductsbycategory(categoryId));
    }

    @GetMapping("/getbyteam")
    public ResponseEntity<List<ProductResponseDto>> getproductsbyteamname
            (@RequestParam String teamname){
        return ResponseEntity.ok(productService.getproductsbyteamname(teamname));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<ProductResponseDto>> getbycategoryandteamname
            (@RequestParam long categoryId,@RequestParam String teamname){
        return ResponseEntity.ok(productService.getproductsbycategoryandteamname
                (categoryId,teamname));
    }
    @PostMapping("/admin/addproduct")
    public ResponseEntity<?> addproduct(@RequestBody ProductRequestDto productRequestDto,
                                        HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin only allowed to add products");
//        }
        try{
            ProductResponseDto productResponseDto=productService.addproduct(productRequestDto);
            return ResponseEntity.ok(productResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @PostMapping("/admin/addimage")
    public ResponseEntity<?> addimage(@RequestParam("files")MultipartFile file,HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin only allowed to add images");
//        }
        try{
            String uploaddir="src/main/resources/static/images";
            String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
            Path path= Paths.get(uploaddir+fileName);
            Files.createDirectories(path.getParent());
            Files.write(path,file.getBytes());
            return ResponseEntity.ok("/images"+fileName);

        } catch (IOException e) {
           return ResponseEntity.status(400).body("upload failed check again"+" "+e.getMessage());
        }
    }
    @PutMapping("/admin/updateproduct/{id}")
    public ResponseEntity<?> updateproduct(@RequestBody ProductRequestDto productRequestDto,
                                           @PathVariable("id") long id,
                                           HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin only allowed to update exisiting products");
//        }
        try{
            ProductResponseDto productResponseDto=productService.updateproduct(productRequestDto,id);
            return ResponseEntity.ok(productResponseDto);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    @DeleteMapping("/admin/deleteproduct/{id}")
    public ResponseEntity<?> deleteproductbyid(@PathVariable("id") long id,HttpSession session){
//        if(!Session.isAdmin(session)){
//            return ResponseEntity.status(401).body("Admin only allowed to update exisiting products");
//        }
        try{
            String message=productService.deleteproductbyid(id);
            return ResponseEntity.ok(message);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
