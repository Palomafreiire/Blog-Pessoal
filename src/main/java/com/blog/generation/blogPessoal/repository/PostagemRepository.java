package com.blog.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.generation.blogPessoal.model.PostagemModel;

@Repository // para indicar ao BD que essa vai ser uma classe do tipo repositorio 
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> { // importo a classe postagem e long por ser o tipo da nossa ID;
	
	public List<PostagemModel> findAllByTituloContainingIgnoreCase (@Param ("titulo") String titulo); // buscar todos pelo titulo, o titulo é o nome do atributo da postagem;
								// o ignore case é para o java ignorar o maiusculo do minusculo e vai transformar todos em minusculo para o programa localizar;
	
	
	
	// cria um repository para se comunicar com o banco de dados;
	//Qual interface devemos herdar no repository = JpaRepository;
	
}
