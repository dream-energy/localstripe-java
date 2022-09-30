package fr.dreamenergy.localstripe.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = SpringBootTestConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentIntentControllerTest {
	
	@Autowired
    @RegisterExtension
    TestTemplateInvocationContextProvider testTemplateInvocationContextProvider;
	
	@Autowired
	@Qualifier("localStripeJavaTestCase")
	StripeTestCase localStripeJavaTestCase;
	
	@TestTemplate
	void createThenRetrievePaymentIntent(StripeTestCase stripeTestCase) throws StripeException {
		Stripe.overrideApiBase(stripeTestCase.url());
		Stripe.apiKey = stripeTestCase.apiKey();
		
		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount(1000L)
				.setCurrency("eur")
				.build();
		PaymentIntent paymentIntent = PaymentIntent.create(params);
		Assertions.assertThat(paymentIntent.getAmount()).isEqualTo(1000L);
		Assertions.assertThat(paymentIntent.getCurrency()).isEqualTo("eur");
		Assertions.assertThat(paymentIntent.getId()).isNotNull();
		Assertions.assertThat(paymentIntent.getClientSecret()).isNotNull();
		Assertions.assertThat(paymentIntent.getAutomaticPaymentMethods()).isNull();
		Assertions.assertThat(paymentIntent.getStatus()).isEqualTo("requires_payment_method");
		String paymentIntentId = paymentIntent.getId();
		
		paymentIntent = PaymentIntent.retrieve(paymentIntentId);
		Assertions.assertThat(paymentIntent.getAmount()).isEqualTo(1000L);
		Assertions.assertThat(paymentIntent.getCurrency()).isEqualTo("eur");
		Assertions.assertThat(paymentIntent.getId()).isEqualTo(paymentIntentId);
		Assertions.assertThat(paymentIntent.getStatus()).isEqualTo("requires_payment_method");
	}
	
	@Test // Not compatible with localstripe Python
	void createThenRetrievePaymentIntentWithAutomaticPaymentMethods() throws StripeException {
		Stripe.overrideApiBase(localStripeJavaTestCase.url());
		Stripe.apiKey = localStripeJavaTestCase.apiKey();
		
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
		Assertions.assertThat(paymentIntent.getAutomaticPaymentMethods()).isNotNull();
		Assertions.assertThat(paymentIntent.getAutomaticPaymentMethods().getEnabled()).isTrue();
		Assertions.assertThat(paymentIntent.getStatus()).isEqualTo("requires_payment_method");
		String paymentIntentId = paymentIntent.getId();
		
		paymentIntent = PaymentIntent.retrieve(paymentIntentId);
		Assertions.assertThat(paymentIntent.getAmount()).isEqualTo(1000L);
		Assertions.assertThat(paymentIntent.getCurrency()).isEqualTo("eur");
		Assertions.assertThat(paymentIntent.getId()).isEqualTo(paymentIntentId);
		Assertions.assertThat(paymentIntent.getStatus()).isEqualTo("requires_payment_method");
	}	

}
