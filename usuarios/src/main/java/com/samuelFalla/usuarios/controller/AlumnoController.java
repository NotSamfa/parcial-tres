package com.samuelFalla.usuarios.controller;

import com.samuelFalla.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samuelFalla.usuarios.model.Alumno;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoService service;

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Optional <Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Alumno alumno) {

        Alumno alumnoDb = service.save(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
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

    @DeleteMapping
    private ResponseEntity<?> delete(@PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
