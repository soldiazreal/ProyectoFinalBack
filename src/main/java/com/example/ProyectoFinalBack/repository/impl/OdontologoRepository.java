package com.example.ProyectoFinalBack.repository.impl;

import com.example.ProyectoFinalBack.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
