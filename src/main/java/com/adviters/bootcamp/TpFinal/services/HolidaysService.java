package com.adviters.bootcamp.TpFinal.services;
import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.HolidaysDto;
import com.adviters.bootcamp.TpFinal.entities.Holidays;
import com.adviters.bootcamp.TpFinal.exceptions.user.UserNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.HolidaysMapper;
import com.adviters.bootcamp.TpFinal.reposiories.HolidaysRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
//Servicio para el manejo de feriados.
public class HolidaysService {
    private final HolidaysRepository holidaysRepository;
    private final HolidaysMapper holidaysMapper;
    public HolidaysService(HolidaysRepository holidaysRepository, HolidaysMapper holidaysMapper){
        this.holidaysMapper = holidaysMapper;
        this.holidaysRepository = holidaysRepository;

    }
    //Añadir un feriado.
    @Transactional
    public void addHolidays(HolidaysDto holidaysDto){
        Holidays holidays = holidaysMapper.convertToEntity(holidaysDto);
        holidaysRepository.save(holidays);
    }
    //Añade todos los feriados.
    public void addAllHolidays(List<HolidaysDto> holidaysDtoList){
        List<Holidays> holidaysList = holidaysMapper.ListConvertToEntity(holidaysDtoList);
        holidaysRepository.saveAll(holidaysList);
    }
    //Obtiene un feriado por id.
    public HolidaysDto getHolidays(Long id){
        Optional<Holidays> holidays = holidaysRepository.findById(id);
        if(holidays.isEmpty()){
            throw new UserNotFoundException(Constants.HOLIDAYS_NOT_FOUND + id);
        }
        return holidaysMapper.convertToDto(holidays.get());
    }
    //Obtiene todos los feriados.
    public List<HolidaysDto> getAllHolidays(){

        List<Holidays> holidays = holidaysRepository.findAll();

        return holidaysMapper.ListConvertToDto(holidays);
    }
}
