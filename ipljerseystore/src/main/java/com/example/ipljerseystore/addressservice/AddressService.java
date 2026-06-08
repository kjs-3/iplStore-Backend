package com.example.ipljerseystore.addressservice;

import com.example.ipljerseystore.addressdto.AddressRequestDto;
import com.example.ipljerseystore.addressdto.AddressResponseDto;
import com.example.ipljerseystore.addressentity.Address;
import com.example.ipljerseystore.addressmapper.AddressMapper;
import com.example.ipljerseystore.addressrepository.AddressRepository;
import com.example.ipljerseystore.userentity.Users;
import com.example.ipljerseystore.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    public List<AddressResponseDto> getalladdress(long id) {
       return addressRepository.findByUsersUserId(id).stream()
               .map(AddressMapper::etd)
               .collect(Collectors.toList());
    }

    public AddressResponseDto getdefaultaddress(long id) {
        Address address=addressRepository.findByUsersUserIdAndIsDefaultTrue(id)
                .orElseThrow(()->new RuntimeException("Users not exists and not provided any default address"));
        return AddressMapper.etd(address);
    }

    public AddressResponseDto addaddress(AddressRequestDto addressRequestDto) {
        Users users=userRepository.findById(addressRequestDto.getUserId())
                .orElseThrow(()->new RuntimeException("users not found to add the address"));
        int count=addressRepository.countByUsersUserId(addressRequestDto.getUserId()); //101 2
        if(count==0){
            addressRequestDto.setDefault(true);
        }
        if(count>=1 && addressRequestDto.isDefault()){
            removeExistingDefault(addressRequestDto.getUserId()); //waht i gave now add as default so previous
            //default needed to be removed thats why
        }
        Address address=AddressMapper.dte(addressRequestDto,users);
        Address saved=addressRepository.save(address);
        return AddressMapper.etd(saved);
    }
    public void removeExistingDefault(Long id){
        addressRepository.findByUsersUserIdAndIsDefaultTrue(id)
                .ifPresent(existing->{
                    existing.setDefault(false);
                    addressRepository.save(existing);
                });

    }
    public AddressResponseDto setdefault(long addressid, long userid) {
        removeExistingDefault(userid); //false
        Address address=addressRepository.findById(addressid).orElseThrow(()->
                new RuntimeException("Address not found"));
        address.setDefault(true);
        addressRepository.save(address);
        return AddressMapper.etd(address);
    }

    public String deleteaddress(long addressid) {
        addressRepository.findById(addressid).orElseThrow(()->new RuntimeException("Address not found"));
       addressRepository.deleteById(addressid);
       return "Deleted address Successfully...!!!";
    }
}
