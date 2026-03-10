package com.example.demo.repository;

import com.example.demo.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Optional<Alumno> findByDni(String dni);
}