package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO para el manejo de los feriados.
public class HolidaysDto {
    private Long id;
    private String date;
    private String description;
}




