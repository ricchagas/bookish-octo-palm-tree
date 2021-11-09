package br.com.spread.xpto.service;

import org.springframework.stereotype.Component;

import br.com.spread.xpto.model.Endereco;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EnderecoService {

	public Endereco findById(Long id)
	{
		var ret = Endereco.builder().cep("xxdfss").cidade("Sao Paulo").logradouro("Avi Brasil").id(id) .build();
		log.info ("Endereco {}", ret);
		
		return ret;
		
	}
}
