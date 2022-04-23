package com.example.ProyectoFinalBack.repository.impl;

import com.example.ProyectoFinalBack.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
