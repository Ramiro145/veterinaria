package com.todocode.veterinaria.repository;

import com.todocode.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {


    @Query(value = "SELECT * FROM mascota WHERE UPPER(especie) = UPPER(:especie) AND UPPER(raza) = UPPER(:raza)", nativeQuery = true)
    List<Mascota> findByEspecieAndRaza(@Param("especie") String especie, @Param("raza") String raza);


}
