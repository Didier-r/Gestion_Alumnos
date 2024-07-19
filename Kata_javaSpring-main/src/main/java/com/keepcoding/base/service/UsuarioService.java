package com.keepcoding.base.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.keepcoding.base.entity.Usuarios;


@Service
public interface UsuarioService {
public Usuarios guardarUsuario(Usuarios usuarios);
	
	public List<Usuarios> login(String username,String password);

}

