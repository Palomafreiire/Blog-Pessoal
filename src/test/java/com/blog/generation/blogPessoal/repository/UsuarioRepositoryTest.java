package com.blog.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.blog.generation.blogPessoal.model.UsuarioModel;

@SpringBootTest (webEnvironment =  WebEnvironment.RANDOM_PORT)
@TestInstance (TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new UsuarioModel (0L, "joao da silva", "joao@email.com.br", "123456788", "http://i.imgur.com/FETvs23.jpg"));
		usuarioRepository.save(new UsuarioModel (0L, "manuela da silva", "palomamfr@email.com.br", "1234567899", "http://i.imgur.com/FEfdvs23.jpg"));
		usuarioRepository.save(new UsuarioModel (0L, "adriana da silva", "zelinhaaz@email.com.br", "123455446", "http://i.imgur.com/FEFDvs23.jpg"));
		usuarioRepository.save(new UsuarioModel (0L, "Paulo Antunes", "paulo_antunes@email.com.br", "13465278", "https://i.imgur.com/JR7kUFU.jpg"));		
	}	

	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
		
	}
	
	@Test
	@DisplayName ("Retornar 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<UsuarioModel> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("silva");
		assertEquals (3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("joao da silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("manuela da silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("adriana da silva"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

	
	
	
}
