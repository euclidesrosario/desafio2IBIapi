package com.api.desafio2ibi.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio2ibi.model.Pais;
import com.api.desafio2ibi.repository.PaisRepository;
import com.api.desafio2ibi.repository.SubRegiaoRepository;

@RestController
@RequestMapping("/paises")
public class PaisResource {
	private PaisRepository paisRepository;
	private SubRegiaoRepository subRegiaoRepository;
	
	
	
	@GetMapping
	public List<Pais>  listar(){
		return (List<Pais>)  paisRepository.findAll();
	}
	
	public ResponseEntity<Pais> pesquisar(@PathVariable("id") long id){
		Pais pais = paisRepository.findById(id);
		return pais != null? ResponseEntity.ok(pais): ResponseEntity.notFound().build();
		
	}
	
	

}
