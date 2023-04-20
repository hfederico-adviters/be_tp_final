package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.HolidaysDto;
import com.adviters.bootcamp.TpFinal.entities.Holidays;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HolidaysMapper {
    private final ModelMapper holidaysMapper;
    public HolidaysMapper() {this.holidaysMapper = new ModelMapper();}

    public List<HolidaysDto> ListConvertToDto(List<Holidays> holidaysList){
        List<HolidaysDto> holidaysDtoList = new ArrayList<>();
        for (Holidays holidays:holidaysList){
            holidaysDtoList.add(holidaysMapper.map(holidays, HolidaysDto.class));

        }
        return holidaysDtoList;
    }

    public HolidaysDto convertToDto(Holidays holidays){return holidaysMapper.map(holidays, HolidaysDto.class);}
    public Holidays convertToEntity(HolidaysDto holidaysDto){return holidaysMapper.map(holidaysDto, Holidays.class);}
}
