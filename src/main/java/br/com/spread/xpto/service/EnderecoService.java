package br.com.spread.xpto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.spread.xpto.dto.AddressDTO;
import br.com.spread.xpto.exception.XptoNotfoundException;
import br.com.spread.xpto.model.EnderecoEntity;
import br.com.spread.xpto.repository.AddressRepository;
import br.com.spread.xpto.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EnderecoService {
	
	@Autowired
	private  EnderecoRepository repository;
	
	@Autowired
	private  AddressRepository addressRepository;

	public EnderecoEntity findById(Long id){
	var endereco = repository.findById(id);
		log.info ("Endereco {}", endereco);
		
		return checkReturnOrThrowException(id, endereco);
		
	}
	
	
	public EnderecoEntity findByLogradouro (String logradouro) {
		
	var endereco = repository.findByLogradouro(logradouro);
		log.info ("Endereco {}", endereco);
		
		return checkReturnOrThrowException(logradouro, endereco);
	}
	
	
	public EnderecoEntity findByCep(String cep) {
		
		 var endereco = repository.findByCep(cep);
		 	log.info ("Endereco {}", endereco);
		
		return checkReturnOrThrowException(cep, endereco);
	}
		
	private EnderecoEntity checkReturnOrThrowException(Object id, Optional<EnderecoEntity> endereco) {
		log.info("endereco retornado {}", endereco);	
		return endereco.orElseThrow(()-> new  XptoNotfoundException("O Cliente nao foi encontrado"));
	}
	
	public List<AddressDTO> fetchAllAddress ()
	{
		return addressRepository.fetchAll();
	}	
	
	public  List<AddressDTO> fetchByContryId(String countryId)
	{
		return addressRepository.fetchByContryId(countryId);		
	}
	
}
