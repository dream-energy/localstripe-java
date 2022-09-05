package fr.dreamenergy.localstripe.test;

import java.util.List;

import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;

@Lazy
@Configuration
@ComponentScan(basePackages = { "fr.dreamenergy.localstripe" })
public class SpringBootTestConfiguration {

	private final static String LOCAL_STRIPE_DOCKER_IMAGE = "adrienverge/localstripe:1.13.6";

	@LocalServerPort
	protected int port;

	@Bean
	TestTemplateInvocationContextProvider getTestTemplateInvocationContextProvider(
			List<StripeTestCase> stripeTestCases) {
		return new TestTemplateInvocationContextProviderImpl(stripeTestCases);
	}

	@Bean
	StripeTestCase localStripeJavaTestCase() {
		return new StripeTestCase("localstripe-java", "http://localhost:" + port, "api_key");
	}

	@Bean
	StripeTestCase localStripePythonTestCase() {
		GenericContainer localStripePythonContainer = new GenericContainer(LOCAL_STRIPE_DOCKER_IMAGE)
				.withExposedPorts(8420).waitingFor(Wait.forListeningPort())
				.withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("localstripe-python")));
		localStripePythonContainer.start();
		return new StripeTestCase("localstripe-python", "http://" + localStripePythonContainer.getHost() + ":"
				+ localStripePythonContainer.getFirstMappedPort(), "sk_test_12345");
	}
}
