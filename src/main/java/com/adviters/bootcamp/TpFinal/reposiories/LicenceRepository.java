package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.Licence;
import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LicenceRepository extends JpaRepository<Licence, Long> {
    List<Licence> findLicencByfkUserSupervice(
            @Param("fkUserSupervice") User fkUserSupervice);
}
