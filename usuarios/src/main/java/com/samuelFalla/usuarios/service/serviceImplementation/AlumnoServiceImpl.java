package com.samuelFalla.usuarios.service.serviceImplementation;

import com.samuelFalla.commons.service.CommonService;
import com.samuelFalla.commons.service.ServiceImplementation.CommonServiceImpl;
import com.samuelFalla.usuarios.model.Alumno;
import com.samuelFalla.usuarios.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements CommonService<Alumno> {


}
