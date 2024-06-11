package com.todocode.veterinaria.repository;


import com.todocode.veterinaria.model.Amo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmoRepository extends JpaRepository<Amo, Long> {


}
