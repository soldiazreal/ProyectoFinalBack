package com.example.ProyectoFinalBack;


import com.example.ProyectoFinalBack.model.Domicilio;
import com.example.ProyectoFinalBack.model.Paciente;
import com.example.ProyectoFinalBack.model.PacienteDTO;
import com.example.ProyectoFinalBack.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteTests {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void crearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Sol");
        pacienteDTO.setApellido("Diaz Real");
        pacienteDTO.setDni("37654864");
        pacienteDTO.setFechaIngreso(new Date());
        pacienteDTO.setDomicilio(new Domicilio("calle falsa", "123", "Springfield", "Springfield")
        );
        pacienteService.crearPaciente(pacienteDTO);
        Assert.assertNotNull(pacienteService.buscar(1));
    }
}
