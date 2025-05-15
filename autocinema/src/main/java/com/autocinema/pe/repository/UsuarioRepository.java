package com.autocinema.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocinema.pe.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}