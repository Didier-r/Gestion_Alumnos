package com.keepcoding.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keepcoding.base.service.UsuarioService;

@Controller
public class UsuariosController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping({"/","/usuarios"})
	public String usuarioList(Model modelo,@Param("datoBuscado")String datoBuscado) {
		System.out.println(datoBuscado);
		modelo.addAttribute("usuario",usuarioService.listaUsuario(datoBuscado));
		return "usuario";
	}

}
