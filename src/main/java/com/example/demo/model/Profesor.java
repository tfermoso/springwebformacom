package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer id;

    @Column(name = "sueldo", precision = 5, scale = 2)
    private BigDecimal sueldo;

    public Profesor() {
    }

    public Profesor(String nombre, String dni, Integer edad, BigDecimal sueldo) {
        super(nombre, dni, edad);
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", edad=" + getEdad() +
                ", sueldo=" + sueldo +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}