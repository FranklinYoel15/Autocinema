package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Confiteria;

public interface ConfiteriaService {

	List<Confiteria> listarConfiteria();
	Confiteria getIdConfiteria(Long id);
	void crearActualizarConfiteria(Confiteria confiteria);
	void eliminarConfiteria(Long id);
    Confiteria buscarPorId(Long id);
    void guardar(Confiteria confiteria);
}