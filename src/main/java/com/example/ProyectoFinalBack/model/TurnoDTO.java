package com.example.ProyectoFinalBack.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Integer id;
    private Date fecha;
    private Time hora;
    private Paciente paciente;
    private Odontologo odontologo;
}
