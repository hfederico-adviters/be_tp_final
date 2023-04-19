package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithoutRelationDto {
    private Long id;
    private String image;
    private String firstName;
    private String lastName;
    private List<UserBasicDto> idUserSupervice;
    private String dni;
    private String email;
    private Boolean administrator;
    private List<LicenceBasicDto> licenceBasicDtoList;
    private List<UserBasicDto> userBasicDtoList;
    private List<UserBasicDto> licenceSuperviced;
}
