package com.adviters.bootcamp.TpFinal.entities;

import lombok.*;

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



    @Column(name = "id_user_supervice")
    private Long idUserSupervice;


    @Column(name = "fk_licence_type")
    private Long fkLicenceType;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_user_id",referencedColumnName = "id")
    private User user;

}
