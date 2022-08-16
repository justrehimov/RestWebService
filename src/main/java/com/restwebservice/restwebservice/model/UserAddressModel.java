package com.restwebservice.restwebservice.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

@Data
public class UserAddressModel {
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String address_id;
}
