package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO con campos basicos y necesarios del usuario.
public class UserBasicDto {
    private Long id;
    private String image;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private Boolean administrator;
}
