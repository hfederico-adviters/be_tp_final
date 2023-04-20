package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenceDto {
    private Long id;
    private String startDate;
    private String endDate;
    private String description;
    private LicenceTypeDto licenceType;
    private UserBasicDto fkUserSupervice;
    private UserBasicDto fkUser;
    private LicenceStatusDto licenceStatus;
}
