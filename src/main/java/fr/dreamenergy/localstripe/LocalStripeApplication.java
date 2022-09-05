package fr.dreamenergy.localstripe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.dreamenergy.localstripe")
public class LocalStripeApplication {

	private static final Logger LOG = LoggerFactory.getLogger(LocalStripeApplication.class);
	
	public static void main(String[] args) {
		LOG.info("Starting LocalStripe application...");
		SpringApplication.run(LocalStripeApplication.class, args);
	}
}