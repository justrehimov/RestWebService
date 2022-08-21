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
        try {
            List<User> userList = userDao.list();
            List<UserResponse> userResponseList = new ArrayList<>();
            for (User u : userList) {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(u.getId());
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
        }catch (RuntimeException ex){
            return ResponseModel.<List<UserResponse>>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }catch (Exception ex){
            return ResponseModel.<List<UserResponse>>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }
    }

    @Override
    public ResponseModel<UserResponse> save(UserRequest userRequest) {
        try {
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
            userResponse.setId(savedUser.getId());
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
        }catch (RuntimeException ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }catch (Exception ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }
    }

    @Override
    public ResponseModel<UserResponse> update(String id, UserRequest userRequest) {
        try {
            User user = new User();
            user.setId(id);
            user.setName(userRequest.getName());
            user.setSurname(userRequest.getSurname());
            user.setAge(userRequest.getAge());
            Address address = new Address();
            address.setAddress(userRequest.getAddressRequest().getAddress());
            address.setZipcode(userRequest.getAddressRequest().getZipcode());
            user.setAddress(address);
            User updatedUser = userDao.update(id, user);
            UserResponse userResponse = new UserResponse();
            userResponse.setId(updatedUser.getId());
            userResponse.setName(updatedUser.getName());
            userResponse.setSurname(updatedUser.getSurname());
            userResponse.setAge(updatedUser.getAge());
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddress(updatedUser.getAddress().getAddress());
            addressResponse.setZipcode(updatedUser.getAddress().getZipcode());
            userResponse.setAddressResponse(addressResponse);
            return ResponseModel.<UserResponse>builder()
                    .result(userResponse)
                    .status(Status.getSuccess())
                    .build();
        }catch (RuntimeException ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }catch (Exception ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }
    }

    @Override
    public ResponseModel<UserResponse> delete(String id) {
        try {
            User user = userDao.delete(id);
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setName(user.getName());
            userResponse.setSurname(user.getSurname());
            userResponse.setAge(user.getAge());
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddress(user.getAddress().getAddress());
            addressResponse.setZipcode(user.getAddress().getZipcode());
            userResponse.setAddressResponse(addressResponse);
            return ResponseModel.<UserResponse>builder()
                    .result(userResponse)
                    .status(Status.getSuccess())
                    .build();
        }catch (RuntimeException ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }catch (Exception ex){
            return ResponseModel.<UserResponse>builder()
                    .status(Status.createStatus(ex.getMessage(), 500))
                    .build();
        }
    }
}
