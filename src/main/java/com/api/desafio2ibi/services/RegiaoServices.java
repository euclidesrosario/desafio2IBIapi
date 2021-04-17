package com.api.desafio2ibi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.desafio2ibi.model.Regiao;
import com.api.desafio2ibi.repository.RegiaoRepository;

@Service
public class RegiaoServices {
	@Autowired
	private RegiaoRepository regiaoRepository;

	public Regiao atualizar(long id, Regiao regiao) {

		Regiao RegiaoSalva = regiaoRepository.findById(id);
		if (RegiaoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(regiao, RegiaoSalva, "id");
		return regiaoRepository.save(RegiaoSalva);

	}

	public Regiao buscarRegiaoPeloId(long id) {
		Regiao regiaoExistente = regiaoRepository.findById(id);
		if (regiaoExistente == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return regiaoExistente;

	}
}
