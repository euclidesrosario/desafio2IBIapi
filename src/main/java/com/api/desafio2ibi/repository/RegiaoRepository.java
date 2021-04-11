package com.api.desafio2ibi.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.desafio2ibi.model.Regiao;

public interface RegiaoRepository extends CrudRepository<Regiao, Long> {

	Regiao findById(long id);

}
