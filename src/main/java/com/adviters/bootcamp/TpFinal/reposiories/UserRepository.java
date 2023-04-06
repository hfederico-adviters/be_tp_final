package com.adviters.bootcamp.TpFinal.reposiories;

import com.adviters.bootcamp.TpFinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
