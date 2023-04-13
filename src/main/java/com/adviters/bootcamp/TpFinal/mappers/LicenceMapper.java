package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LicenceMapper {
    private final ModelMapper licenceMapper;
    public LicenceMapper(){
        this.licenceMapper = new ModelMapper();
    }

    public List<LicenceDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceMapper.map(licence, LicenceDto.class));
        }
        return licenceDtoList;
    }
    public LicenceDto convertToDto(Licence licence){return licenceMapper.map(licence, LicenceDto.class);}
    public Licence convertToEntity(LicenceDto licenceDto){return licenceMapper.map(licenceDto, Licence.class);}
}
