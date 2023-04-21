package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//DTO para el manejo de licencias sin la relacion a usuarios.
public class LicenceWithoutRelaiton {private Long id;
    private String startDate;
    private String endDate;
    private String description;
    private LicenceTypeDto licenceType;
    private LicenceStatusDto licenceStatus;
}
