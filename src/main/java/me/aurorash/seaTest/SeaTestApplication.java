package me.aurorash.seaTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan("me.aurorash.seaTest")
@EnableJpaRepositories(basePackages = "me.aurorash.seaTest")
public class SeaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaTestApplication.class, args);
	}

}
