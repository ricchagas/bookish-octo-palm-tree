package br.com.spread.xpto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spread.xpto.model.EnderecoEntity;

@Repository
public interface EnderecoRepository  extends JpaRepository <EnderecoEntity, Long>{	
	Optional<EnderecoEntity> findByLogradouro (String logradouro );
	Optional<EnderecoEntity> findByCep (String cep);
	

}
