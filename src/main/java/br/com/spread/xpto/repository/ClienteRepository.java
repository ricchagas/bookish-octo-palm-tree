package br.com.spread.xpto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spread.xpto.model.ClienteEntity;

@Repository
public interface ClienteRepository  extends JpaRepository <ClienteEntity, Long>{	
	Optional<ClienteEntity> findByNome (String name);
	Optional<ClienteEntity> findByCpf (String cpf);	
}
