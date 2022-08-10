package com.blog.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message= "O nome é obrigatório")
	private String usuario;
	
	@NotNull (message= "O email é obrigatório")
	@Email (message = "Insira seu email para logar seu usuário!")
	private String email;
	
	@NotBlank  (message = "Insira sua senha de minimo 6 digitos")
	@Size (min = 6)
	private String senha;
	
	@Size (max=5000, message= "O link da foto deve ter no máximo 5000 caracteres")
	private String foto;
	
	@OneToMany (mappedBy = "usuario", cascade= CascadeType.REMOVE )
	@JsonIgnoreProperties ("usuario")
	private List<PostagemModel> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}
	
	
	
	
	
	
	
	
	

}
