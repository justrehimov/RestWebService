package com.restwebservice.restwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(User.class)
public class User {
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "surname")
    private String surname;
    @XmlElement(name = "age")
    private Integer age;
    private Address address;
}
