package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/prueba")
    public String inicio() {
        return "Hola, Spring Boot funciona correctamente";
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola desde /saludo";
    }
}