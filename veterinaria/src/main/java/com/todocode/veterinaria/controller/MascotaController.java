package com.todocode.veterinaria.controller;


import com.todocode.veterinaria.dto.MascotaAmoDTO;
import com.todocode.veterinaria.model.Mascota;
import com.todocode.veterinaria.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @GetMapping("/mascotas")
    @ResponseBody
    public List<Mascota> getMascotas(){
        return mascotaService.getMascotas();
    }

    @GetMapping("/mascota/{id}")
    public Mascota getMascota(@PathVariable Long id){
        return mascotaService.getMascota(id);
    }

    @GetMapping("/mascota")
    public List<Mascota> getMascotaByEspecieOrRaza(
            @RequestParam (value = "especie", required = false) String especie,
            @RequestParam (value = "raza", required = false)String raza
    ){
        if(especie != null || raza != null){
            return mascotaService.getMascotasEspecieOrRaza(especie,raza);
        }
        return mascotaService.getMascotas();
    }

    //DTO
    @GetMapping("mascota/{id}/amo")
    public MascotaAmoDTO getMascotaAmoDTO(@PathVariable Long id){
        return mascotaService.getMascotaAmoDTO(id);
    }


    @PostMapping("/mascota")
    public String saveMascota(@RequestBody Mascota mascota){
        mascotaService.saveMascota(mascota);
        return "Mascota creada correctamente!";
    }

    @DeleteMapping("/mascota/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascotaService.deleteMascota(id);
        return "Mascota eliminada correctamente";
    }


    @PutMapping("/mascota/{id}")
    public Mascota editMascota(@PathVariable Long id, @RequestBody Mascota mascota){
        return mascotaService.editMascota(id, mascota);
    }


}
