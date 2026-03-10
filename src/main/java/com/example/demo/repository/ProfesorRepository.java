package com.example.demo.repository;

import com.example.demo.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    Optional<Profesor> findByDni(String dni);
}