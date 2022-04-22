package com.example.ProyectoFinalBack.service.IService;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Turno;
import com.example.ProyectoFinalBack.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    public Turno crearturno(TurnoDTO turnoDTO);
    public TurnoDTO buscar(Integer id);
    public void eliminarTurno(Integer id) throws BadRequestException,ResourceNotFoundException;
    public Set<TurnoDTO> leerTodos();

}
