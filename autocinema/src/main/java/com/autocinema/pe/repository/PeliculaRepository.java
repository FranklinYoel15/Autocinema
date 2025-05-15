package com.autocinema.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocinema.pe.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

	List<Pelicula> findByCategoria(String categoria);


}