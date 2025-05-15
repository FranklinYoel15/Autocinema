package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.Usuario;
import com.autocinema.pe.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getIdUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarUsuario(Usuario usuario) {
        Usuario u = new Usuario();
        u.setId(usuario.getId());
        u.setNombre(usuario.getNombre());
        u.setCorreo(usuario.getCorreo());
        u.setContrasenia(usuario.getContrasenia());
        u.setTelefono(usuario.getTelefono());
        usuarioRepository.save(u);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
