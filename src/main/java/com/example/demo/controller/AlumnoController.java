package com.example.demo.controller;

import com.example.demo.repository.AlumnoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoRepository alumnoRepository;

    public AlumnoController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return "alumnos/lista";
    }
}