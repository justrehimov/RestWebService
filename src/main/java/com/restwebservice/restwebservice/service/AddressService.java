package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dto.request.AddressRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.model.Address;
import com.restwebservice.restwebservice.model.User;

import java.util.List;

public interface AddressService {

    Address getById(String id);

    Address getByUserId(String id);
    ResponseModel<List<AddressResponse>> list();

    ResponseModel<AddressResponse> save(AddressRequest addressRequest);
}
