package com.example.demo.controller;

import com.example.demo.model.Alumno;
import com.example.demo.repository.AlumnoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("modoEdicion", false);
        return "alumnos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Alumno alumno) {
        if (alumno.getId() != null) {
            Alumno alumnoExistente = alumnoRepository.findById(alumno.getId())
                    .orElseThrow(() -> new IllegalArgumentException("ID de alumno no válido: " + alumno.getId()));

            alumnoExistente.setNombre(alumno.getNombre());
            alumnoExistente.setDni(alumno.getDni());
            alumnoExistente.setEdad(alumno.getEdad());
            alumnoExistente.setNota(alumno.getNota());

            alumnoRepository.save(alumnoExistente);
        } else {
            alumnoRepository.save(alumno);
        }

        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de alumno no válido: " + id));

        model.addAttribute("alumno", alumno);
        model.addAttribute("modoEdicion", true);
        return "alumnos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        alumnoRepository.deleteById(id);
        return "redirect:/alumnos";
    }
}