package br.com.spread.xpto;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages="br.com.spread.xpto.repository.x", entityManagerFactoryRef = "xptoOracleEntityManager" )
public class DataBaseOracleConfig {
	
	@Bean(name="ConfiguracaoDoBancoOracle")
	@ConfigurationProperties("datasource.oracle")
	public HikariConfig loadDatabaseConfig()
	{
		return new HikariConfig();	
	}
	
	@Bean
	public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate(@Qualifier("OracleDataSource") DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}	
	
	@Bean("xptoOracleEntityManager")
	public LocalContainerEntityManagerFactoryBean createFactory(EntityManagerFactoryBuilder builder, @Qualifier("OracleDataSource") DataSource dataSource)
	{
		return builder.dataSource(dataSource).packages(Object.class).build()		;	
	}
	
	@Bean(name="OracleDataSource")
	public HikariDataSource createDatasource( @Qualifier("ConfiguracaoDoBancoOracle") HikariConfig config)
	{	
		return new HikariDataSource(config);
	}
}

