package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO para el manejo de tipos de licencias.
public class LicenceTypeDto {
    private Long id;
    private String description;
}
