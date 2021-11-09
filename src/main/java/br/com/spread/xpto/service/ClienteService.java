package br.com.spread.xpto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.spread.xpto.model.ClienteModel;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClienteService {
	@Autowired
	EnderecoService service;
	
	public ClienteModel findById (Long id)
	{
		var cli1 = ClienteModel.builder().cpf("10").nome("Alan").id(id).build();		
		cli1.setEndereco(service.findById(10L));
		log.info("Cliente Retornado {}", cli1);
		return cli1;
	}
}
