package com.adviters.bootcamp.TpFinal.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "LicenceStatusTable")
@Table(name = "licence_status_table")
//Entidad donde se maneja los tipos de status de licencias.
public class LicenceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
}
