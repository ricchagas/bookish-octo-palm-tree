package br.com.spread.xpto.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.spread.xpto.dto.AddressDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class AddressRepository {
	@Autowired
	NamedParameterJdbcTemplate oracleNamedParameterJdbcTemplate;
	
	@Value("${query.locations_select}")
	String querySelect;
	

	@Value("${query.locations_select_by_country}")
	String querySelectByContryId;

	
		
	public List<AddressDTO> fetchAll()
	{
		log.info("Fetching all address ");
		
		return oracleNamedParameterJdbcTemplate.query(querySelect,  (rs, rowNum) ->
					AddressDTO.builder()
					.cep(rs.getString("POSTAL_CODE"))
					.cidade(rs.getString("CITY"))
					.endereco(rs.getString("STREET_ADDRESS"))
					.locationId(rs.getLong("LOCATION_ID"))
					.paisId(rs.getString("COUNTRY_ID"))
					.paisNome(rs.getString("COUNTRY_NAME"))
					.uf(rs.getString("STATE_PROVINCE")).build());		
	}
	
	public List<AddressDTO> fetchByContryId(String countryId)
	{
		log.info("Fetching all address ");
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("country_id", countryId);
		
		return oracleNamedParameterJdbcTemplate.query(querySelectByContryId, param,   (rs, rowNum) ->
					AddressDTO.builder()
					.cep(rs.getString("POSTAL_CODE"))
					.cidade(rs.getString("CITY"))
					.endereco(rs.getString("STREET_ADDRESS"))
					.locationId(rs.getLong("LOCATION_ID"))
					.paisId(rs.getString("COUNTRY_ID"))
					.paisNome(rs.getString("COUNTRY_NAME"))
					.uf(rs.getString("STATE_PROVINCE")).build());		
	}
	
}
