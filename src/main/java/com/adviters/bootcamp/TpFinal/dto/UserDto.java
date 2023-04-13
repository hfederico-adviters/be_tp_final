package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String image;
    private String firstName;
    private String lastName;
    private String password;
    private Long idUserSupervice;
    private String birthday;
    private String arriveDate;
    private String dni;
    private String cuil;
    private String email;
    private String cellphone;
    private String address;
    private Integer addressNumber;
    private Integer postalCode;
    private String tower;
    private String floor;
    private String flat;
    private String city;
    private String province;
    private String country;
    private Integer holidays;
    private Boolean administrator;
}
