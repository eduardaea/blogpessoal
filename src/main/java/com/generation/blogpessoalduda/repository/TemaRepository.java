package com.generation.blogpessoalduda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogpessoalduda.model.TemaModel;

public interface TemaRepository extends JpaRepository <TemaModel, Long> {
	
	public List <TemaModel> findAllByDescricaoContainingIgnoreCase(@Param("Descricao")String descricao);
}
