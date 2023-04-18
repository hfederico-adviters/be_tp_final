package com.adviters.bootcamp.TpFinal.dto;

import com.adviters.bootcamp.TpFinal.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenceWhitoutRelationDto {
    private Long id;
    private String startDate;
    private String endDate;
    private String description;
    private Long fkLicenceType;
    private Long fkUserSupervice;
    private UserDto fkUser;
}
