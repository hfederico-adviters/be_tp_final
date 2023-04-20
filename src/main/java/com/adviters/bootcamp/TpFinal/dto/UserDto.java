package com.adviters.bootcamp.TpFinal.dto;

import com.adviters.bootcamp.TpFinal.entities.Licence;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private String birthday;
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
    private Boolean administrator;
    private Integer  availableVacationsDays;
    private Integer availableStudyDays;
    private String arriveDate;

    private UserBasicDto userSupervicer;
    private List<UserBasicDto> supervicedUser;

    private List<LicenceWithoutRelaiton> licenceList;
    private List<LicenceWithoutRelaiton> licenceSupervicedList;

}
