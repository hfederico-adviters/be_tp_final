package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Clase mapper para el mapeo entre el dto y la entidad.
@Component
public class LicenceMapper {
    private final ModelMapper licenceMapper;
    public LicenceMapper(){
        this.licenceMapper = new ModelMapper();
    }
    //Convierte las entdidades de licencias en una lista de licencias como DTO.
    public List<LicenceDto> ListConvertToDto(List<Licence> licenceList){
        List<LicenceDto> licenceDtoList = new ArrayList<>();
        for(Licence licence:licenceList){
            licenceDtoList.add(licenceMapper.map(licence, LicenceDto.class));
        }
        return licenceDtoList;
    }
    //convierte una entidad en un DTO.
    public LicenceDto convertToDto(Licence licence){return licenceMapper.map(licence, LicenceDto.class);}
    //Convierte un DTO en una entidad.
    public Licence convertToEntity(LicenceDto licenceDto){return licenceMapper.map(licenceDto, Licence.class);}
}
