package com.keepcoding.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@GetMapping({"/alumnos"})
	public String index(Model modelo) {
		modelo.addAttribute("alumno", alumnoService.mostrarAlumnos());
		return "alumno";
	}
	
	@GetMapping("/alumno/new")
	public String newAlumnoForm(Model modelo) {
		Alumno empleado =  new Alumno();
		modelo.addAttribute("alumno", empleado);
		return "crear_alumno";
	}
	
	@PostMapping("/alumno")
	public String saveEmpleado(@ModelAttribute("empleado") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/";
	}
	
	
	@GetMapping("/alumno/editar/{id}")
	public String updateAlumnoForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno_update",alumnoService.mostrarAlumnoById(id));
		return "editar_alumno";
	}
	
	@PostMapping("/alumno/{id}")
	public String updateAlumno(@PathVariable Long id, @ModelAttribute("alumno_update") Alumno alumno) {
		Alumno alumnoExistente = alumnoService.mostrarAlumnoById(id);
		alumnoExistente.setId(id);
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setApellido(alumno.getApellido());
		alumnoExistente.setEmail(alumno.getEmail());
		alumnoExistente.setTelefono(alumno.getTelefono());
		
		alumnoService.guardarAlumno(alumnoExistente);
		
		return "redirect:/";
	}
	
	@GetMapping("/alumno/delete/{id}")
	public String deleteEmpleado(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/";
	}
}