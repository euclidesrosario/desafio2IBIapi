package com.api.desafio2ibi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.desafio2ibi.model.Regiao;
import com.api.desafio2ibi.model.SubRegiao;
import com.api.desafio2ibi.repository.RegiaoRepository;
import com.api.desafio2ibi.repository.SubRegiaoRepository;

@Service
public class SubRegiaoService {

	@Autowired
	private SubRegiaoRepository subRegiaoRepository;

	@Autowired
	RegiaoServices regiaoService;
	@Autowired
	RegiaoRepository regiaoRepository;

	public SubRegiao salvar(SubRegiao subRegiao) {

		SubRegiao SubRegiaoExiste = subRegiaoRepository.findByNome(subRegiao.getNome());

		if (SubRegiaoExiste != null) {
			throw new DataIntegrityViolationException("Ja existe uma sub-regiao com o nome: -> " + subRegiao.getNome());
		} else {
			Regiao regiao = regiaoRepository.findById(subRegiao.getRegiao().getId());
			if (regiao == null) {
				throw new DataIntegrityViolationException("a regiao que informou nao existe");
			} else {

				return subRegiaoRepository.save(subRegiao);
			}
		}
	}

	public SubRegiao pesquisarPeloId(@PathVariable("id") long id) {
		SubRegiao SubRegiaoExiste = subRegiaoRepository.findById(id);
		if (SubRegiaoExiste == null) {
			throw new EmptyResultDataAccessException(1);
		} else {
			return SubRegiaoExiste;
		}
	}
	
	public SubRegiao atualizar (@PathVariable ("id")long id, SubRegiao subRegiao)	{
		SubRegiao subRegiaoSalva = subRegiaoRepository.findById(id);
		
	if(subRegiao==null) {
		 throw new EmptyResultDataAccessException(1);
	} else {
		
		BeanUtils.copyProperties(subRegiao,subRegiaoSalva, "id");
		
		return subRegiaoRepository.save(subRegiao);
	}
	
	
}
	
	
	
	
}
