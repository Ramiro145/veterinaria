package com.todocode.veterinaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Amo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_amo;

    private String dni;
    private String nombre;
    private String apellido;
    private String celular;

    @JsonIgnore
    @OneToOne(mappedBy = "amo")
    private Mascota mascota;

    public Amo() {
    }

    public Amo(Long id_amo, String dni, String nombre, String apellido, String celular, Mascota mascota) {
        this.id_amo = id_amo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.mascota = mascota;
    }


}
