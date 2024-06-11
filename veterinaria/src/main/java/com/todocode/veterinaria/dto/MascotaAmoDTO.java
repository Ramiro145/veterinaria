package com.todocode.veterinaria.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaAmoDTO {

    private String nombre_mascota;
    private String especie;
    private String raza;
    private String nombre_amo;
    private String apellido_amo;

    public MascotaAmoDTO() {
    }

    public MascotaAmoDTO(String nombre_mascota, String especie, String raza, String nombre_amo, String apellido_amo) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_amo = nombre_amo;
        this.apellido_amo = apellido_amo;
    }


}
