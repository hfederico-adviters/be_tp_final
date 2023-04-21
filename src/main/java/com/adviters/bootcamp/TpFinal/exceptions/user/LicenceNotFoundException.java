package com.adviters.bootcamp.TpFinal.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Clase para el manejo de mensaje de error.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LicenceNotFoundException extends RuntimeException{
    public LicenceNotFoundException(String message){super(message);}
}
