package com.keepcoding.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.keepcoding.base.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
