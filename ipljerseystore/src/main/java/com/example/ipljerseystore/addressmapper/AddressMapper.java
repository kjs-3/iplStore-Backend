package com.example.ipljerseystore.addressmapper;
import com.example.ipljerseystore.addressdto.AddressRequestDto;
import com.example.ipljerseystore.addressdto.AddressResponseDto;
import com.example.ipljerseystore.addressentity.Address;
import com.example.ipljerseystore.userentity.Users;

public class AddressMapper {
    //entity to dto
    public static AddressResponseDto etd(Address address){
        AddressResponseDto addressResponseDto=new AddressResponseDto();
        addressResponseDto.setAddressId(address.getAddressId());
        addressResponseDto.setUserId(address.getUsers().getUserId());
        addressResponseDto.setUserName(address.getUsers().getUserName());
        addressResponseDto.setPhoneNo(address.getPhoneNo());
        addressResponseDto.setDoorNo(address.getDoorNo());
        addressResponseDto.setStreet(address.getStreet());
        addressResponseDto.setCity(address.getCity());
        addressResponseDto.setState(address.getState());
        addressResponseDto.setPincode(address.getPincode());
        addressResponseDto.setDefault(address.isDefault());
        return addressResponseDto;
    }
    //dto to entity
    public static Address dte(AddressRequestDto addressRequestDto,Users users){
        Address address=new Address();
        address.setUsers(users);
        address.setPhoneNo(addressRequestDto.getPhoneNo());
        address.setDoorNo(addressRequestDto.getDoorNo());
        address.setStreet(addressRequestDto.getStreet());
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setPincode(addressRequestDto.getPincode());
        address.setDefault(addressRequestDto.isDefault());
        return address;
    }
}
