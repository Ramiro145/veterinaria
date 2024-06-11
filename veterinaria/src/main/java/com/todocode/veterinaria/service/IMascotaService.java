package com.todocode.veterinaria.service;


import com.todocode.veterinaria.dto.MascotaAmoDTO;
import com.todocode.veterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    List<Mascota> getMascotas();

    Mascota getMascota(Long id);

    List<Mascota> getMascotasEspecieOrRaza(String especie, String raza);

    MascotaAmoDTO getMascotaAmoDTO(Long id);

    void saveMascota(Mascota mascota);

    void deleteMascota(Long id);

    Mascota editMascota(Long id, Mascota mascota);


}
