package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dao.AddressDao;
import com.restwebservice.restwebservice.dao.AddressDaoImpl;
import com.restwebservice.restwebservice.dao.UserDao;
import com.restwebservice.restwebservice.dao.UserDaoImpl;
import com.restwebservice.restwebservice.dto.request.UserRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.dto.response.UserResponse;
import com.restwebservice.restwebservice.exceptions.Status;
import com.restwebservice.restwebservice.model.Address;
import com.restwebservice.restwebservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public ResponseModel<List<UserResponse>> list() {
        List<User> userList = userDao.list();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User u: userList){
            UserResponse userResponse = new UserResponse();
            userResponse.setName(u.getName());
            userResponse.setSurname(u.getSurname());
            userResponse.setAge(u.getAge());
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddress(u.getAddress().getAddress());
            addressResponse.setZipcode(u.getAddress().getZipcode());
            userResponse.setAddressResponse(addressResponse);
            userResponseList.add(userResponse);
        }
        return ResponseModel.<List<UserResponse>>builder()
                .result(userResponseList)
                .status(Status.getSuccess())
                .build();
    }

    @Override
    public ResponseModel<UserResponse> save(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setAge(userRequest.getAge());
        Address address = new Address();
        address.setAddress(userRequest.getAddressRequest().getAddress());
        address.setZipcode(userRequest.getAddressRequest().getZipcode());
        user.setAddress(address);
        User savedUser = userDao.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(savedUser.getName());
        userResponse.setSurname(savedUser.getSurname());
        userResponse.setAge(savedUser.getAge());
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddress(savedUser.getAddress().getAddress());
        addressResponse.setZipcode(savedUser.getAddress().getZipcode());
        userResponse.setAddressResponse(addressResponse);
        return ResponseModel.<UserResponse>builder()
                .result(userResponse)
                .status(Status.getSuccess())
                .build();
    }
}
