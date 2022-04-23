package com.example.ProyectoFinalBack.controller;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Turno;
import com.example.ProyectoFinalBack.model.TurnoDTO;
import com.example.ProyectoFinalBack.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        return ResponseEntity.ok(turnoService.crearturno(turnoDTO));
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarPorId(@PathVariable Integer id){
        return turnoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        ResponseEntity response = null;
        if(turnoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            turnoService.eliminarTurno(id);
            response= ResponseEntity.ok("SE ELIMINÓ EL TURNO CON ID " + id);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> listarTodos() {
        return ResponseEntity.ok(turnoService.leerTodos());
    }


}