package fr.dreamenergy.localstripe.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stripe.model.AutomaticPaymentMethodsPaymentIntent;
import com.stripe.model.PaymentIntent;

import fr.dreamenergy.localstripe.repository.PaymentIntentRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/v1/payment_intents")
public class PaymentIntentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentIntentController.class);

	@Autowired
	PaymentIntentRepository paymentIntentRepository;

	@PostMapping
	public PaymentIntent createPaymentIntent(@Positive long amount, @NotNull String currency,
			@RequestParam(name = "payment_method", required = false) String paymentMethod,
			@RequestParam(name = "automatic_payment_methods[enabled]", required = false) Boolean automaticPaymentMethodsEnabled) {
		PaymentIntent paymentIntent = new PaymentIntent();
		paymentIntent.setId("pi_" + RandomStringUtils.random(14, true, true));
		paymentIntent.setAmount(amount);
		paymentIntent.setCurrency(currency);
		paymentIntent.setCharges(null); // TODO
		if (automaticPaymentMethodsEnabled != null) {
			AutomaticPaymentMethodsPaymentIntent automaticPaymentMethodsPaymentIntent = new AutomaticPaymentMethodsPaymentIntent();
			automaticPaymentMethodsPaymentIntent.setEnabled(automaticPaymentMethodsEnabled);
			paymentIntent.setAutomaticPaymentMethods(automaticPaymentMethodsPaymentIntent);
		}		
		paymentIntent.setClientSecret(paymentIntent.getId() + "_secret_" + RandomStringUtils.random(16, true, true));
		paymentIntent.setStatus("requires_payment_method");
		paymentIntentRepository.save(paymentIntent);
		LOG.info("PaymentIntent with id [{}] has been created.", paymentIntent.getId());
		return paymentIntent;
	}

	@GetMapping("/{id}")
	public PaymentIntent retrievePaymentIntent(@PathVariable String id) {
		return paymentIntentRepository.findById(id).orElseThrow(() -> {
			String message = "PaymentIntent with id [%s] not found.".formatted(id);
			LOG.error(message);
			return new ResponseStatusException(HttpStatus.NOT_FOUND, message);
		});
	}

}
