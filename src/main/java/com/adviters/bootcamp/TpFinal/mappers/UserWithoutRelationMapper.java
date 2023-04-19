package com.adviters.bootcamp.TpFinal.mappers;

import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.dto.UserWithoutRelationDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserWithoutRelationMapper {
    private final ModelMapper userWithoutRelationMapper;
    public UserWithoutRelationMapper(){this.userWithoutRelationMapper = new ModelMapper();}

    public List<UserWithoutRelationDto> ListConvertToDto(List<User> userList){
        List<UserWithoutRelationDto> userWithoutRelationDTOList = new ArrayList<>();
        for(User user: userList){
            userWithoutRelationDTOList.add(userWithoutRelationMapper.map(user, UserWithoutRelationDto.class));
        }
        return userWithoutRelationDTOList;
    }
    public UserWithoutRelationDto convertToDto(User user){return userWithoutRelationMapper.map(user, UserWithoutRelationDto.class);}

    public User convertToEntity(UserWithoutRelationDto userWithoutRelationDto){return userWithoutRelationMapper.map(userWithoutRelationDto, User.class);}
}

