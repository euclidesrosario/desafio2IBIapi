package com.api.desafio2ibi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SubRegiao {
	
	/* ID -> dentificador – gerado automaticamente/*/
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	/* ID ->  uma sub regiao tem uma lista de paises/*/
	@ManyToMany
	private List<Pais> pais;
	
	/* ID ->  uma ou varias sub regioes pertencem a uma regiao/*/
	@ManyToOne
	private Regiao regiao;
	
	
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	private String nome;
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
