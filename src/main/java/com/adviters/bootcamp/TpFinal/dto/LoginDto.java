package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO para el manejo del Login.
public class LoginDto {
    private String token;
    private UserBasicDto user;

}
