package com.adviters.bootcamp.TpFinal.services;

import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import com.adviters.bootcamp.TpFinal.exceptions.user.UserNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.UserMapper;
import com.adviters.bootcamp.TpFinal.reposiories.LicenceRepository;
import com.adviters.bootcamp.TpFinal.reposiories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Log4j2
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LicenceRepository licenceRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, LicenceRepository licenceRepository){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.licenceRepository = licenceRepository;
    }

    public void addUser(UserDto userDto){
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    public void updateUser(Long id, UserDto userDto){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        User user = userRepository.findById(id).get();
        userDto.setId(id);
        user   = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    public UserDto getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        return userMapper.convertToDto(user.get());
    }

    @Transactional
    public List<UserDto> getSupervice(Boolean administrator){
        List <User> userList = userRepository.findAllByadministrator(administrator);
        return userMapper.ListConvertToDto(userList);
    }

    public List<UserDto> getAllUser(){
        List<User> users = userRepository.findAll();
        return userMapper.ListConvertToDto(users);
    }

    @Transactional
    public void deleteUser(Long id){

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }

        User user = new User();
        user.setId(id);
        licenceRepository.deleteLicencesByfkUser(user);

        userRepository.deleteById(id);
    }

    public User getUserByEmailAndPassword(String email, String password){

        return userRepository.findUserByEmailAndPassword(email, password);
    }

}
