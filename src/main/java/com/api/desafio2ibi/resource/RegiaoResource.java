package com.api.desafio2ibi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.desafio2ibi.model.Regiao;
import com.api.desafio2ibi.repository.RegiaoRepository;

@RestController
@RequestMapping("/regioes")
public class RegiaoResource {
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	
	@GetMapping
	public List<Regiao> listar(){
		return (List<Regiao>) regiaoRepository.findAll();	
	}
	
	@PostMapping
	public ResponseEntity<Regiao> criar (@Valid @RequestBody Regiao regiao, 	HttpServletResponse response ) {
		Regiao regiaoSalva = regiaoRepository.save(regiao);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri()
		.path("/{id}").buildAndExpand(regiaoSalva.getId()).toUri();
		response.setHeader("location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(regiaoSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Regiao> pesquisar(@PathVariable("id") long id){
		Regiao regiao = regiaoRepository.findById(id);
		return regiao !=null? ResponseEntity.ok(regiao) : ResponseEntity.notFound().build() ;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover( @PathVariable Long id) {
		regiaoRepository.deleteById(id);
		
	}

}