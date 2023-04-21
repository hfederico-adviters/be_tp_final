package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.HolidaysDto;

import com.adviters.bootcamp.TpFinal.services.HolidaysService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//Controllador de los feriados.
@RestController
@RequestMapping(path = "api/v1/holidays/")
public class HolidaysController {

    private final HolidaysService holidaysService;

    public HolidaysController(HolidaysService holidaysService){
        this.holidaysService = holidaysService;
    }

    //Crea feriado
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHolidays(@RequestBody HolidaysDto holidaysDTO){
        holidaysService.addHolidays(holidaysDTO);
    }

    //Agrega varios feriados, mandando un lista del mismo.
    @PostMapping("/add/many")
    @ResponseStatus(HttpStatus.CREATED)
    public void createManyHolidays(@RequestBody List<HolidaysDto> holidaysDtoList){
        holidaysService.addAllHolidays(holidaysDtoList);
    }


    //Obtiene todos los feriados
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<HolidaysDto> getAllHolidays(){
        return holidaysService.getAllHolidays();}

}
