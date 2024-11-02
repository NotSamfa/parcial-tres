package com.samuelFalla.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import com.samuelFalla.usuarios.model.Alumno;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {


}
