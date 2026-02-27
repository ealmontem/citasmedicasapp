package com.ealmonte.controller;

import com.ealmonte.entity.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PacienteController {

    private final List<Paciente> listaPacientes = new ArrayList<>();

    public PacienteController(){
        initializePacientes();
    }

    private void initializePacientes(){
        listaPacientes.addAll(List.of(
                        new Paciente("Maria","Almonte","01"),
                        new Paciente("Ramon","Tolentino","02"),
                        new Paciente("Rossy","Vasquez","03"),
                        new Paciente("Pedro","Urbaez","04"),
                        new Paciente("Manuel","Grullon","05"),
                        new Paciente("Juan","Cruz","05")
        ));
    }



    @GetMapping("/api")
    public List<Paciente> list(){
        return listaPacientes;
    }


    @GetMapping("/api/{nombre}")
    public Paciente getPacienteByNombre(@PathVariable String nombre){
        for (Paciente paciente:listaPacientes){
            if (paciente.getNombre().equalsIgnoreCase(nombre)){
                return paciente;
            }
        }
        return null;
    }


}
