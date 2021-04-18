package com.api.desafio2ibi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Sort;
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

import com.api.desafio2ibi.model.Pais;
import com.api.desafio2ibi.repository.PaisRepository;
import com.api.desafio2ibi.services.PaisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paises")
@Api(value=" Rest Api Paises")
public class PaisResource {
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PaisService paisService;

	@GetMapping
	@ApiOperation(value="retorna uma lista de paises")
	public List<Pais> listar() {

		List<Pais> paises = paisRepository.findAll();
		if (paises.isEmpty()) {
			throw new NullPointerException();
		}
		return paises;

	}

	@GetMapping("/{id}")
	@ApiOperation(value="retorna um pais de acordo com o ID informado")
	public ResponseEntity<Pais> pesquisar(@PathVariable("id") long id) {
		Pais pais = paisRepository.findById(id);
		return pais != null ? ResponseEntity.ok(pais) : ResponseEntity.notFound().build();

	}
	
	@PostMapping
	@ApiOperation(value="salva um pais, deve informar a sub regiao a que o pais pertence")
	public ResponseEntity<Pais> salvar(@Valid @RequestBody Pais pais, HttpServletResponse response) {
		Pais paisExistente = paisRepository.findByNome(pais.getNome());
		if (paisExistente != null) {
			throw new IncorrectResultSizeDataAccessException(1);
		}
		Pais paisSalvo = paisRepository.save(pais);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").build(paisSalvo.getId());
		response.setHeader("location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(paisSalvo);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="apaga um pais atraves do seu codigo id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("id") long id) {
		Pais pais = paisRepository.findById(id);
		if (pais == null) {
			throw new NullPointerException();
		}
		paisRepository.delete(pais);
	}

	@PutMapping
	@ApiOperation(value="atualiza os dados de um pais")
	public ResponseEntity<Pais> atualizar(long id, @Valid @RequestBody Pais pais){
		
		paisService.atualizar(id,pais);
		 return ResponseEntity.ok(pais);
		
	}

	@GetMapping("/nome")
	@ApiOperation(value="ordena a lista de paises pelo nome")
	public List<Pais> OrdenarPorNome(){
		List<Pais> allPaisSortedByNome = paisRepository.findAll(Sort.by("nome"));
		return allPaisSortedByNome;

	}
	
	@GetMapping("/capital")
	@ApiOperation(value="ordena a lista de paises pela capital")
	public List<Pais> OrdenarPorcapital(){
		List<Pais> allPaisSortedByCapital = paisRepository.findAll(Sort.by("capital"));
		return allPaisSortedByCapital;

	}
	
	
	
	@GetMapping("/subregiao")
	@ApiOperation(value="ordena a lista de paises pela sub regiao")
	public List<Pais> OrdenarPorSubRegiao(){
		List<Pais> allPaisSortedBySubRegiao = paisRepository.findAll(Sort.by("subRegiao"));
		return allPaisSortedBySubRegiao;

	}
	
}
