package br.com.spread.xpto.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spread.xpto.model.ClienteModel;
import br.com.spread.xpto.service.ClienteService;

@RestController
@RequestMapping ( "/api/v1/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/", consumes= { MediaType.APPLICATION_JSON_VALUE}, produces=  { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ClienteModel> fetchById ()
	{
		return ResponseEntity.ok().body(clienteService.findById(10L));
	}
	

}
