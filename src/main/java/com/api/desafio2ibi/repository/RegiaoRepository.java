package com.api.desafio2ibi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.desafio2ibi.model.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

	Regiao findById(long id);

	Regiao findByNome(String nome);

}
