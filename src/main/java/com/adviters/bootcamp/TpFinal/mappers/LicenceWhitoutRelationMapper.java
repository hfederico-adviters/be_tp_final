package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
//Clase mapper para el mapeo entre el dto y la entidad.
public class LicenceWhitoutRelationMapper {
    private final ModelMapper licenceWhitoutRelationMapper;
    public LicenceWhitoutRelationMapper(){
        this.licenceWhitoutRelationMapper = new ModelMapper();
    }
    //Convierte las entdidades de licencia sin relacion en una lista de licencia sin relacion como DTO.
    public List<LicenceDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceWhitoutRelationMapper.map(licence, LicenceDto.class));
        }
        return licenceDtoList;
    }
    //convierte una entidad en un DTO.
    public LicenceDto convertToDto(Licence licence){return licenceWhitoutRelationMapper.map(licence, LicenceDto.class);}
    //Convierte un DTO en una entidad.
    public Licence convertToEntity(LicenceDto licenceBasicDto){return licenceWhitoutRelationMapper.map(licenceBasicDto, Licence.class);}
}
