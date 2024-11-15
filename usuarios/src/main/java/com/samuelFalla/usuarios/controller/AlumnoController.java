package com.samuelFalla.usuarios.controller;

import com.samuelFalla.common.model.Alumno;
import com.samuelFalla.commons.controller.CommonController;
import com.samuelFalla.usuarios.service.serviceImplementation.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoServiceImpl>{

    @Autowired
    AlumnoServiceImpl service;

    @Value("${config.balanceador.test}")
    private String  balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("alumno", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Alumno alumno, @PathVariable Long id) {

        Optional<Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Alumno alumnoDb = ob.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());


        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
    }

}
