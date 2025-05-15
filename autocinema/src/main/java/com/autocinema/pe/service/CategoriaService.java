package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Categoria;

public interface CategoriaService {

	List<Categoria> listarCategorias();
	Categoria getIdCategoria(Long id);
	void crearActualizarCategoria(Categoria categoria);
	void eliminarCategoria(Long id);
	Categoria buscarPorNombre(String nombre);
	void guardar(Categoria categoria);
}