package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Sala;

public interface SalaService {
	List<Sala> listarSala();
	Sala getIdSala(Long id);
	void crearActualizarSala(Sala sala);
	void eliminarSala(Long id);
}
