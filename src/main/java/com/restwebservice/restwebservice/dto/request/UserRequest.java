package com.restwebservice.restwebservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class UserRequest {
    private String name;
    private String surname;
    private int age;

    @JsonProperty("address")
    private AddressRequest addressRequest;
}
