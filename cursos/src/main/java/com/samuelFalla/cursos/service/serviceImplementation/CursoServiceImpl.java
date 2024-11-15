package com.samuelFalla.cursos.service.serviceImplementation;

import com.samuelFalla.commons.service.CommonService;
import com.samuelFalla.commons.service.ServiceImplementation.CommonServiceImpl;
import com.samuelFalla.cursos.model.Curso;
import com.samuelFalla.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService<Curso> {
}
