package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.MetodoPago;
public interface MetodoPagoService {

	List<MetodoPago> listarMetodoPago();
	MetodoPago getIdMetodoPago(Long id);
	void crearActualizarMetodoPago(MetodoPago metodoPago);
	void eliminarMetodoPago(Long id);

}
