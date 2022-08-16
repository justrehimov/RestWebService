package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.db.DbManager;
import com.restwebservice.restwebservice.model.Address;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class AddressDaoImpl implements AddressDao{

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(DbManager.getDataSource());

    @Override
    public Address save(Address address) {
        String id = UUID.randomUUID().toString();
        jdbcTemplate.update("insert into address(id, address, zipcode) values(?, ?, ?)",
                id,address.getAddress(), address.getZipcode());
        return getById(id);
    }

    @Override
    public Address getById(String id) {
       return jdbcTemplate.queryForObject("select * from address where id = ?" ,new Object[]{id},new BeanPropertyRowMapper<>(Address.class));
    }

    @Override
    public List<Address> list() {
        return jdbcTemplate.query("select * from address",new BeanPropertyRowMapper<>(Address.class));
    }

    @Override
    public Address getByUserId(String id) {
        return jdbcTemplate.queryForObject("select a.id, a.address, a.zipcode from users u inner join address a on u.address_id = a.id where u.id = ? ",
                new Object[]{id},new BeanPropertyRowMapper<>(Address.class));
    }

}
