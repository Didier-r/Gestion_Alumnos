package com.keepcoding.base.service;


import com.keepcoding.base.entity.Alumno;
import java.util.List;

public interface AlumnoService {
	//metodo que devualva una lista de Alumnos
	public List<Alumno> listarAlumno(String dato);
	//metodo para guardar nuevo empleado
		public Alumno guardarAlumno(Alumno alumno);
		
		//metodo para obtener empleado por id
		public Alumno obtenerAlumno(Long id);
		
		//metodo para actualizar un empleado
		public Alumno actualizarAlumno(Alumno alumno);
		
		//metodo para eliminar un empleado
		public void eliminarAlumno(Long id);

}
