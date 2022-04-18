package com.example.ProyectoFinalBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter

public class Paciente {
    @Id
    @SequenceGenerator(name="paciente_sequence",sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private int id;
    private String nombre;
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
    private Domicilio domicilio;
    private String documento;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, Domicilio domicilio, String documento, Date fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.documento = documento;
        this.fechaAlta = fechaAlta;
    }

    public Paciente(int id, String nombre, String apellido, Domicilio domicilio, String documento, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.documento = documento;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio=" + domicilio +
                ", documento='" + documento + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}