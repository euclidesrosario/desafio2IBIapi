package com.api.desafio2ibi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubRegiao {
	
	/* ID -> dentificador – gerado automaticamente/*/
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	private String nome;
	
}
