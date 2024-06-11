package com.todocode.veterinaria.service;

import com.todocode.veterinaria.model.Amo;
import com.todocode.veterinaria.repository.AmoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AmoService implements IAmoService{

    @Autowired
    AmoRepository amoRepository;


    @Override
    public List<Amo> getAmos() {
        return amoRepository.findAll();
    }

    @Override
    public Amo getAmo(Long id) {
        return amoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No hay amo con ese id: " + id));
    }

    @Override
    public void saveAmo(Amo amo) {
        amoRepository.save(amo);
    }

    @Override
    public void deleteAmo(Long id) {
        amoRepository.deleteById(id);
    }

    @Override
    public Amo editAmo(Long id, Amo amo) {

        Amo amoExis = this.getAmo(id);

        amoExis.setDni(amo.getDni());
        amoExis.setNombre(amo.getNombre());
        amoExis.setApellido(amo.getApellido());
        amoExis.setCelular(amo.getCelular());

        return amoRepository.save(amoExis);

    }
}
