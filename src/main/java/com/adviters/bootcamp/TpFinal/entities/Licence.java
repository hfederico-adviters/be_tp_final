package com.adviters.bootcamp.TpFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Subselect;
import org.hibernate.loader.plan.spi.EntityFetch;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "LicenceTable")
@Table(name = "licence_table")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
//Entidad para el manejo de licencias.
public class Licence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "description")
    private String description;
    //Join a usuarios que supervisaran la licencia, haciendo una relacion MUCHOS a UNO.
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "fk_user_supervice",referencedColumnName = "id")
    private User fkUserSupervice;
    //Join a usuarios que le perteneceran la licencia, haciendo una relacion MUCHOS a UNO.
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "fk_user_id",referencedColumnName = "id")
    @JsonBackReference
    private User fkUser;
    //Join a tipo de licencias para identificar el tipo que tiene, haciendo una relacion UNO a UNO.
    @OneToOne(fetch = FetchType.LAZY, targetEntity = LicenceType.class)
    @JoinColumn(name = "fk_licence_type", referencedColumnName = "id")
    private LicenceType licenceType;
    //Join a estado de licencia para saber en que estado se encuentra, haceidno una relacion UNO a UNO.
    @OneToOne(fetch = FetchType.LAZY, targetEntity = LicenceStatus.class)
    @JoinColumn(name = "fk_licence_status", referencedColumnName = "id")
    private LicenceStatus licenceStatus;
}
