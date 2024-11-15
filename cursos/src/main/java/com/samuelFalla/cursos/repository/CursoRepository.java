package com.samuelFalla.cursos.repository;

import com.samuelFalla.cursos.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
