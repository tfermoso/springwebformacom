package com.example.demo;

import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PruebaDatos {

    @Bean
    CommandLineRunner test(AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository) {
        return args -> {
            System.out.println("ALUMNOS:");
            alumnoRepository.findAll().forEach(System.out::println);

            System.out.println("PROFESORES:");
            profesorRepository.findAll().forEach(System.out::println);
        };
    }
}