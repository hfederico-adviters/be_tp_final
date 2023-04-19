package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceWhitoutRelationDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Log4j2
@Component
public class LicenceWhitoutRelationMapper {
    private final ModelMapper licenceWhitoutRelationMapper;
    public LicenceWhitoutRelationMapper(){
        this.licenceWhitoutRelationMapper = new ModelMapper();
    }

    public List<LicenceWhitoutRelationDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceWhitoutRelationDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceWhitoutRelationMapper.map(licence, LicenceWhitoutRelationDto.class));
        }
        return licenceDtoList;
    }
    public LicenceWhitoutRelationDto convertToDto(Licence licence){return licenceWhitoutRelationMapper.map(licence, LicenceWhitoutRelationDto.class);}
    public Licence convertToEntity(LicenceWhitoutRelationDto licenceWhitoutRelationDto){return licenceWhitoutRelationMapper.map(licenceWhitoutRelationDto, Licence.class);}
}
