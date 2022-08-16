package com.restwebservice.restwebservice.controller;

import com.restwebservice.restwebservice.dto.request.AddressRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.service.AddressService;
import com.restwebservice.restwebservice.service.AddressServiceImpl;

import javax.ws.rs.*;
import java.util.List;

@Path("/address")
public class AddressController {

    private final AddressService addressService = new AddressServiceImpl();

    @GET
    @Path("/list")
    @Produces("application/json")
    public ResponseModel<List<AddressResponse>> list(){
        return addressService.list();
    }

    @POST
    @Path("/save")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseModel<AddressResponse> save(AddressRequest addressRequest){
        return addressService.save(addressRequest);
    }
 }
