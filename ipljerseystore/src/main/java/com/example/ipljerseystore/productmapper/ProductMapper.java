package com.example.ipljerseystore.productmapper;

import com.example.ipljerseystore.categorydto.CategoryRequestDto;
import com.example.ipljerseystore.categoryentity.Category;
import com.example.ipljerseystore.productdto.ProductRequestDto;
import com.example.ipljerseystore.productdto.ProductResponseDto;
import com.example.ipljerseystore.productentity.Products;

public class ProductMapper {
    public static Products dte(ProductRequestDto productRequestDto,
                               Category category){
        Products products=new Products();
        products.setProductName(productRequestDto.getName());
        products.setProductDescription(productRequestDto.getDescription());
        products.setProductPrice(productRequestDto.getPrice());
        products.setProductStock(productRequestDto.getStockQuantity());
        products.setCategory(category);
        products.setTeamName(productRequestDto.getTeamName());
        products.setProductImage(productRequestDto.getImageUrl());
        products.setProductSize(productRequestDto.getSize());
        return products;
    }
    public static ProductResponseDto etd(Products products){
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductId(products.getProductId());
        productResponseDto.setName(products.getProductName());
        productResponseDto.setDescription(products.getProductDescription());
        productResponseDto.setPrice(products.getProductPrice());
        productResponseDto.setSize(products.getProductSize());
        productResponseDto.setStockQuantity(products.getProductStock());
        productResponseDto.setTeamName(products.getTeamName());
        productResponseDto.setImageUrl(products.getProductImage());
        productResponseDto.setCategoryId(products.getCategory().getCategoryId());
        productResponseDto.setCategoryName(products.getCategory().getName().name());
//        productResponseDto.setCreatedAt(String.valueOf(products.getCreatedat()));
        return productResponseDto;
    }
}
