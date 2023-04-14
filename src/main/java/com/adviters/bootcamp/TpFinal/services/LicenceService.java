package com.adviters.bootcamp.TpFinal.services;

import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import com.adviters.bootcamp.TpFinal.exceptions.user.LicenceNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.LicenceMapper;
import com.adviters.bootcamp.TpFinal.reposiories.LicenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceService {
    private final LicenceRepository licenceRepository;
    private final LicenceMapper licenceMapper;

    public LicenceService(LicenceRepository licenceRepository, LicenceMapper licenceMapper){
        this.licenceMapper = licenceMapper;
        this.licenceRepository = licenceRepository;
    }

    public void addLicence(LicenceDto licenceDto){
        Licence licence = licenceMapper.convertToEntity(licenceDto);
        licenceRepository.save(licence);
    }

    public void updateLicence(Long id, LicenceDto licenceDto){
        if(!licenceRepository.existsById(id)){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        Licence licence = licenceRepository.findById(id).get();
        licenceDto.setId(id);
        licence = licenceMapper.convertToEntity(licenceDto);
        licenceRepository.save(licence);
    }

    public LicenceDto getLicence(Long id){
        Optional<Licence> licence = licenceRepository.findById(id);
        if(licence.isEmpty()){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        return licenceMapper.convertToDto(licence.get());
    }
    public List<LicenceDto> getAllLicence(){
        List<Licence> licences = licenceRepository.findAll();
        return licenceMapper.ListConvertToDto(licences);
    }
    public void deleteLicence(Long id){
        if(!licenceRepository.existsById(id)){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        licenceRepository.deleteById(id);
    }
}
