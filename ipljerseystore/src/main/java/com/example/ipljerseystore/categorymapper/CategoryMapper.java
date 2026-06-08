package com.example.ipljerseystore.categorymapper;

import com.example.ipljerseystore.categorydto.CategoryRequestDto;
import com.example.ipljerseystore.categorydto.CategoryResponseDto;
import com.example.ipljerseystore.categoryentity.Category;

public class CategoryMapper {
    public static CategoryResponseDto etd(Category category){
        CategoryResponseDto categoryResponseDto=new CategoryResponseDto();
        categoryResponseDto.setCategoryId(category.getCategoryId());
        categoryResponseDto.setName(category.getName().name());
        categoryResponseDto.setDescription(category.getDescription());
        categoryResponseDto.setImageUrl(category.getImageUrl());
        return categoryResponseDto;

    }
    public static Category dte(CategoryRequestDto categoryRequestDto){
        Category category=new Category();
        category.setName(Category.Categoryname.valueOf(categoryRequestDto.getName()));//string--->convert to enum
        category.setDescription(categoryRequestDto.getDescription());
        category.setImageUrl(categoryRequestDto.getImageUrl());
        return category;
    }
}
