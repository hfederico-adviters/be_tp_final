package com.adviters.bootcamp.TpFinal.dto;

import com.adviters.bootcamp.TpFinal.entities.LicenceType;
import com.adviters.bootcamp.TpFinal.entities.User;
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
    private LicenceType licenceType;
    private UserBasicDto fkUserSupervice;
    private UserBasicDto fkUser;
}
