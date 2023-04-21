package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.LicenceTypeDto;
import com.adviters.bootcamp.TpFinal.services.LicenceTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador para el tipo de licencias.
@RestController
@RequestMapping(path = "api/v1/licenceType/")
public class LicenceTypeController {
    private final LicenceTypeService licenceTypeService;

    public LicenceTypeController(LicenceTypeService licenceTypeService) {
        this.licenceTypeService = licenceTypeService;
    }

    //Agrega tipo de licencia.
    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLicenceType(@RequestBody LicenceTypeDto licenceTypeDto) {
        licenceTypeService.addLicenceType(licenceTypeDto);
    }

    //Modifica el tipo de licencia por id.
    @PutMapping(value = "update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLicenceType(@RequestBody LicenceTypeDto licenceTypeDto, @PathVariable("id") Long id) {
        licenceTypeService.updateLicenceType(id, licenceTypeDto);
    }

    //Obtiene el tipo de licencia por id.
    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public LicenceTypeDto getLicenceType(@PathVariable("id") Long id) {
        return licenceTypeService.getLicenceType(id);
    }

    //Obitene todos los tipos de licencia.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<LicenceTypeDto> getAllLicenceType(){return licenceTypeService.getAllLicenceType();}

    //Elimina el tipo de licencia por id.
    @DeleteMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLicence(@PathVariable("id") Long id){licenceTypeService.deleteLicenceType(id);}
}
