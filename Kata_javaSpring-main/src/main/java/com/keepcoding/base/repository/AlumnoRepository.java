package com.keepcoding.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keepcoding.base.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	@Query("SELECT e FROM Alumno e WHERE CONCAT(e.nombre,e.apellido,e.telefono) LIKE %?1%")
	public List<Alumno> searchData(String datoBuscado);
}
