package com.example.ipljerseystore.productdto;

public class ProductRequestDto {
   private String name;
   private String description;
   private double price;
   private String teamName;
   private String imageUrl;
   private String size;
   private int stockQuantity;
   private long categoryId;

    public ProductRequestDto() {
    }

    public ProductRequestDto(String name, String description,
                             double price, String teamName, String imageUrl,
                             String size, int stockQuantity, long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.teamName = teamName;
        this.imageUrl = imageUrl;
        this.size = size;
        this.stockQuantity = stockQuantity;
        this.categoryId = categoryId;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
