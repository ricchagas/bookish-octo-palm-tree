package br.com.spread.xpto;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import br.com.spread.xpto.model.ClienteEntity;
import br.com.spread.xpto.model.EnderecoEntity;

@Configuration
@EnableJpaRepositories(basePackages="br.com.spread.xpto.repository", entityManagerFactoryRef = "xptoEntityManager" )
public class DataBaseConfig {
	
	@Bean(name="ConfiguracaoDoBanco")
	@ConfigurationProperties("datasource.db")
	public HikariConfig loadDatabaseConfig()
	{
		return new HikariConfig();	
	}
	
	@Bean("xptoEntityManager")
	public LocalContainerEntityManagerFactoryBean createFactory(EntityManagerFactoryBuilder builder, DataSource dataSource)
	{
		return builder.dataSource(dataSource).packages(ClienteEntity.class, EnderecoEntity.class).build()		;	
	}
	
	@Bean
	public HikariDataSource createDatasource(HikariConfig config)
	{	
		return new HikariDataSource(config);
	}
}

