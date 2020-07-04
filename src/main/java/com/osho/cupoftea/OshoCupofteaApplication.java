package com.osho.cupoftea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@ServletComponentScan
@EnableWebSecurity
@SpringBootApplication(scanBasePackages = {"com.osho"})
@EnableJpaRepositories(basePackages = {"com.osho.repository"})
@EntityScan(basePackages = {"com.osho.model"})
public class OshoCupofteaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OshoCupofteaApplication.class, args);
	}

}
 