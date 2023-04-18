package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceTypeDto;
import com.adviters.bootcamp.TpFinal.entities.LicenceType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LicenceTypeMapper {
    private final ModelMapper licenceTypeMapper;

    public LicenceTypeMapper(){this.licenceTypeMapper = new ModelMapper();}

    public List<LicenceTypeDto> ListConvertToDto(List<LicenceType> licenceTypeList){
        List<LicenceTypeDto> licenceTypeDtoList = new ArrayList<>();
        for(LicenceType licenceType:licenceTypeList){
            licenceTypeDtoList.add(licenceTypeMapper.map(licenceType, LicenceTypeDto.class));
        }
        return licenceTypeDtoList;
    }

    public LicenceTypeDto convertToDto(LicenceType licenceType){
        return licenceTypeMapper.map(licenceType, LicenceTypeDto.class);
    }

    public LicenceType converToEntity(LicenceTypeDto licenceTypeDto){
        return licenceTypeMapper.map(licenceTypeDto, LicenceType.class);
    }
}
