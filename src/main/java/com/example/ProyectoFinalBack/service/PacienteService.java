package com.example.ProyectoFinalBack.service;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Paciente;
import com.example.ProyectoFinalBack.model.PacienteDTO;
import com.example.ProyectoFinalBack.repository.impl.PacienteRepository;
import com.example.ProyectoFinalBack.service.IService.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        return pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscar(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Paciente modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        PacienteDTO pacienteDto = buscar(pacienteDTO.getId());
        if(pacienteDto == null){
            throw new ResourceNotFoundException("No se pudo encontrar el paciente");
        }
        return crearPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Integer id) throws BadRequestException, ResourceNotFoundException {
        if(id < 0){
            throw new BadRequestException("El ID no puede ser negativo");
        }
        PacienteDTO pacienteDTO = buscar(id);
        if(pacienteDTO == null){
            throw new ResourceNotFoundException("No se pudo encontrar al paciente");
        }
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> leertodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }
}
