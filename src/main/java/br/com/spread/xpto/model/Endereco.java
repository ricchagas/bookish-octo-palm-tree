package br.com.spread.xpto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder (builderClassName = "Builder")
public class Endereco {
	private Long id;
	private String cep;
	private String logradouro;
	private String numero;
	private String cidade;
	private String uf;
}
