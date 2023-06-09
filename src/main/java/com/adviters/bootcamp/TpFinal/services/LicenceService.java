package com.adviters.bootcamp.TpFinal.services;

import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.LicenceDto;
import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.entities.Licence;
import com.adviters.bootcamp.TpFinal.entities.User;
import com.adviters.bootcamp.TpFinal.exceptions.user.LicenceNotFoundException;
import com.adviters.bootcamp.TpFinal.exceptions.user.UserNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.LicenceMapper;
import com.adviters.bootcamp.TpFinal.mappers.LicenceWhitoutRelationMapper;
import com.adviters.bootcamp.TpFinal.reposiories.LicenceRepository;
import com.adviters.bootcamp.TpFinal.reposiories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LicenceService {
    private final LicenceRepository licenceRepository;
    private final LicenceMapper licenceMapper;
    private final LicenceWhitoutRelationMapper licenceWhitoutRelationMapper;
    private final UserRepository userRepository;

    public LicenceService(UserRepository userRepository, LicenceRepository licenceRepository, LicenceMapper licenceMapper, LicenceWhitoutRelationMapper licenceWhitoutRelationMapper){
        this.licenceMapper = licenceMapper;
        this.licenceRepository = licenceRepository;
        this.licenceWhitoutRelationMapper = licenceWhitoutRelationMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addLicence(LicenceDto licenceDto){
        if(!userRepository.existsById(licenceDto.getFkUserSupervice().getId())){
         throw new UserNotFoundException(Constants.SUPERVICER_NOT_FOUND + licenceDto.getFkUserSupervice().getId());
        }
        log.info(licenceDto.toString());
        Licence licence = licenceMapper.convertToEntity(licenceDto);
        log.info(licence.toString());
        licenceRepository.save(licence);
    }

    public void updateLicence(Long id, LicenceDto licenceDto){
        if(!licenceRepository.existsById(id)){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        Licence licence = licenceRepository.findById(id).get();
        licenceDto.setId(id);
        licence = licenceMapper.convertToEntity(licenceDto);
        licenceRepository.save(licence);
    }

    public LicenceDto getLicence(Long id){
        Optional<Licence> licence = licenceRepository.findById(id);
        if(licence.isEmpty()){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        return licenceMapper.convertToDto(licence.get());
    }
    public List<LicenceDto>  getLicenceBySupervicer(Long id){
        User user = new User();
        user.setId(id);
        List<Licence> licences = licenceRepository.findLicencByfkUserSupervice(user);
        return licenceWhitoutRelationMapper.ListConvertToDto(licences);
    }


    @Transactional
    public List<LicenceDto> getAllLicence(){
        List<Licence> licences = licenceRepository.findAll();

        return licenceWhitoutRelationMapper.ListConvertToDto(licences);
    }
    public void deleteLicence(Long id){
        if(!licenceRepository.existsById(id)){
            throw new LicenceNotFoundException(Constants.LICENCE_NOT_FOUND + id);
        }
        licenceRepository.deleteById(id);
    }
}
