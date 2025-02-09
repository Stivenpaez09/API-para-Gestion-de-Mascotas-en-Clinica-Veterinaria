package com.clinica.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "duenio_seq", sequenceName = "duenio_seq", allocationSize = 1)
public class Duenio {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "duenio_seq")
    public Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String celular;
}
