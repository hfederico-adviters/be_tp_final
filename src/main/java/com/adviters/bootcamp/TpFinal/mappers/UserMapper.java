package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Component
//Clase mapper para el mapeo entre el dto y la entidad.
public class UserMapper {
    private final ModelMapper userMapper;
    public UserMapper(){this.userMapper = new ModelMapper();}
    //Convierte las entdidades de usuarios en una lista de usuarios como DTO.
    public List<UserDto> ListConvertToDto(List<User> userList){
        List<UserDto> userDTOList = new ArrayList<>();
        for(User user: userList){
            userDTOList.add(userMapper.map(user, UserDto.class));
        }
        return userDTOList;
    }
    //convierte una entidad en un DTO.
    public UserDto convertToDto(User user){return userMapper.map(user, UserDto.class);}
    //Convierte un DTO en una entidad.
    public User convertToEntity(UserDto userDto){return userMapper.map(userDto, User.class);}
}
