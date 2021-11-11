package br.com.spread.xpto.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spread.xpto.model.EnderecoEntity;
import br.com.spread.xpto.service.EnderecoService;

@RestController
@RequestMapping ( "/api/v1/endereco")
public class EnderecoResource {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(value = "/{id}", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<EnderecoEntity> fetchById (@PathVariable("id") Long id ) 	{
		return ResponseEntity.ok().body(enderecoService.findById(id));
	}

	@GetMapping(value = "/logradouro/{logradouro}", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<EnderecoEntity> findByLogradouro (@PathVariable("logradouro") String logradouro ) 	{
		return ResponseEntity.ok().body(enderecoService.findByLogradouro(logradouro));
	}
	
	@GetMapping(value = "/cep/{cep}", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<EnderecoEntity> findByCep (@PathVariable("cep") String cep ) 	{
		return ResponseEntity.ok().body(enderecoService.findByCep(cep));
	}	
	
	
}
