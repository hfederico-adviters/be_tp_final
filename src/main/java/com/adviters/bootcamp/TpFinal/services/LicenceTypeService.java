
package com.adviters.bootcamp.TpFinal.services;

import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.dto.LicenceTypeDto;
import com.adviters.bootcamp.TpFinal.entities.LicenceType;
import com.adviters.bootcamp.TpFinal.exceptions.user.LicenceTypeNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.LicenceTypeMapper;
import com.adviters.bootcamp.TpFinal.reposiories.LicenceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceTypeService {
    private final LicenceTypeRepository licenceTypeRepository;
    private final LicenceTypeMapper licenceTypeMapper;
    public LicenceTypeService(LicenceTypeRepository licenceTypeRepository, LicenceTypeMapper licenceTypeMapper){
        this.licenceTypeMapper = licenceTypeMapper;
        this.licenceTypeRepository = licenceTypeRepository;
    }

    public void addLicenceType(LicenceTypeDto licenceTypeDto){
        LicenceType licenceType = licenceTypeMapper.converToEntity(licenceTypeDto);
        licenceTypeRepository.save(licenceType);
    }
    public void updateLicenceType(Long id, LicenceTypeDto licenceTypeDto){
        if(!licenceTypeRepository.existsById(id)){
            throw new LicenceTypeNotFoundException(Constants.LICENE_TYPE_NOT_FOUND + id);
        }
        LicenceType licenceType = licenceTypeRepository.findById(id).get();
        licenceTypeDto.setId(id);
        licenceType = licenceTypeMapper.converToEntity(licenceTypeDto);
        licenceTypeRepository.save(licenceType);
    }
    public LicenceTypeDto getLicenceType(Long id){
        Optional<LicenceType> licenceTypeOptional = licenceTypeRepository.findById(id);
        if(licenceTypeOptional.isEmpty()){
            throw new LicenceTypeNotFoundException(Constants.LICENE_TYPE_NOT_FOUND + id);
        }
        return licenceTypeMapper.convertToDto(licenceTypeOptional.get());
    }
    public List<LicenceTypeDto> getAllLicenceType(){
        List<LicenceType> licenceTypeList = licenceTypeRepository.findAll();
        return licenceTypeMapper.ListConvertToDto(licenceTypeList);
    }
    public void deleteLicenceType(Long id){
        if(!licenceTypeRepository.existsById(id)){
            throw new LicenceTypeNotFoundException(Constants.LICENE_TYPE_NOT_FOUND + id);
        }
        licenceTypeRepository.deleteById(id);
    }
}
