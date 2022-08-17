package com.blog.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name= "tb_tema")
public class TemaModel {
	@Id    // essa parte vai ser igual a PostagemModel;
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	
	@NotBlank (message = "O atributo descrição não pode ser nulo!!" )
	private String descricao;
	
	//quando chama esse comando oneToMany tem que indicar que é o ONE (tema) e embaixo chamar o MANY(postagem);
	@OneToMany (mappedBy = "tema") // chave estrangeira para ligar o tema a postagem;
				// mapeando o tema;
	@JsonIgnoreProperties ("tema") // evitando a recursividade que pode dar no programa quando fizer o relacionamento de postagem com tema;
	private List<PostagemModel> postagem; 
		//o list é um array para indicar que vai ter MUITAS postagens para UM tema;
		//instanciando um novo objeto (o new que se bota no eclipse não precisa botar no spring pq o list ele ja reconhceu como novo objeto;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}
	
	
	

}
