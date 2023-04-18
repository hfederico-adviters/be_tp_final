package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceWhitoutRelationDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LicenceWhitoutRelationMapper {
    private final ModelMapper licenceMapper;
    public LicenceWhitoutRelationMapper(){
        this.licenceMapper = new ModelMapper();
    }

    public List<LicenceWhitoutRelationDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceWhitoutRelationDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceMapper.map(licence, LicenceWhitoutRelationDto.class));
        }
        return licenceDtoList;
    }
    public LicenceWhitoutRelationDto convertToDto(Licence licence){return licenceMapper.map(licence, LicenceWhitoutRelationDto.class);}
    public Licence convertToEntity(LicenceWhitoutRelationDto licenceWhitoutRelationDto){return licenceMapper.map(licenceWhitoutRelationDto, Licence.class);}
}
