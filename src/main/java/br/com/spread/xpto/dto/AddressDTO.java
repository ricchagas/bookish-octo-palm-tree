package br.com.spread.xpto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class AddressDTO { 
	Long locationId; 
	String endereco;
	String cep;
	String cidade;
	String uf;
	String paisId;
	String paisNome;
}
