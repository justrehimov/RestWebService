package com.restwebservice.restwebservice.exceptions;

import lombok.Data;

@Data
public class Status {
    private String message;
    private int code;

    public static Status getSuccess(){
        Status status = new Status();
        status.setMessage("SUCCESS");
        status.setCode(200);
        return status;
    }

    public static Status createStatus(String message, int code){
        Status status = new Status();
        status.setMessage(message);
        status.setCode(code);
        return status;
    }
}
