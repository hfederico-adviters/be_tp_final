package com.adviters.bootcamp.TpFinal.controllers;
import com.adviters.bootcamp.TpFinal.dto.UserCredentialDto;
import com.adviters.bootcamp.TpFinal.dto.UserDto;
import com.adviters.bootcamp.TpFinal.entities.User;
import com.adviters.bootcamp.TpFinal.exceptions.user.UserNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adviters.bootcamp.TpFinal.services.UserService;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    @GetMapping(value = "supervicer/{administrator}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getSupervice(@PathVariable("administrator") Boolean administrator){
        return userService.getSupervice(administrator);
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

    //Login de usuario
    @PostMapping(value ="login")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<String> loginUser(@RequestBody UserCredentialDto userCredentialDto){
//        return Collections.singletonMap("token", userCredentialDto.toString());
        try {
            if(userCredentialDto.getEmail() == null || userCredentialDto.getPassword() == null) {
                throw new UserNotFoundException("User or Password is Empty");
            }
            User userData = userService.getUserByEmailAndPassword(userCredentialDto.getEmail(), userCredentialDto.getPassword());
            if(userData == null){
                throw new UserNotFoundException("UserName or Password is Invalid");
            }
            Instant now = Instant.now();
            String jwt = Jwts.builder()
                    .setIssuer("Tp_final")
                    .setSubject("guccigang")
                    .claim("name", userData.getEmail())
                    .claim("scope", userData.getAdministrator() ? "administrator" : "user")
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plus(30, ChronoUnit.DAYS)))
                    .signWith(
                            SignatureAlgorithm.HS256,
                            "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=".getBytes("UTF-8")
                    )
                    .compact();
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
