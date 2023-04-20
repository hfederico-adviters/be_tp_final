package com.adviters.bootcamp.TpFinal.exceptions.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class HolidaysNotFoundException extends RuntimeException{
    public HolidaysNotFoundException(String message){super(message);}

}
