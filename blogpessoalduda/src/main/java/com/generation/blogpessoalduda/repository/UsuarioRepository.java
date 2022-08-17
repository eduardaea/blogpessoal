package com.generation.blogpessoalduda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoalduda.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long>{
	
	public Optional<UsuarioModel> findByUsuario(String usuario);
}
