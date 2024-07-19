package com.keepcoding.base.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.base.entity.Alumno;
import com.keepcoding.base.repository.AlumnoRepository;
import com.keepcoding.base.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public List<Alumno> mostrarAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno mostrarAlumnoById(Long id) {
		return alumnoRepository.findById(id).get();
	}

	@Override
	public void eliminarAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}

}

