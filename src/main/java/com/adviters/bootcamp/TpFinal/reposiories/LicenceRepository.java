package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.Licence;
import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//Interfaz para utilizar el JPA.
public interface LicenceRepository extends JpaRepository<Licence, Long> {
    //Obtener todas licencias que un usuario administra.
    List<Licence> findLicencByfkUserSupervice(
            @Param("fkUserSupervice") User fkUserSupervice);
    //Eliminar licencia de un usuario.
    void deleteLicencesByfkUser(
            @Param("fkUser") User fkUser);

}
