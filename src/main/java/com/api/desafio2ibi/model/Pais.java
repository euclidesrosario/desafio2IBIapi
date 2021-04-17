package com.api.desafio2ibi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity

public class Pais {
	
	/* ID -> dentificador – gerado automaticamente/*/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String nome;
	@NotNull
	private String capital;
	@NotNull
	private long area;
	
	@ManyToOne
	private SubRegiao subRegiao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getId() {
		return id;
	}
	
}
