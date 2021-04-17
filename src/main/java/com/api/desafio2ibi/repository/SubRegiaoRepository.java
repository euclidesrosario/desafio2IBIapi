package com.api.desafio2ibi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.desafio2ibi.model.SubRegiao;

public interface SubRegiaoRepository extends JpaRepository<SubRegiao, Long>{
	SubRegiao findById(long id);

	SubRegiao findByNome(String nome);

	
}
