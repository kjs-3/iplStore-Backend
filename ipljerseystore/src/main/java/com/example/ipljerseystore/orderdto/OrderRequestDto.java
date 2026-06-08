package com.example.ipljerseystore.orderdto;

public class OrderRequestDto {
    private long userId;
    private long addressID;

    public OrderRequestDto() {
    }

    public OrderRequestDto(long userId, long addressID) {
        this.userId = userId;
        this.addressID = addressID;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAddressID() {
        return addressID;
    }

    public void setAddressID(long addressID) {
        this.addressID = addressID;
    }
}
