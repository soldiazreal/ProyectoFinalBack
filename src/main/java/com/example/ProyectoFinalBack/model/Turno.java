package com.example.ProyectoFinalBack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table (name = "turnos")

public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id")
    @JsonIgnoreProperties(value ={"hibernateLzyInitializer","Handler"})
    private Odontologo odontologo;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value ={"hibernateLzyInitializer","Handler"})
    private Paciente paciente;
    private Date fecha;
    private Time hora;

    public Turno(Odontologo odontologo, Paciente paciente, Date fecha, Time hora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno() {
    }

    public Turno(int id, Odontologo odontologo, Paciente paciente, Date fecha, Time hora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }
}
