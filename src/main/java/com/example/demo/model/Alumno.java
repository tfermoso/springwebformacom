package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "alumnos")
public class Alumno extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Integer id;

    @Column(name = "nota", precision = 2, scale = 1)
    private BigDecimal nota;

    public Alumno() {
    }

    public Alumno(String nombre, String dni, Integer edad, BigDecimal nota) {
        super(nombre, dni, edad);
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", edad=" + getEdad() +
                ", nota=" + nota +
                '}';
    }
}