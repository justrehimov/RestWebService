package com.restwebservice.restwebservice.dto.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class AddressResponse {
    private String address;
    private String zipcode;
}
