package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO para el manejo de credenciales.
public class UserCredentialDto {
    private String password;
    private String email;
}
