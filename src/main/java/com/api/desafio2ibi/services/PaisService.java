package com.api.desafio2ibi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.desafio2ibi.model.Pais;
import com.api.desafio2ibi.repository.PaisRepository;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;

	public Pais atualizar( long id,Pais pais) {
		Pais paisExiste = paisRepository.findById(id);
		if (paisExiste == null) {
			throw new NullPointerException();
		}
		BeanUtils.copyProperties(pais, paisExiste, "id");

		return paisRepository.save(paisExiste);
	}
}
