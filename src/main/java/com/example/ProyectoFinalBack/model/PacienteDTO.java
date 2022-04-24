package com.example.ProyectoFinalBack.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PacienteDTO {
    private int id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private String dni;
    private String email;
    private Date fechaIngreso;
}
