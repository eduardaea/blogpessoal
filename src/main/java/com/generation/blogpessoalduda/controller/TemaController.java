package com.generation.blogpessoalduda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoalduda.model.TemaModel;
import com.generation.blogpessoalduda.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>>getTemas(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel>getTema(@PathVariable Long id){
		return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TemaModel>>getTemaByDescription(@PathVariable String descricao){
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity <TemaModel>post(@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity <TemaModel>put(@RequestBody TemaModel tema){
		TemaModel novo = temaRepository.save(tema);
		return ResponseEntity.status(HttpStatus.OK).body(novo);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		temaRepository.deleteById(id);
	}
}
