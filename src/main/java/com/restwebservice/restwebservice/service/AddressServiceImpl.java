package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dao.AddressDao;
import com.restwebservice.restwebservice.dao.AddressDaoImpl;
import com.restwebservice.restwebservice.dto.request.AddressRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.dto.response.UserResponse;
import com.restwebservice.restwebservice.exceptions.Status;
import com.restwebservice.restwebservice.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements AddressService{

    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public Address getById(String id) throws Exception{
        return addressDao.getById(id);
    }

    @Override
    public Address getByUserId(String id) throws Exception{
        return addressDao.getByUserId(id);
    }

    public Address update(String userId,Address address) throws Exception{
        return addressDao.update(userId, address);
    }

    @Override
    public Address delete(String userId) throws Exception{
        return addressDao.delete(userId);
    }
}
