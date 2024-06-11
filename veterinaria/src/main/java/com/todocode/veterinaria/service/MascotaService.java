package com.todocode.veterinaria.service;

import com.todocode.veterinaria.dto.MascotaAmoDTO;
import com.todocode.veterinaria.model.Amo;
import com.todocode.veterinaria.model.Mascota;
import com.todocode.veterinaria.repository.AmoRepository;
import com.todocode.veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MascotaService implements  IMascotaService{

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    AmoRepository amoRepository;

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota getMascota(Long id) {
        return mascotaRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No hay mascota con id: " + id));
    }

    @Override
    public List<Mascota> getMascotasEspecieOrRaza(String especie, String raza) {
        //pendiente
        //todo
        return mascotaRepository.findByEspecieAndRaza(especie,raza);
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Mascota editMascota(Long id, Mascota mascota) {

        Mascota mascoExis = this.getMascota(id);

        mascoExis.setNombre(mascota.getNombre());
        mascoExis.setEspecie(mascota.getEspecie());
        mascoExis.setRaza(mascota.getRaza());
        mascoExis.setColor(mascota.getColor());

        //todo
        if(mascota.getAmo() != null){
            Amo amoExis = amoRepository.findById(mascota.getAmo().getId_amo()).orElseThrow(()->
                    new NoSuchElementException("No hay amo con ese id: " + mascota.getAmo().getId_amo()));

            mascoExis.setAmo(amoExis);
        }else{
            mascoExis.setAmo(null);
        }


        return mascotaRepository.save(mascoExis);
    }


    public MascotaAmoDTO getMascotaAmoDTO(Long id) {

        Mascota mascotaExis = this.getMascota(id);

        MascotaAmoDTO mascotaAmoDTO = new MascotaAmoDTO();
        mascotaAmoDTO.setNombre_mascota(mascotaExis.getNombre());
        mascotaAmoDTO.setEspecie(mascotaExis.getEspecie());
        mascotaAmoDTO.setRaza(mascotaExis.getRaza());

        if(mascotaExis.getAmo() != null){
            mascotaAmoDTO.setNombre_amo(mascotaExis.getAmo().getNombre());
            mascotaAmoDTO.setApellido_amo(mascotaExis.getAmo().getApellido());
        }else{
            mascotaAmoDTO.setNombre_amo(null);
            mascotaAmoDTO.setApellido_amo(null);
        }

        return mascotaAmoDTO;
    }
}
