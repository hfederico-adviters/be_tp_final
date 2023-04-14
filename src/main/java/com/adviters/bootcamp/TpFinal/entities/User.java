package com.adviters.bootcamp.TpFinal.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "UserTable")
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image")
    private String image;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "fk_user_supervice")
    private Long idUserSupervice;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "arrive_date")
    private String arriveDate;
    @Column(name = "dni")
    private String dni;
    @Column(name = "cuil")
    private String cuil;
    @Column(name = "email")
    private String email;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "address")
    private String address;
    @Column(name = "address_number")
    private Integer addressNumber;
    @Column(name = "postal_code")
    private Integer postalCode;
    @Column(name = "tower")
    private String tower;
    @Column(name = "floor")
    private String floor;
    @Column(name = "flat")
    private String flat;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;
    @Column(name = "holidays")
    private Integer holidays;
    @Column(name = "administrator")
    private Boolean administrator;
    @Column(name = "available_vacation_days")
    private Integer  availableVacationsDays;
    @Column(name = "available_study_days")
    private Integer availableStudyDays;

    @OneToMany(mappedBy = "user", targetEntity = Licence.class)
    private List<Licence> licenceList;
}
