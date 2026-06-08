package com.example.ipljerseystore.orderdto;

import java.util.List;

public class OrderResponseDto {
    private long orderId;
    private long userId;
    private String userName;
    private long userPhone;
    private double totalAmount;
    private String status;
    private String addressUsername;
    private long addressPhno;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private int pincode;
    List<OrderItemsResponseDto> orderItemsResponseDtoList;

    public OrderResponseDto() {
    }

    public OrderResponseDto(long orderId, long userId, String userName, long userPhone, double totalAmount, String status, String addressUsername, long addressPhno, String doorNo, String street,
                            String city, String state, int pincode,
                            List<OrderItemsResponseDto> orderItemsResponseDtoList) {
        this.orderId = orderId;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.totalAmount = totalAmount;
        this.status = status;
        this.addressUsername = addressUsername;
        this.addressPhno = addressPhno;
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.orderItemsResponseDtoList = orderItemsResponseDtoList;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressUsername() {
        return addressUsername;
    }

    public void setAddressUsername(String addressUsername) {
        this.addressUsername = addressUsername;
    }

    public long getAddressPhno() {
        return addressPhno;
    }

    public void setAddressPhno(long addressPhno) {
        this.addressPhno = addressPhno;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public List<OrderItemsResponseDto> getOrderItemsResponseDtoList() {
        return orderItemsResponseDtoList;
    }

    public void setOrderItemsResponseDtoList(List<OrderItemsResponseDto> orderItemsResponseDtoList) {
        this.orderItemsResponseDtoList = orderItemsResponseDtoList;
    }
}
