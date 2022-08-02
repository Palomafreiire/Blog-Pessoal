package com.blog.generation.blogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.blog.generation.blogPessoal.model.PostagemModel;
import com.blog.generation.blogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/Postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*") // para o frontend consumir esse API de qualquer linguagem que seja o front;
public class PostagemController {
	// como isso é uma interface nós não conseguimos instanciar ela então vamos
	// deixar para o spring usando:
	@Autowired
	private PostagemRepository repository;
	// assim garantimos que todos os serviços dessa interface seja acessado a partir
	// do controller;

	@GetMapping // quando vim uma requisição externa, de alguem que consuma essa API atraves de
				// postagens ali em cima e for um metodo GET vai disparar esse metodo
	public ResponseEntity<List<PostagemModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping ("/{id}")// assim que fizer uma requisição no valor id e passar algum atributo vai ser acessado esse metodo:
	public ResponseEntity<PostagemModel> getById(@PathVariable Long id){ // aqui vai mostrar qual a variavel que estamos recebendo dentro do pathvariable
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	} // vai retornar a interface que criamos com o autowired 1. vai retornar um metodo o tipo postagem 2 quanto um notfound caso 
		// o objeto não exista ou se existir algum erro com a requisição;
	
	@GetMapping ("/titulo/{titulo}") //tem que botar assim para o backend não confundir as rotas atraves do controler; titulo / atributo:titulo;
	public ResponseEntity<List<PostagemModel>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping // utilizando metodo post agora; Endpoint do post
	public ResponseEntity<PostagemModel> postPostagem (@Valid @RequestBody PostagemModel postagem){// como estamos botando um objeto, qd for um objeto grande e seguro então esse recurso tem que pegar pelo "body"; o corpo da requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	// Sempre quando formos realizar um Post/Put enviaremos os dados via: Body;
	
	@PutMapping // metodo PUT vai ser quase a mesma coisa que o metodo POST;
	public ResponseEntity<PostagemModel> putPostagem (@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping ("/{id}")
	public void deletePostagem(@PathVariable Long id) {
		repository.deleteById(id);
	}
		

}

// essa classe é responsavel pela comunicação com o Client (Postiman, angular etc)