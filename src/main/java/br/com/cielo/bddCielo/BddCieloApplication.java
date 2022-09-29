package br.com.cielo.bddCielo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("br.com.cielo.bddCielo")
@EnableJpaRepositories("br.com.cielo.bddCielo")
@SpringBootApplication
public class BddCieloApplication {

	public static void main(String[] args) {
		SpringApplication.run(BddCieloApplication.class, args);
	}

}
