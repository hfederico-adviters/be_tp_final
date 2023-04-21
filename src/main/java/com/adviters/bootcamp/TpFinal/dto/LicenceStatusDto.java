package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//Dto para el manejo de status de licencias.
public class LicenceStatusDto {
    private Long id;
    private String description;
}
