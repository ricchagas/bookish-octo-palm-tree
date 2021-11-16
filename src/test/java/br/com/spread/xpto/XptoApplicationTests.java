package br.com.spread.xpto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.spread.xpto.model.EnderecoEntity;
import br.com.spread.xpto.service.EnderecoService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
class XptoApplicationTests {
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	private MockMvc mockMvc;

	//@Test
	public void createAddress() {
		EnderecoEntity ender = EnderecoEntity.builder().cep("10").cidade("spo").build();
		assertNotNull(ender.getCep());
		assertNotNull(ender);
	}

	@Test
	public void featchAddress() {
		assertFalse(enderecoService.fetchAllAddress().isEmpty());
	}
	
	@Test
	public void featchAddressFromURI() throws Exception {

		/*MvcResult result = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/v1/party").param("legacyOrganizationId", "25666")
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andReturn();
		String resultSS = result.getResponse().getContentAsString();
		assertNotNull(resultSS);*/						
		
		MvcResult result = this.mockMvc.perform( MockMvcRequestBuilders.get("/api/v1/endereco/address/IT")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String resultSS = result.getResponse().getContentAsString();
		assertNotNull(resultSS);								
		
	}
	
	@Test
	public void featchClientFromURI() throws Exception {

		/*MvcResult result = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/v1/party").param("legacyOrganizationId", "25666")
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andReturn();
		String resultSS = result.getResponse().getContentAsString();
		assertNotNull(resultSS);*/						
		
		MvcResult result = this.mockMvc.perform( MockMvcRequestBuilders.get("/api/v1/cliente/4")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String resultSS = result.getResponse().getContentAsString();
		assertNotNull(resultSS);								
		
	}


	
	

}
