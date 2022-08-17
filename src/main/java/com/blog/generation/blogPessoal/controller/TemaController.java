package com.blog.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.generation.blogPessoal.model.TemaModel;
import com.blog.generation.blogPessoal.repository.TemaRepository;

@RestController
@CrossOrigin (origins = "*" , allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

	@Autowired 
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping ("/{id}")
		public ResponseEntity<TemaModel> getById (@PathVariable Long id){
			return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());			
		}
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<TemaModel>> getByName (@PathVariable String nome){
			return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	@PostMapping
		public ResponseEntity<TemaModel> post (@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<TemaModel> put (@RequestBody TemaModel tema){
		return ResponseEntity.ok(temaRepository.save(tema));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Long id) {
		temaRepository.deleteById(id);
	}
	
	
	
	
}
