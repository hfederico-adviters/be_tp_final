package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.HolidaysDto;
import com.adviters.bootcamp.TpFinal.entities.Holidays;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Clase mapper para el mapeo entre el dto y la entidad.
@Component
public class HolidaysMapper {
    private final ModelMapper holidaysMapper;
    public HolidaysMapper() {this.holidaysMapper = new ModelMapper();}
    //Convierte las entdidades de feriados en una lista de feriados como DTO.
    public List<HolidaysDto> ListConvertToDto(List<Holidays> holidaysList){
        List<HolidaysDto> holidaysDtoList = new ArrayList<>();
        for (Holidays holidays:holidaysList){
            holidaysDtoList.add(holidaysMapper.map(holidays, HolidaysDto.class));
        }
        return holidaysDtoList;
    }
    //Convierte lista de DTO en una lista de entidades.
    public List<Holidays> ListConvertToEntity(List<HolidaysDto> holidaysDtoList){
        List<Holidays> holidaysList = new ArrayList<>();
        for(HolidaysDto holidaysDto:holidaysDtoList){
            holidaysList.add(holidaysMapper.map(holidaysDto, Holidays.class));
        }
        return holidaysList;
    }
    //convierte una entidad en un DTO.
    public HolidaysDto convertToDto(Holidays holidays){return holidaysMapper.map(holidays, HolidaysDto.class);}
    //Convierte un DTO en una entidad.
    public Holidays convertToEntity(HolidaysDto holidaysDto){return holidaysMapper.map(holidaysDto, Holidays.class);}
}
