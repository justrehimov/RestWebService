package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.model.Address;
import com.restwebservice.restwebservice.model.User;

import java.util.List;

public interface AddressDao {
    Address save(Address address) throws Exception;

    Address getById(String id) throws Exception;

    List<Address> list() throws Exception;

    Address getByUserId(String id) throws Exception;

    Address update(String userId, Address address) throws Exception;

    Address delete(String userId, User user) throws Exception;
}
