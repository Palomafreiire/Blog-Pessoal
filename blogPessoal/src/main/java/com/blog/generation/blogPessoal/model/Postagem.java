package com.blog.generation.blogPessoal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity // para que essa classe seja interpretada no banco de dados como uma entidade tem que inserir isso;
// são parametros que se bota em cima da classe para defenir o comportamentos dela
// indica que essa classe será uma entidade 
@Table(name = "postagem") // estou dizendo com esse comando que essa entidade será uma tabelo dentro do banco de dados
public class Postagem { 
	
	@Id // colocando aqui para esse atributo se tratar da id da tabela; identificar a chave primária da tabela;
	@GeneratedValue(strategy = GenerationType.IDENTITY) //  indica o esquema auto increment para a chave primaria;
	// esse comando strategy está evidenciando a chave primária;
	private Long id;
	
	
	@NotBlank (message = "O titulo não pode ser nulo!!" ) //não permite valor nulo e o comprimento (sem considerar espaços em branco) deve ser maior que zero;
	@Size (min=5, max=100)
	private String titulo;
	
	@NotNull (message = "O texto não pode ser nulo!!" ) // Não permite um valor nulo, porém permite um valor vazio;
	@Size (min=5, max=1000)
	private String texto;
	
	
	@UpdateTimestamp
	private LocalDateTime data;
	
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
	

}
