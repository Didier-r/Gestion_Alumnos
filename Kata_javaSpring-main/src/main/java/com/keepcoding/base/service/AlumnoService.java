package com.keepcoding.base.service;


import com.keepcoding.base.entity.Alumno;
import java.util.List;

public interface AlumnoService {
	//metodo que devualva una lista de Alumnos
public Alumno guardarAlumno(Alumno alumno);
	
	public List<Alumno> mostrarAlumnos();
	
	public Alumno mostrarAlumnoById(Long id);
	
	public void eliminarAlumno(Long id);

}
