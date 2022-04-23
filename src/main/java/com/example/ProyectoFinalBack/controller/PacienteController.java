package com.example.ProyectoFinalBack.controller;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Paciente;
import com.example.ProyectoFinalBack.model.PacienteDTO;
import com.example.ProyectoFinalBack.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDTO));
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Integer id){
        return pacienteService.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        ResponseEntity<Paciente> response = null;

        if (pacienteService.buscar(pacienteDTO.getId()) != null)
            response = ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        ResponseEntity response = null;
        if(pacienteService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            pacienteService.eliminarPaciente(id);
            response= ResponseEntity.ok("Se elimino el paciente con id " + id);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.leertodos());
    }
}
