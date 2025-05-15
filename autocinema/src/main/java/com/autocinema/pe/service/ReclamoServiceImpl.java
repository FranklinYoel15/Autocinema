package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.Reclamos;
import com.autocinema.pe.repository.ReclamoRepository;


@Service
public class ReclamoServiceImpl implements ReclamoService {
	@Autowired
    private ReclamoRepository reclamoRepository;

    @Override
    public List<Reclamos> listarReclamo() {
        return reclamoRepository.findAll();
    }

    @Override
    public Reclamos getIdReclamo(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarReclamo(Reclamos reclamo) {
        Reclamos r = new Reclamos();
        r.setId(reclamo.getId());
        r.setUsuario_id(reclamo.getUsuario_id());
        r.setSede_id(reclamo.getSede_id());
        r.setConfiteria_id(reclamo.getConfiteria_id());
        r.setDescripcion(reclamo.getDescripcion());
        r.setEstado(reclamo.getEstado());
        reclamoRepository.save(r);
    }

    @Override
    public void eliminarReclamo(Long id) {
    	reclamoRepository.deleteById(id);
    }

}
