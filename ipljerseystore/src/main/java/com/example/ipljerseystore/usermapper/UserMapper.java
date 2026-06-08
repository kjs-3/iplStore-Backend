package com.example.ipljerseystore.usermapper;

import com.example.ipljerseystore.userdto.RegisterrequestDto;
import com.example.ipljerseystore.userdto.Userresponse;
import com.example.ipljerseystore.userentity.Users;

public class UserMapper {
    //entity to dto
    public static Userresponse etd(Users users){
        Userresponse userresponse=new Userresponse();
        userresponse.setUserId(users.getUserId());
        userresponse.setUserName(users.getUserName());
        userresponse.setUserEmail(users.getUserEmail());
        userresponse.setUserPhonenumber(users.getUserPhno());
        userresponse.setRole(users.getRole().name()); //enum result convert to str we use name()
        return userresponse;
    }
    // dto to entity
    public static Users dte(RegisterrequestDto registerrequestDto){
        Users users=new Users();
        users.setUserName(registerrequestDto.getUserName());
        users.setUserEmail(registerrequestDto.getUserEmail());
        users.setUserPassword(registerrequestDto.getUserPassword());
        users.setUserPhno(registerrequestDto.getUserPhonenumber());
        users.setRole(Users.Role.user); // from reg form we always get user so no need to give by them
        return users;

    }
}
