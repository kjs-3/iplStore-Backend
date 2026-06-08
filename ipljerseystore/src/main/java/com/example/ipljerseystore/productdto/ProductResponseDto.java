package com.example.ipljerseystore.productdto;

import java.time.LocalDateTime;

public class ProductResponseDto {
    private long productId;
    private String name;
    private String description;
    private double price;
    private String size;
    private String imageUrl;
    private String teamName;
    private int stockQuantity;
    private String createdAt;
    private long categoryId;
    private String categoryName;

    public ProductResponseDto() {
    }

    public ProductResponseDto(long productId, String name, String description, double price, String size, String imageUrl,
                              String teamName, int stockQuantity,
                              String createdAt, long categoryId, String categoryName) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
        this.teamName = teamName;
        this.stockQuantity = stockQuantity;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
