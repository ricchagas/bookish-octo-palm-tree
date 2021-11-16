package br.com.spread.xpto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import br.com.spread.xpto.exception.XptoNotfoundException;
import br.com.spread.xpto.model.ClienteEntity;
import br.com.spread.xpto.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClienteService {
	@Autowired
	EnderecoService service;

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteEntity findById(Long id)  {
		
		log.info("Buscando o cliente com id {}", id);
		var cliente = clienteRepository.findById(id);
		return checkReturnOrThrowException(id, cliente);
	}

	public List<ClienteEntity> fetchAll() {
		
		return clienteRepository.findAll();
		
	}
	
	public ClienteEntity fetchByName(String name) {
		log.info("Buscando o cliente com nome {}", name);
		var cliente = clienteRepository.findByNome(name);
		
		return checkReturnOrThrowException(name, cliente);
	}	
	
	public ClienteEntity fetchByCpf(String cpf) {
		log.info("Buscando o cliente com cpf {}", cpf);
		var cliente = clienteRepository.findByCpf(cpf);
		return checkReturnOrThrowException(cpf, cliente);
	}	
	
	private ClienteEntity checkReturnOrThrowException(Object id, Optional<ClienteEntity> cliente) {
		log.info("cliente retornado {}", cliente);	
		return cliente.orElseThrow(()-> new  XptoNotfoundException("O Cliente nao foi encontrado"));
	}

}
