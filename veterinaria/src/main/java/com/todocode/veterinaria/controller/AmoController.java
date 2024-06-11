package com.todocode.veterinaria.controller;
import com.todocode.veterinaria.model.Amo;
import com.todocode.veterinaria.service.AmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AmoController {

    @Autowired
    AmoService amoService;
    @GetMapping("/amos")
    public List<Amo> getAmos(){
        return amoService.getAmos();
    }

    @GetMapping("/amo/{id}")
    public Amo getAmo(@PathVariable Long id){
        return amoService.getAmo(id);
    }

    @PostMapping("/amo")
    public String saveAmo(@RequestBody Amo amo){
        amoService.saveAmo(amo);
        return "Amo creado correctamente";
    }

    @DeleteMapping("/amo/{id}")
    public String deleteAmo(@PathVariable Long id){
        amoService.deleteAmo(id);
        return "Amo eliminado correctamente";
    }

    @PutMapping("/amo/{id}")
    public Amo editAmo(@PathVariable Long id, @RequestBody Amo amo){
        return amoService.editAmo(id, amo);
    }


}
