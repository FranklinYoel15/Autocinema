package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Usuario;

public interface UsuarioService {

	List<Usuario> listarUsuario();
	Usuario getIdUsuario(Long id);
	void crearActualizarUsuario(Usuario usuario);
	void eliminarUsuario(Long id);

}
