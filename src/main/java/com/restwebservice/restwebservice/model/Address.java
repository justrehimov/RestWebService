package com.restwebservice.restwebservice.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class Address {
    private String id;
    private String address;
    private String zipcode;
}
