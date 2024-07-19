package com.keepcoding.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.keepcoding.base.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	
	List<Usuarios> findByUsernameAndPassword(String username, String password);

}
