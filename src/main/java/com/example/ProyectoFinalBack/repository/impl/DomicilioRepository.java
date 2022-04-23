package com.example.ProyectoFinalBack.repository.impl;

import com.example.ProyectoFinalBack.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
