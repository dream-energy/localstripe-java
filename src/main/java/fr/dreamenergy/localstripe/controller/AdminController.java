package fr.dreamenergy.localstripe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stripe.model.PaymentIntent;

import fr.dreamenergy.localstripe.repository.PaymentIntentRepository;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/__admin")
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	PaymentIntentRepository paymentIntentRepository;

	@PostMapping("/payment_intents/complete")
	public ResponseEntity<Void> completePaymentIntent(@RequestParam(required = false) String id, @RequestParam(required = false) Long amount) {
		for(PaymentIntent paymentIntent: paymentIntentRepository.findAll()) {
			if (paymentIntent.getId().equals(id) || paymentIntent.getAmount().equals(amount)) {
				paymentIntent.setStatus("succeeded");
				LOG.info("PaymentIntent with id [{}] has been completed.", paymentIntent.getId());
				return ResponseEntity.ok().build();
			}
		}
		String message = "Cannot find PaymentIntent with id [%s] or amount [%s].".formatted(id, amount);
		LOG.error(message);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
	}

}
