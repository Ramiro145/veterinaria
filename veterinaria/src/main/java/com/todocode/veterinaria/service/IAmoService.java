package com.todocode.veterinaria.service;


import com.todocode.veterinaria.model.Amo;

import java.util.List;

public interface IAmoService {

    List<Amo> getAmos();

    Amo getAmo(Long id);

    void saveAmo(Amo amo);

    void deleteAmo(Long id);

    Amo editAmo(Long id, Amo amo);


}
