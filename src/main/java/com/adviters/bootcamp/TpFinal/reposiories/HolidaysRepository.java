package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
//Interfaz para utilizar el JPA.
public interface HolidaysRepository extends JpaRepository<Holidays, Long> {

}
