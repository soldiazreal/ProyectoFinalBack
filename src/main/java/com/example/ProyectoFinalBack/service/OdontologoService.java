package com.example.ProyectoFinalBack.service;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Odontologo;
import com.example.ProyectoFinalBack.model.OdontologoDTO;
import com.example.ProyectoFinalBack.repository.impl.OdontologoRepository;
import com.example.ProyectoFinalBack.service.IService.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDto) {
        Odontologo odontologo = mapper.convertValue(odontologoDto,Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO buscar(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDto) throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = buscar(odontologoDto.getId());
        if(odontologoDTO == null){
            throw new ResourceNotFoundException("No se encontro el odontologo para modificar");
        }
        return crearOdontologo(odontologoDto);
    }

    @Override
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException {
        if(id < 1){
            throw new BadRequestException("ID no puede ser negativo");
        }
        OdontologoDTO odontologoDTO = buscar(id);
        if(odontologoDTO == null){
            throw new ResourceNotFoundException("No se encontro el odontologo a eliminar");
        }
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> leertodos() {
        List<Odontologo> odontologos= odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologosDTO;
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String>procesarErrorNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
