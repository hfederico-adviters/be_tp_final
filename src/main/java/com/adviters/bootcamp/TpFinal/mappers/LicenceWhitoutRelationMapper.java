package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceBasicDto;
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

    public List<LicenceBasicDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceBasicDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceWhitoutRelationMapper.map(licence, LicenceBasicDto.class));
        }
        return licenceDtoList;
    }
    public LicenceBasicDto convertToDto(Licence licence){return licenceWhitoutRelationMapper.map(licence, LicenceBasicDto.class);}
    public Licence convertToEntity(LicenceBasicDto licenceBasicDto){return licenceWhitoutRelationMapper.map(licenceBasicDto, Licence.class);}
}
