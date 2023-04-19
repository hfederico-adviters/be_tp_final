package com.adviters.bootcamp.TpFinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenceBasicDto {
    private Long id;
    private String startDate;
    private String endDate;
    private String description;
    private Long fkLicenceType;
    private UserBasicDto fkUserSupervice;
    private UserBasicDto fkUser;
}
