package com.example.ipljerseystore.userservice;

import com.example.ipljerseystore.productdto.ProductResponseDto;
import com.example.ipljerseystore.userdto.LoginrequestDto;
import com.example.ipljerseystore.userdto.RegisterrequestDto;
import com.example.ipljerseystore.userdto.Userresponse;
import com.example.ipljerseystore.userentity.Users;
import com.example.ipljerseystore.usermapper.UserMapper;
import com.example.ipljerseystore.userrepository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;
    public Userresponse register(RegisterrequestDto registerrequestDto) {
        if(ur.existsByUserEmail(registerrequestDto.getUserEmail())){
            throw new RuntimeException("Email already Exists");
        }
        Users users=UserMapper.dte(registerrequestDto);
        Users saveduser=ur.save(users);
        Userresponse userresponse=UserMapper.etd(saveduser);
        userresponse.setMessage("Registered SuccessFully...!!!");
        return userresponse;
    }

    public Userresponse login(LoginrequestDto loginrequestDto) {
        Users users=ur.findByUserEmail(loginrequestDto.getUserEmail())
                .orElseThrow(()->new RuntimeException("Email Not Found try again"));
        if(!loginrequestDto.getUserPassword().equals(users.getUserPassword())){
            throw new RuntimeException("Password Mismatch");
        }
        Userresponse userresponse=UserMapper.etd(users);
        userresponse.setMessage("Logged in Succesfully");
        return userresponse;
    }

    public List<Userresponse> getallusers() {
        return ur.findAll().stream().map(UserMapper::etd).collect(Collectors.toList());
    }

}
