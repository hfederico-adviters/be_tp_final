package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceTypeDto;
import com.adviters.bootcamp.TpFinal.entities.LicenceType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Clase mapper para el mapeo entre el dto y la entidad.
@Component
public class LicenceTypeMapper {
    private final ModelMapper licenceTypeMapper;

    public LicenceTypeMapper(){this.licenceTypeMapper = new ModelMapper();}
    //Convierte las entdidades de tipo de licencias en una lista de licencias como DTO.
    public List<LicenceTypeDto> ListConvertToDto(List<LicenceType> licenceTypeList){
        List<LicenceTypeDto> licenceTypeDtoList = new ArrayList<>();
        for(LicenceType licenceType:licenceTypeList){
            licenceTypeDtoList.add(licenceTypeMapper.map(licenceType, LicenceTypeDto.class));
        }
        return licenceTypeDtoList;
    }
    //convierte una entidad en un DTO.
    public LicenceTypeDto convertToDto(LicenceType licenceType){
        return licenceTypeMapper.map(licenceType, LicenceTypeDto.class);
    }
    //Convierte un DTO en una entidad.
    public LicenceType converToEntity(LicenceTypeDto licenceTypeDto){
        return licenceTypeMapper.map(licenceTypeDto, LicenceType.class);
    }
}
