package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.model.Address;

import java.util.List;

public interface AddressDao {
    Address save(Address address);

    Address getById(String id);

    List<Address> list();

    Address getByUserId(String id);
}
