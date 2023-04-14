package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenceDto {
    private Long id;
    private Long idLicenceType;
    private String startDate;
    private String endDate;
    private Long idUserSupervice;
    private String description;

}
