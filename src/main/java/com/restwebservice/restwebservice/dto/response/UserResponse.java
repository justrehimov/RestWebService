package com.restwebservice.restwebservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class UserResponse {
    private String id;
    private String name;
    private String surname;
    private int age;

    @JsonProperty("address")
    private AddressResponse addressResponse;
}
