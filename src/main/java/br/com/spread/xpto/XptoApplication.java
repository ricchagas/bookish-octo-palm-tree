package br.com.spread.xpto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("br.com.spread.xpto")
public class XptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XptoApplication.class, args);
	}

}
