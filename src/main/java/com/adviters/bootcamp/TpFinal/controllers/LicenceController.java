package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.services.LicenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/licence/")
public class LicenceController {
    private final LicenceService licenceService;
    public LicenceController(LicenceService licenceService){this.licenceService = licenceService;}

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLicence(@RequestBody LicenceDto licenceDto){licenceService.addLicence(licenceDto);}

    @PostMapping(value = "update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLicence(@RequestBody LicenceDto licenceDto, @PathVariable("id") Long id){
        licenceService.updateLicence(id, licenceDto);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public LicenceDto getLicence(@PathVariable("id") Long id){
        return licenceService.getLicence(id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<LicenceDto> getAllLicence(){return licenceService.getAllLicence();}

    @GetMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLicence(@PathVariable("id") Long id){licenceService.deleteLicence(id);}
}