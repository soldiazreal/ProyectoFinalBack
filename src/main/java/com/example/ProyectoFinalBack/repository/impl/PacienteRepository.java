package com.example.ProyectoFinalBack.repository.impl;

import com.example.ProyectoFinalBack.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
