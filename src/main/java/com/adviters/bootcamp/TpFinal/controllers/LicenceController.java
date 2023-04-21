package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.services.LicenceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador de las licencias
@RestController
@Log4j2
@RequestMapping(path = "api/v1/licence/")
public class LicenceController {
    private final LicenceService licenceService;

    public LicenceController(LicenceService licenceService) {
        this.licenceService = licenceService;
    }

    //Agrega Licencia.
    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLicence(@RequestBody LicenceDto licenceDto) {
        log.info(licenceDto.getLicenceStatus().toString());
        licenceService.addLicence(licenceDto);
    }

    //Modifica licencia por id.
    @PutMapping(value = "update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLicence(@RequestBody LicenceDto licenceDto, @PathVariable("id") Long id) {
        licenceService.updateLicence(id, licenceDto);
    }

    //Obtiene todas las licencias de un administrador, por id.
    @GetMapping(value = "/licenceBySupervice/{idSupervicer}")
    @ResponseStatus(HttpStatus.OK)
    public List<LicenceDto> getAllLicenceBySupervicer(@PathVariable("idSupervicer") Long idSupervicer){
        return licenceService.getLicenceBySupervicer(idSupervicer);
    }

    //Obtiene una licencia por id.
    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public LicenceDto getLicence(@PathVariable("id") Long id) {
        return licenceService.getLicence(id);
    }

    //Obtiene todas licencias.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<LicenceDto> getAllLicence() {
        return licenceService.getAllLicence();
    }

    //Elimina licencia por id.
    @DeleteMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLicence(@PathVariable("id") Long id){licenceService.deleteLicence(id);}
}
