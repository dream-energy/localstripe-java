package fr.dreamenergy.localstripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.dreamenergy.localstripe")
public class LocalStripeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalStripeApplication.class, args);
	}
}