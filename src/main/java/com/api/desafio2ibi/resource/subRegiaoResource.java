package com.api.desafio2ibi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio2ibi.model.SubRegiao;
import com.api.desafio2ibi.repository.SubRegiaoRepository;

@RestController
@RequestMapping("/subregioes")
public class subRegiaoResource {
	@Autowired
	private SubRegiaoRepository subRegiaoRepository;
	
	@GetMapping
	public List<SubRegiao> listar(){
		return (List<SubRegiao>) subRegiaoRepository.findAll();
		
	}
	
	

}
