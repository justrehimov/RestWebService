package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dto.request.AddressRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.model.Address;
import com.restwebservice.restwebservice.model.User;

import java.util.List;

public interface AddressService {

    Address getById(String id) throws Exception;

    Address getByUserId(String id) throws Exception;

    Address update(String userId,Address address) throws Exception;

    Address delete(String userId,User user) throws Exception;
}
