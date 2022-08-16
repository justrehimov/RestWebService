package com.restwebservice.restwebservice.service;

import com.restwebservice.restwebservice.dao.AddressDao;
import com.restwebservice.restwebservice.dao.AddressDaoImpl;
import com.restwebservice.restwebservice.dto.request.AddressRequest;
import com.restwebservice.restwebservice.dto.response.AddressResponse;
import com.restwebservice.restwebservice.dto.response.ResponseModel;
import com.restwebservice.restwebservice.exceptions.Status;
import com.restwebservice.restwebservice.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements AddressService{

    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public Address getById(String id) {
        return addressDao.getById(id);
    }

    @Override
    public Address getByUserId(String id) {
        return addressDao.getByUserId(id);
    }

    @Override
    public ResponseModel<List<AddressResponse>> list() {
        List<Address> addressList =  addressDao.list();
        List<AddressResponse> addressResponseList = new ArrayList<>();
        for(Address a:addressList){
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddress(a.getAddress());
            addressResponse.setZipcode(a.getZipcode());
            addressResponseList.add(addressResponse);
        }
        return ResponseModel.<List<AddressResponse>>builder()
                .result(addressResponseList)
                .status(Status.getSuccess())
                .build();
    }

    @Override
    public ResponseModel<AddressResponse> save(AddressRequest addressRequest) {
        Address address = new Address();
        address.setAddress(addressRequest.getAddress());
        address.setZipcode(addressRequest.getZipcode());
        Address savedAddress = addressDao.save(address);
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddress(savedAddress.getAddress());
        addressResponse.setZipcode(savedAddress.getZipcode());
        return ResponseModel.<AddressResponse>builder()
                .result(addressResponse)
                .status(Status.getSuccess())
                .build();
    }
}
