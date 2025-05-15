package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Sede;

public interface SedeService {

	List<Sede> listarSede();
	Sede getIdSede(Long id);
	void crearActualizarSede(Sede sede);
	void eliminarSede(Long id);

}
