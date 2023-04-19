package com.adviters.bootcamp.TpFinal.controllers;

import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.dto.UserWithoutRelationDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.adviters.bootcamp.TpFinal.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Crea usuario
    @PostMapping(value ="add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDTO){
        userService.addUser(userDTO);
    }
    
    //Hace un update de algun usario
    //Dependiendo la ID
    @PutMapping(value = "update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        userService.updateUser(id, userDto);
    }

    //Obtiene usuario por ID
    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    //Obtiene todos los usuarios
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUser(){return userService.getAllUser();}

    //Elimina usuario por ID
    @DeleteMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
