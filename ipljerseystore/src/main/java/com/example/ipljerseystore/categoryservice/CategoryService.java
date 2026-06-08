package com.example.ipljerseystore.categoryservice;

import com.example.ipljerseystore.categorydto.CategoryRequestDto;
import com.example.ipljerseystore.categorydto.CategoryResponseDto;
import com.example.ipljerseystore.categoryentity.Category;
import com.example.ipljerseystore.categorymapper.CategoryMapper;
import com.example.ipljerseystore.categoryrepository.CategoryRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<CategoryResponseDto> getcategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::etd)
                .collect(Collectors.toList());
    }

    public CategoryResponseDto getcategorybyid(long id) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("categoryId not found"));
        CategoryResponseDto categoryResponseDto=CategoryMapper.etd(category);
        return categoryResponseDto;
    }

    public CategoryResponseDto addcategory(CategoryRequestDto categoryRequestDto) {
        boolean exists=categoryRepository.findByName(
                Category.Categoryname.valueOf(categoryRequestDto.getName())).isPresent();
        if(exists){
            throw new RuntimeException("Categoryname already exsists check again");
        }
        Category category=CategoryMapper.dte(categoryRequestDto);
        Category saved=categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto=CategoryMapper.etd(saved);
        return categoryResponseDto;
    }

    public CategoryResponseDto updatecategory(long id,CategoryRequestDto categoryRequestDto) {
        Category category=categoryRepository.findByCategoryId(id)
                .orElseThrow(()->new RuntimeException("categoryId to update is not found"));
        category.setDescription(categoryRequestDto.getDescription());
        category.setImageUrl(categoryRequestDto.getImageUrl());
        categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto=CategoryMapper.etd(category);
        return categoryResponseDto;
    }

    public String deletecategory(long id) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("deletecategoryid is not found"));
        categoryRepository.deleteById(id);
        return "Category deleted successfully";
    }
}
