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
    private Long id;
    @XmlElement(name = "id")
    private String name;
    @XmlElement(name = "id")
    private String surname;
    @XmlElement(name = "id")
    private Integer age;
    @XmlElement(name = "id")
    private Status status;
}
