package br.com.spread.xpto.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor  
@NoArgsConstructor
@Builder (builderClassName = "Builder")
public class ClienteModel {
	private Long id;
	private Endereco endereco;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	

}
