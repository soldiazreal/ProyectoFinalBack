package com.example.ProyectoFinalBack.controller;

import com.example.ProyectoFinalBack.exceptions.BadRequestException;
import com.example.ProyectoFinalBack.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinalBack.model.Odontologo;

import com.example.ProyectoFinalBack.model.OdontologoDTO;
import com.example.ProyectoFinalBack.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDTO));
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Integer id) {
        return odontologoService.buscar(id);
    }


    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Se eliminó el odontólogo con ID: " + id);
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarTodos() {
        return ResponseEntity.ok(odontologoService.leertodos());
    }
}
