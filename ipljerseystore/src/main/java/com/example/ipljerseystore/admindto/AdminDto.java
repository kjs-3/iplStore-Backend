package com.example.ipljerseystore.admindto;

public class AdminDto {
    private long totalUsers;
    private long totalProducts;
    private long totalOrders;
    private long pendingOrders;
    private long deliveredOrders;
    private double totalAmountGained;

    public AdminDto() {
    }

    public AdminDto(long totalUsers, long totalProducts,
                    long totalOrders, long pendingOrders, long deliveredOrders, double totalAmountGained) {
        this.totalUsers = totalUsers;
        this.totalProducts = totalProducts;
        this.totalOrders = totalOrders;
        this.pendingOrders = pendingOrders;
        this.deliveredOrders = deliveredOrders;
        this.totalAmountGained = totalAmountGained;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public long getPendingOrders() {
        return pendingOrders;
    }

    public void setPendingOrders(long pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

    public long getDeliveredOrders() {
        return deliveredOrders;
    }

    public void setDeliveredOrders(long deliveredOrders) {
        this.deliveredOrders = deliveredOrders;
    }

    public double getTotalAmountGained() {
        return totalAmountGained;
    }

    public void setTotalAmountGained(double totalAmountGained) {
        this.totalAmountGained = totalAmountGained;
    }


}
