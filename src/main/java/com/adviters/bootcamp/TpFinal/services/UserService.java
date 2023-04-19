package com.adviters.bootcamp.TpFinal.services;

import com.adviters.bootcamp.TpFinal.constants.Constants;
import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.dto.UserWithoutRelationDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import com.adviters.bootcamp.TpFinal.exceptions.user.UserNotFoundException;
import com.adviters.bootcamp.TpFinal.mappers.UserMapper;
import com.adviters.bootcamp.TpFinal.mappers.UserWithoutRelationMapper;
import com.adviters.bootcamp.TpFinal.reposiories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserWithoutRelationMapper userWithoutRelationMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserWithoutRelationMapper userWithoutRelationMapper){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.userWithoutRelationMapper = userWithoutRelationMapper;
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

    public List<UserWithoutRelationDto> getAllUser(){

        List<User> users = userRepository.findAll();

        return userWithoutRelationMapper.ListConvertToDto(users);
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        userRepository.deleteById(id);
    }

}
