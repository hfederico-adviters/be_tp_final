package com.adviters.bootcamp.TpFinal.entities;

import com.adviters.bootcamp.TpFinal.dto.UserBasicDto;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "UserTable")
@Table(name = "user_table")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
//Entidad para el manejo de usuarios.
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
    @Column(name = "birthday")
    private String birthday;
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
    @Column(name = "administrator")
    private Boolean administrator;
    @Column(name = "available_vacation_days")
    private Integer availableVacationsDays;
    @Column(name = "available_study_days")
    private Integer availableStudyDays;
    @Column(name = "arrive_date")
    private String arriveDate;
    //Join a mismo user para setear quien es el supervisor. Haciendo un join MUCHOS a UNO.
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "fk_user_supervice_id",referencedColumnName ="id")
    private User userSupervicer;
    //Join a mismo user para saber quien es el supervisor. Haciendo un join UNO a MUCHOS.
    @OneToMany (mappedBy = "userSupervicer", targetEntity = User.class, fetch = FetchType.LAZY)
    private List<User> supervicedUserList;
    //Join a licencia, para obtener todas las licencias que pertenece al usario. Haciendo un join UNO a MUCHOS.
    @OneToMany(mappedBy = "fkUser" , targetEntity = Licence.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Licence> licenceList;
    //Join a licencia, para obtener todas las licencias que administra el usuario. Haciendo un join UNO a MUCHOS.
    @OneToMany(mappedBy = "fkUserSupervice" , targetEntity = Licence.class, fetch = FetchType.LAZY)
    private List<Licence> licenceSupervicedList;
}
