package fr.dreamenergy.localstripe.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;


@SpringBootTest(classes = SpringBootTestConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentIntentControllerTest {
	
	@LocalServerPort
	protected int port;
	
	@BeforeEach
	public void initialize() {
		Stripe.overrideApiBase("http://localhost:" + port);
		Stripe.apiKey = "sk_test_12345";
	}
	
	@Test
	void createThenRetrievePaymentIntent() throws StripeException {
		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount(1000L)
				.setCurrency("eur")
				.setAutomaticPaymentMethods(
						PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build())
				.build();
		PaymentIntent paymentIntent = PaymentIntent.create(params);
		Assertions.assertThat(paymentIntent.getAmount()).isEqualTo(1000L);
		Assertions.assertThat(paymentIntent.getCurrency()).isEqualTo("eur");
		Assertions.assertThat(paymentIntent.getId()).isNotNull();
		Assertions.assertThat(paymentIntent.getClientSecret()).isNotNull();
		String paymentIntentId = paymentIntent.getId();
		
		paymentIntent = PaymentIntent.retrieve(paymentIntentId);
		Assertions.assertThat(paymentIntent.getAmount()).isEqualTo(1000L);
		Assertions.assertThat(paymentIntent.getCurrency()).isEqualTo("eur");
		Assertions.assertThat(paymentIntent.getId()).isEqualTo(paymentIntentId);		
	}
	

}
