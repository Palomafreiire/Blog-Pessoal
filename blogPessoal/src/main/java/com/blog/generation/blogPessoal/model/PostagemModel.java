package com.blog.generation.blogPessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // para que essa classe seja interpretada no banco de dados como uma entidade tem que inserir isso;
// são parametros que se bota em cima da classe para defenir o comportamentos dela
// indica que essa classe será uma entidade 
@Table(name = "postagem") // estou dizendo com esse comando que essa entidade será uma tabelo dentro do banco de dados
public class PostagemModel { 
	
	@Id // colocando aqui para esse atributo se tratar da id da tabela; identificar a chave primária da tabela;
	@GeneratedValue(strategy = GenerationType.IDENTITY) //  indica o esquema auto increment para a chave primaria;
	// esse comando strategy está evidenciando a chave primária;
	private Long id;
	
	
	@NotBlank (message = "O titulo não pode ser nulo!!" ) //não permite valor nulo e o comprimento (sem considerar espaços em branco) deve ser maior que zero;
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotNull (message = "O texto não pode ser nulo!!" ) // Não permite um valor nulo, porém permite um valor vazio;
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;
	
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne    // comando da chave estrangeira para ligar a outra tabela
	@JsonIgnoreProperties ("postagem") // evitando a recursividade que pode dar no programa quando fizer o relacionamento de postagem com tema;
	private TemaModel tema;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private UsuarioModel usuario;
	
	
	// se cria os gets and setters nessa classe porque será nossa principal, o nosso objeto; nossa "tabela principal e seus atributos;
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
	public TemaModel getTema() {
		return tema;
	}
	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
	

}
