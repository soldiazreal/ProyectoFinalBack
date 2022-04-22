package com.example.ProyectoFinalBack.service;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Turno;
import com.example.ProyectoFinalBack.model.TurnoDTO;
import com.example.ProyectoFinalBack.repository.impl.TurnoRepository;
import com.example.ProyectoFinalBack.service.IService.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TurnoService implements ITurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Turno crearturno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        return turnoRepository.save(turno);
    }
    @Override
    public TurnoDTO buscar(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void eliminarTurno(Integer id) throws BadRequestException, ResourceNotFoundException {
        if(id < 1){
            throw new BadRequestException("ID no puede ser menor a 1");
        }
        TurnoDTO turnoDTO = buscar(id);
        if(turnoDTO == null){
            throw new ResourceNotFoundException("No se pudo eliminar el turno");
        }
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> leerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }


}
