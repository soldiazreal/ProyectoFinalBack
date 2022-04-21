package com.example.ProyectoFinalBack.service.IService;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Odontologo;
import com.example.ProyectoFinalBack.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    public Odontologo crearOdontologo(OdontologoDTO odontologoDto);
    public OdontologoDTO buscar(Integer id);
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDto) throws ResourceNotFoundException;
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException;
    public Set<OdontologoDTO> leertodos();
}
