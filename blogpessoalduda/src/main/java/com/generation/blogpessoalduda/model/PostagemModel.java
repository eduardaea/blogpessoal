package com.generation.blogpessoalduda.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_postagens")
public class PostagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo título é Obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;

	@NotNull(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;

	/**
	 * A anotação @UpdateTimestamp Indica se o atributo receberá um Timestamp (Data
	 * e hora do sistema) e sempre que a Postagem for atualizada o atributo também
	 * será atualizado.
	 */
	@UpdateTimestamp
	private LocalDateTime data;

	/**
	 * 
	 * Os Métodos Get e Set obrigatoriamente devem ser criados para todos os
	 * atributos da Classe, inclusive os novos atributos que forem adicionados no
	 * decorrer do processo de Desenvolvimento.
	 * 
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
