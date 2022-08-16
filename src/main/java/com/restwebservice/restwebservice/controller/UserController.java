package com.restwebservice.restwebservice.controller;

import com.restwebservice.restwebservice.dto.request.UserRequest;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.dto.response.UserResponse;
import com.restwebservice.restwebservice.service.UserService;
import com.restwebservice.restwebservice.service.UserServiceImpl;

import javax.ws.rs.*;
import java.util.List;

@Path("/user")
public class UserController {

    private final UserService userService = new UserServiceImpl();
    @GET
    @Path("/list")
    @Produces("application/json")
    public ResponseModel<List<UserResponse>> list(){
        return userService.list();
    }

    @POST
    @Path("/save")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseModel<UserResponse> save(UserRequest userRequest){
        return userService.save(userRequest);
    }

}
