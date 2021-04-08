package com.api.desafio2ibi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Regiao {

	/* ID -> dentificador – gerado automaticamente/*/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	private List<SubRegiao> subRegioao;
	
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
	
	
	
}
