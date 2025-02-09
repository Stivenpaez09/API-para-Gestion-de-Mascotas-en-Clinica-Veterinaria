package com.clinica.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@SequenceGenerator(name = "mascota_seq", sequenceName = "mascota_seq", allocationSize = 1)
public class Mascota {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "mascota_seq")
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    
    @OneToOne
    @JoinColumn (name = "id_duenio", referencedColumnName = "id")
    private Duenio unDuenio;
}
