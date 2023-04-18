package com.adviters.bootcamp.TpFinal.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LicenceTypeNotFoundException extends RuntimeException{
    public LicenceTypeNotFoundException(String message){super(message);}
}
