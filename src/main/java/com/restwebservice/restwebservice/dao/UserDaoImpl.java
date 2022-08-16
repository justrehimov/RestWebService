package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.db.DbManager;
import com.restwebservice.restwebservice.model.Address;
import com.restwebservice.restwebservice.model.User;
import com.restwebservice.restwebservice.model.UserAddressModel;
import com.restwebservice.restwebservice.service.AddressService;
import com.restwebservice.restwebservice.service.AddressServiceImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements UserDao{

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(DbManager.getDataSource());

    private final AddressService addressService = new AddressServiceImpl();
    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<User> list() {
        List<UserAddressModel> addressModels =
                jdbcTemplate.query("select * from users",new BeanPropertyRowMapper<>(UserAddressModel.class));
        List<User> userList = new ArrayList<>();
        for(UserAddressModel uam: addressModels){
            User user = new User();
            user.setId(uam.getId());
            user.setName(uam.getName());
            user.setSurname(uam.getSurname());
            user.setAge(uam.getAge());
            user.setAddress(addressService.getById(uam.getAddress_id()));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User save(User user) {
        String id = UUID.randomUUID().toString();
        Address address = addressDao.save(user.getAddress());
        jdbcTemplate.update("insert into users(id,name,surname,age,address_id) values(?,?,?,?,?)",
                id,user.getName(),user.getSurname(),user.getAge(),address.getId());
        return getById(id);
    }

    @Override
    public User getById(String id) {
        User user = jdbcTemplate.queryForObject("select * from users where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(User.class));
        Address address = addressService.getByUserId(id);
        user.setAddress(address);
        return user;
    }
}
