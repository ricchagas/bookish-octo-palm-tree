package br.com.spread.xpto.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spread.xpto.model.ClienteEntity;
import br.com.spread.xpto.service.ClienteService;

@RestController
@RequestMapping ( "/api/v1/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/{id}", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ClienteEntity> fetchById (@PathVariable("id") Long id ) 	{
		return ResponseEntity.ok().body(clienteService.findById(id));
	}
	
	@GetMapping(value = "/", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<ClienteEntity>> fetchAll () 	{
		return ResponseEntity.ok().body(clienteService.fetchAll());
	}
	
	@GetMapping(value = "/nome/{name}", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ClienteEntity> fetchByName (@PathVariable("name") String name ) 	{
		return ResponseEntity.ok().body(clienteService.fetchByName(name));
	}
}
