package com.autocinema.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocinema.pe.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	 Categoria findByNombre(String nombre);

}
