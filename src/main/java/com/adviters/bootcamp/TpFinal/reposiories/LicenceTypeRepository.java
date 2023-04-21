package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.LicenceType;
import org.springframework.data.jpa.repository.JpaRepository;
//Interfaz para utilizar el JPA.
public interface LicenceTypeRepository extends JpaRepository<LicenceType, Long> {
}
