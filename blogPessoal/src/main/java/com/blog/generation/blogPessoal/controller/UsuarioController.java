package com.blog.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.generation.blogPessoal.model.UsuarioLoginModel;
import com.blog.generation.blogPessoal.model.UsuarioModel;
import com.blog.generation.blogPessoal.repository.UsuarioRepository;
import com.blog.generation.blogPessoal.service.UsuarioService;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/usuario")
public class UsuarioController {
	
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired UsuarioService usuarioService;
	
	@GetMapping ("/all")
	public ResponseEntity<List<UsuarioModel>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping ("/{id}")
	public ResponseEntity<UsuarioModel> getById (@PathVariable Long id){
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping ("/logar")
	public ResponseEntity<UsuarioLoginModel> login(@RequestBody Optional<UsuarioLoginModel> usuarioLogin ){
		return usuarioService.autenticarUsuario(usuarioLogin)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping ("/cadastrar")
	public ResponseEntity<UsuarioModel> post (@Valid @RequestBody UsuarioModel usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping ("/atualizar")
	public ResponseEntity<UsuarioModel> put (@Valid @RequestBody UsuarioModel usuario){
		return usuarioService.atualizarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
