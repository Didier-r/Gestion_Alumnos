package com.keepcoding.base.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.keepcoding.base.entity.Usuarios;
import com.keepcoding.base.repository.UsuarioRepository;
import com.keepcoding.base.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuarios> listaUsuario(String dato) {
		if(dato != null) {
			return usuarioRepository.filterName(dato);
		}else {
			return usuarioRepository.findAll();
		}
	}
}
