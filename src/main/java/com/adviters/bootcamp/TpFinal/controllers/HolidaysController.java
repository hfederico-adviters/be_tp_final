package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.HolidaysDto;

import com.adviters.bootcamp.TpFinal.services.HolidaysService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/holidays/")
public class HolidaysController {

    private final HolidaysService holidaysService;

    public HolidaysController(HolidaysService holidaysService){
        this.holidaysService = holidaysService;
    }

    //Crea feriados
    @PostMapping(value ="add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody HolidaysDto holidaysDTO){
        holidaysService.addHolidays(holidaysDTO);
    }


    //Obtiene todos los feriados
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<HolidaysDto> getAllHolidays(){
        return holidaysService.getAllHolidays();}

}
