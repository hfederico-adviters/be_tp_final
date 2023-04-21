package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class HolidaysDto {
    private Long id;
    private LocalDate date;
    private String description;
}




