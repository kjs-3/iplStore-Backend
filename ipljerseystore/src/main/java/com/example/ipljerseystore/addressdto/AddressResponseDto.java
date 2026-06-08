package com.example.ipljerseystore.addressdto;

public class AddressResponseDto {
    private long addressId;
    private long userId;
    private String userName;
    private long phoneNo;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private int pincode;
    private boolean isDefault;
    public long getAddressId() {
        return addressId;
    }

    public AddressResponseDto() {
    }

    public AddressResponseDto(long addressId, long userId, String userName, long phoneNo,
                              String doorNo, String street, String city,
                              String state, int pincode, boolean isDefault) {
        this.addressId = addressId;
        this.userId = userId;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.isDefault = isDefault;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }



}
