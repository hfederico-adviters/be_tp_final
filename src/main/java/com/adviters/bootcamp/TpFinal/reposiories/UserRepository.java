package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//Interfaz para utilizar el JPA.
public interface UserRepository extends JpaRepository<User, Long> {
    //Obtener un usario por el Email y Password.
    public User findUserByEmailAndPassword(String email, String password);
    //Obtener todos los usuarios administradores.
    List<User> findAllByadministrator(
            @Param("administrator") Boolean administrator
    );

}
