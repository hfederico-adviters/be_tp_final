package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBasicDto {
    private Long id;
    private String image;
    private String firstName;
    private String lastName;
    //private UserBasicDto idUserSupervice;
    private String dni;
    private String email;
    private Boolean administrator;
    //private UserBasicDto licenceSuperviced;
}
