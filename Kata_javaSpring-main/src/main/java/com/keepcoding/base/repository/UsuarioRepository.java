package com.keepcoding.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keepcoding.base.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	@Query("SELECT p FROM Usuarios p WHERE p.nombre LIKE %?1%")
	public List<Usuarios> filterName(String nombre);
	
	List<Usuarios> findByNombre(String nombre);
	

}
