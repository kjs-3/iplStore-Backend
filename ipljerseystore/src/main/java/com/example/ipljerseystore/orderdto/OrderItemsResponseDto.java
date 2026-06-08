package com.example.ipljerseystore.orderdto;

public class OrderItemsResponseDto {
    private long orderitemsId;
    private long productId;
    private String productName;
    private String teamName;
    private String categoryName;
    private String size;
    private String imageUrl;
    private int quantity;
    private double price;
    private double subtotal; //price*quantity

    public OrderItemsResponseDto() {
    }

    public OrderItemsResponseDto(long orderitemsId, long productId, String productName, String teamName,
                                 String categoryName, String size, String imageUrl, int quantity, double price, double subtotal) {
        this.orderitemsId = orderitemsId;
        this.productId = productId;
        this.productName = productName;
        this.teamName = teamName;
        this.categoryName = categoryName;
        this.size = size;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public long getOrderitemsId() {
        return orderitemsId;
    }

    public void setOrderitemsId(long orderitemsId) {
        this.orderitemsId = orderitemsId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
