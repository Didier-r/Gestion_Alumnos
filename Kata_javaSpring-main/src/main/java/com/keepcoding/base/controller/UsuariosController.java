package com.keepcoding.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.keepcoding.base.entity.Usuarios;
import com.keepcoding.base.service.UsuarioService;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService usuarioService;

	
	
	@GetMapping({"/"})
	public String index(Model modelo) {
		Usuarios usuario = new Usuarios();
		modelo.addAttribute("usuario", usuario);
		return "login";
	}
	
	@GetMapping("/usuario/new")
	public String newAlumnoForm(Model modelo) {
		Usuarios usuario =  new Usuarios();
		modelo.addAttribute("usuario", usuario);
		return "crearUsuario";
	}
	
	@PostMapping("/usuario")
	public String saveUusario(@ModelAttribute("usuario") Usuarios usuario) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") Usuarios usuario) {
		List<Usuarios> user= usuarioService.login(usuario.getUsername(), usuario.getPassword());
		if (user.size()==0) {
			return "redirect:/";
		}else {
			return "redirect:/alumnos";
		}
			
	}

}