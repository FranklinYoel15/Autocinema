package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Pelicula;


public interface PeliculaService {
	List<Pelicula> listarPelicula();
	Pelicula getIdPelicula(Long id);
	void crearActualizarPelicula(Pelicula pelicula);
	void eliminarPelicula(Long id);
	List<Pelicula> buscarPorCategoria(String categoria);

}
