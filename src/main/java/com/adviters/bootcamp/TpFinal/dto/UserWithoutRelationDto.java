package com.adviters.bootcamp.TpFinal.dto;

import com.adviters.bootcamp.TpFinal.entities.Licence;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithoutRelationDto {
    private Long id;
    private String image;
    private String firstName;
    private String lastName;
    private Long idUserSupervice;
    private String dni;
    private String email;
    private Boolean administrator;
    private List<LicenceWhitoutRelationDto> licenceWhitoutRelationDtoList;
}
