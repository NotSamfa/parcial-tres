package com.samuelFalla.cursos.controller;

import com.samuelFalla.common.model.Alumno;
import com.samuelFalla.commons.controller.CommonController;
import com.samuelFalla.cursos.model.Curso;
import com.samuelFalla.cursos.service.CursoService;
import com.samuelFalla.cursos.service.serviceImplementation.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController extends CommonController<Curso, CursoServiceImpl> {

    @Autowired
    CursoServiceImpl service;

    @Value("${config.balanceador.test}")
    private String  balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("curso", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> assignAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if(ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();

        alumnos.forEach(a -> {
            cursoBd.addAlumnos(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
    }

    @PutMapping("/{id}/asignar-alumno")
    public ResponseEntity<?> assignAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if(ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();

        cursoBd.addAlumnos(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> removeAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if(ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();

        cursoBd.removeAlumnos(alumno);

        return ResponseEntity.noContent().build();
    }
}
