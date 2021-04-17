package com.api.desafio2ibi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SubRegiao {
	
	/* ID -> dentificador – gerado automaticamente/*/
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	

	@ManyToMany
	private List<Pais> pais;
	@Column(unique=true)
	private String nome;
	
	@NotNull
	@ManyToOne
	private Regiao regiao;
	
	
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public List<Pais> getPais() {
		return pais;
	}
	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}
	
	
}
