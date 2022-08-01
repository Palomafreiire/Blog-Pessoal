package com.blog.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.generation.blogPessoal.model.Postagem;
import com.blog.generation.blogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/Postagem")
@CrossOrigin("*") // para o frontend consumir esse API de qualquer linguagem que seja o front;
public class PostagemController {
	// como isso é uma interface nós não conseguimos instanciar ela então vamos
	// deixar para o spring usando:
	@Autowired
	private PostagemRepository repository;
	// assim garantimos que todos os serviços dessa interface seja acessado a partir
	// do controller;

	@GetMapping // quando vim uma requisição externa, de alguem que consuma essa API atraves de
				// postagens ali em cima e for um metodo GET vai disparar esse metodo
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

}

// essa classe é responsavel pela comunicação com o Client (Postiman, angular etc)