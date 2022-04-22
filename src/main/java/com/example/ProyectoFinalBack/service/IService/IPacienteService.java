package com.example.ProyectoFinalBack.service.IService;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Paciente;
import com.example.ProyectoFinalBack.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    public Paciente crearPaciente(PacienteDTO pacienteDTO);
    public PacienteDTO buscar(Integer id);
    public Paciente modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    public void eliminarPaciente(Integer id) throws BadRequestException, ResourceNotFoundException;
    public Set<PacienteDTO> leertodos();
}
