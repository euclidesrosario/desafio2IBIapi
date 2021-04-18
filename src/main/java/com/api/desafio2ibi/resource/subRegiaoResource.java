package com.api.desafio2ibi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.desafio2ibi.model.SubRegiao;
import com.api.desafio2ibi.repository.SubRegiaoRepository;
import com.api.desafio2ibi.services.SubRegiaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/subregioes")
@Api(value="Recurso sub regioes")
public class SubRegiaoResource {
	
	
	@Autowired
	private SubRegiaoRepository subRegiaoRepository;
	@Autowired
	private SubRegiaoService subRegiaoService;
	
	
	@GetMapping
	@ApiOperation(value="retorna uma lista de sub-regioes")

	public List<SubRegiao> listar(){
		return (List<SubRegiao>) subRegiaoRepository.findAll();	
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="retorna uma sub-regioes especifica")

	public ResponseEntity<SubRegiao> pesuisarPorId (@PathVariable("id") long id){
		SubRegiao subRegiao = subRegiaoRepository.findById(id);
		return subRegiao !=null? ResponseEntity.ok(subRegiao) : ResponseEntity.notFound().build();
		
	}  
	    
	@PostMapping
	@ApiOperation(value="salva uma sub-regiao")

	public ResponseEntity<SubRegiao> registar(@Valid @RequestBody SubRegiao subRegiao, HttpServletResponse response) throws Exception{
		SubRegiao SubregiaoExistente = subRegiaoRepository.findByNome(subRegiao.getNome());
		
		if(SubregiaoExistente !=null) {
			throw new IncorrectResultSizeDataAccessException(0);	
		}
		
		 SubRegiao SubregiaoSalva =subRegiaoService.salvar(subRegiao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(SubregiaoSalva.getId()).toUri();
		response.setHeader("location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(SubregiaoSalva);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="apaga uma sub-regiao atraves do ID")

	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable("id") Long id){
		SubRegiao subRegiao = subRegiaoService.pesquisarPeloId(id);
		subRegiaoRepository.delete(subRegiao);
		
	}
	@PutMapping("/{id}")
	@ApiOperation(value="atualiza os dados de uma de sub-regiao, atraves do ID")

	public ResponseEntity<SubRegiao> actualizar(@PathVariable("id")Long id,@Valid @RequestBody SubRegiao subRegiao){
		SubRegiao subRegiaoSalva =subRegiaoService.atualizar(id, subRegiao);
		return ResponseEntity.ok(subRegiaoSalva);
	}
	

}
