package com.adviters.bootcamp.TpFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Configuracion del cors para la conexion con el front.
@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //Endpoints donde se acepta el cors.
                registry.addMapping("/api/v1/**")
                        //Seteo de origen donde proviene la peticion.
                        .allowedOrigins("*")
                        //metodos que acepta y encapsula.
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                        .maxAge(3600);
            }
        };
    }
}
