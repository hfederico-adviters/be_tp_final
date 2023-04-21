package com.adviters.bootcamp.TpFinal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Entity(name = "HolidaysTable")
    @Table(name = "Holidays_table")
    public class Holidays {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "dateHolidays")
        private LocalDate dateHolidays;
        @Column(name = "description")
        private String description;
}

