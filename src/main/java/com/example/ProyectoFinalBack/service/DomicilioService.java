package com.example.ProyectoFinalBack.service;

import com.example.ProyectoFinalBack.model.Domicilio;
import com.example.ProyectoFinalBack.repository.impl.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio domicilio){
        domicilioRepository.save(domicilio);
        return domicilio;
    }

    public Optional<Domicilio> buscar(Integer id){return Optional.of(domicilioRepository.getOne(Integer.valueOf(id)));}
    public List<Domicilio> listarTodos(){return domicilioRepository.findAll();}
    public void eliminar(Integer id){domicilioRepository.deleteById(Integer.valueOf(id));}
}
