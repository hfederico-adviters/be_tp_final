package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    private final ModelMapper userMapper;
    public UserMapper(){this.userMapper = new ModelMapper();}

    public List<UserDto> ListConvertToDto(List<User> userList){
        List<UserDto> userDTOList = new ArrayList<>();
        for(User user: userList){
            userDTOList.add(userMapper.map(user, UserDto.class));
        }
        return userDTOList;
    }
    public UserDto convertToDto(User user){return userMapper.map(user, UserDto.class);}

    public User convertToEntity(UserDto userDto){return userMapper.map(userDto, User.class);}
}
