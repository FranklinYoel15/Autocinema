package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.Categoria;
import com.autocinema.pe.repository.CategoriaRepository;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getIdCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    @Override
    public Categoria buscarPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    @Override
    public void crearActualizarCategoria(Categoria categoria) {
        Categoria cat = new Categoria();
        cat.setId(categoria.getId());
        cat.setNombre(categoria.getNombre());
        cat.setImagen(categoria.getImagen());
        categoriaRepository.save(cat);
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}