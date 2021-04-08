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
	
	
	/* ID -> uma regiao possui arias sub regioes/*/

	@OneToMany
	private List<SubRegiao> subRegioao;
	
	public List<SubRegiao> getSubRegioao() {
		return subRegioao;
	}
	public void setSubRegioao(List<SubRegiao> subRegioao) {
		this.subRegioao = subRegioao;
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
	
	
	
}
