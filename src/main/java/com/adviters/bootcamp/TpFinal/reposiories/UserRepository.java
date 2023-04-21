package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmailAndPassword(String email, String password);

    List<User> findAllByadministrator(
            @Param("administrator") Boolean administrator
    );

}
