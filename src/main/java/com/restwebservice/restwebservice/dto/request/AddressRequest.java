package com.restwebservice.restwebservice.dto.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class AddressRequest {
    private String address;
    private String zipcode;
}
