package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dto.request.UserRequest;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    ResponseModel<List<UserResponse>> list();

    ResponseModel<UserResponse> save(UserRequest userRequest);
}
