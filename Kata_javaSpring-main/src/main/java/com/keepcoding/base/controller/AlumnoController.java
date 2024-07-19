package com.keepcoding.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.keepcoding.base.entity.Alumno;
import com.keepcoding.base.service.AlumnoService;

@Controller
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/alumno")
	public String index(Model modelo,@Param("datoBuscado") String datoBuscado) {
		modelo.addAttribute("alumnos",alumnoService.listarAlumno(datoBuscado));
		return "alumno";
		
	}
	@GetMapping("/alumno/new")
	public String newEmpleadoForm(Model modelo) {
		Alumno alumno =  new Alumno();
		modelo.addAttribute("alumno", alumno);
		return "crear_alumno";
	}
	
	@PostMapping("/alumno")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/";
	}
	
	
	@GetMapping("/alumno/editar/{id}")
	public String updateAlumForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno_update",alumnoService.obtenerAlumno(id));
		return "editar_alumno";
	}
	
	@PostMapping("/alumno/{id}")
	public String updateAlumno(@PathVariable Long id, @ModelAttribute("alumno_update") Alumno alumno) {
		Alumno alumnoExistente = alumnoService.obtenerAlumno(id);
		alumnoExistente.setId(id);
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setApellido(alumno.getApellido());
		alumnoExistente.setEmail(alumno.getEmail());
		alumnoExistente.setTelefono(alumno.getTelefono());
		
		alumnoService.actualizarAlumno(alumnoExistente);
		
		return "redirect:/";
	}
	
	@GetMapping("/alumno/delete/{id}")
	public String deletealumno(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/";
	}
}
	
