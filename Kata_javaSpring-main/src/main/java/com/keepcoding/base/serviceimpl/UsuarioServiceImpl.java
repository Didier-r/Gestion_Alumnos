package com.keepcoding.base.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.keepcoding.base.entity.Usuarios;
import com.keepcoding.base.repository.UsuarioRepository;
import com.keepcoding.base.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuarios guardarUsuario(Usuarios usuarios) {
		return usuarioRepository.save(usuarios);
	}

	@Override
	public List<Usuarios> login(String username, String password) {
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}

}
