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
public class HolidaysService {
    private final HolidaysRepository holidaysRepository;
    private final HolidaysMapper holidaysMapper;


    public HolidaysService(HolidaysRepository holidaysRepository, HolidaysMapper holidaysMapper){
        this.holidaysMapper = holidaysMapper;
        this.holidaysRepository = holidaysRepository;

    }


    @Transactional
    public void addHolidays(HolidaysDto holidaysDto){
        Holidays holidays = holidaysMapper.convertToEntity(holidaysDto);
        holidaysRepository.save(holidays);
    }

    public HolidaysDto getHolidays(Long id){
        Optional<Holidays> holidays = holidaysRepository.findById(id);
        if(holidays.isEmpty()){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        return holidaysMapper.convertToDto(holidays.get());
    }

    public List<HolidaysDto> getAllHolidays(){

        List<Holidays> holidays = holidaysRepository.findAll();

        return holidaysMapper.ListConvertToDto(holidays);
    }


}
