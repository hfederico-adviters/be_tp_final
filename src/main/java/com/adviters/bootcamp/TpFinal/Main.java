package com.adviters.bootcamp.TpFinal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();
    }
}


//Con Docker levante una instancia de Postgres
//Con DataGrip cree una DB en la instancia creada con Docker