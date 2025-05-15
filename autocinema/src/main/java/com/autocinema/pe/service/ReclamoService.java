package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Reclamos;


public interface ReclamoService {

	List<Reclamos> listarReclamo();
	Reclamos getIdReclamo(Long id);
	void crearActualizarReclamo(Reclamos reclamo);
	void eliminarReclamo(Long id);


}
