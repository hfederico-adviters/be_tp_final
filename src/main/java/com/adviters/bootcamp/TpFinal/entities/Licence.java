package com.adviters.bootcamp.TpFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.loader.plan.spi.EntityFetch;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "LicenceTable")
@Table(name = "licence_table")
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


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user_id",referencedColumnName = "id")
    @JsonBackReference
    private User fkUser;

    /*
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user_supervice",referencedColumnName = "id")
    @JsonBackReference
    private User fkUserSupervice;*/


    @Column(name = "fk_licence_type")
    private Long fkLicenceType;

}
