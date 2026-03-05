package com.ealmonte.controller;

import com.ealmonte.entity.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
                        new Paciente("Maria","Almonte","01","333","maria@gmail.com",25),
                        new Paciente("Ramon","Tolentino","02","333","ramon@gmail.com",25),
                        new Paciente("Rossy","Vasquez","03","333","rossy@gmail.com",33),
                        new Paciente("Pedro","Urbaez","04","333","pedro@gmail.com",44),
                        new Paciente("Manuel","Grullon","05","333","manuel@gmail.com",33),
                        new Paciente("Juan","Cruz","05","333","juan@gmail.com",21)
        ));
    }


    @GetMapping("/api/pacientes")
    public List<Paciente> getPacienteByEdad(@RequestParam(required = false) int edad){

        if (edad == 0 ){
            return listaPacientes;
        }
        List<Paciente> pacientesFiltrados = new ArrayList<>();
        return listaPacientes.stream()
                .filter(paciente -> paciente.getEdad()==edad)
                .toList();
    }


//    @GetMapping("/api/nombre/{nombre}")
//    public Paciente getPacienteByNombre(@PathVariable String nombre){
//        for (Paciente paciente:listaPacientes){
//            if (paciente.getNombre().equalsIgnoreCase(nombre)){
//                return paciente;
//            }
//        }
//        return null;
//    }


    @GetMapping("/api/nombre/{nombre}")
    public Paciente getPacienteByNombreWithLambdas(@PathVariable String nombre){
        return listaPacientes.stream()
                .filter(paciente -> paciente.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }


    

}
