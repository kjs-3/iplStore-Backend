package com.example.ipljerseystore.productservice;

import com.example.ipljerseystore.categoryentity.Category;
import com.example.ipljerseystore.categoryrepository.CategoryRepository;
import com.example.ipljerseystore.productdto.ProductRequestDto;
import com.example.ipljerseystore.productdto.ProductResponseDto;
import com.example.ipljerseystore.productentity.Products;
import com.example.ipljerseystore.productmapper.ProductMapper;
import com.example.ipljerseystore.productrepository.ProductRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public List<ProductResponseDto> getallproducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::etd)
                .collect(Collectors.toList());
    }

    public ProductResponseDto getproductbyid(long id) {
        Products products=productRepository.findById(id).
                orElseThrow(()->new RuntimeException("Product not found"));
        return ProductMapper.etd(products);
    }

    public List<ProductResponseDto> getproductsbycategory(long id) {
        return productRepository.findByCategoryCategoryId(id)
                .stream()
                .map(ProductMapper::etd)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDto> getproductsbyteamname(String teamname) {
        return productRepository.findByTeamNameIgnoreCase(teamname)
                .stream()
                .map(ProductMapper::etd)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDto> getproductsbycategoryandteamname(long categoryId, String teamname) {
        return productRepository.findByCategoryCategoryIdAndTeamName(categoryId,teamname).stream()
                .map(ProductMapper::etd)
                .collect(Collectors.toList());
    }

    public ProductResponseDto addproduct(ProductRequestDto productRequestDto) {
           Category category=categoryRepository.findByCategoryId(productRequestDto.getCategoryId())
                   .orElseThrow(()->new RuntimeException("CategoryId is not found to add your products"));
           Products products =ProductMapper.dte(productRequestDto,category);
           Products save=productRepository.save(products);
           return ProductMapper.etd(save);

    }

    public ProductResponseDto updateproduct(ProductRequestDto productRequestDto, long id) {
        Products products=productRepository.findByProductId(id).orElseThrow(()->
                new RuntimeException("Product which you want to update is not found"));
        Category category=categoryRepository.findByCategoryId(productRequestDto.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category is not found"));
         products.setProductName(productRequestDto.getName());
         products.setProductDescription(productRequestDto.getDescription());
         products.setProductPrice(productRequestDto.getPrice());
         products.setProductStock(productRequestDto.getStockQuantity());
         products.setCategory(category);
         products.setProductImage(productRequestDto.getImageUrl());
         products.setTeamName(productRequestDto.getTeamName());
         products.setProductSize(productRequestDto.getSize());
         Products updated=productRepository.save(products);
         return ProductMapper.etd(updated);
    }

    public String deleteproductbyid(long id) {
        Products products=productRepository.findByProductId(id)
                .orElseThrow(()->new RuntimeException("Product which you want to delete is not found"));
        productRepository.deleteById(id);
        return "deleted Successfully....!!!!!";
    }
    //when order gets places this method will be called
    public void reduceStock(long productid,int quantity){
        Products products=productRepository.findByProductId(productid)
                .orElseThrow(()->new RuntimeException("Product not found"));
        if(products.getProductStock()<quantity){
            throw new RuntimeException("We have only limited stock your quantity is high....");
        }
        products.setProductStock(products.getProductStock()-quantity);
    }
}
