package com.restwebservice.restwebservice.dto.response;

import com.restwebservice.restwebservice.exceptions.Status;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
public class ResponseModel<T>{
    private T result;
    private Status status;
}
