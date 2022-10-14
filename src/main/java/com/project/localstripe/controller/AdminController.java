package com.project.localstripe.controller;

import com.project.localstripe.api.response.ApiResponse;
import com.project.localstripe.common.Constants;
import com.project.localstripe.repository.PaymentIntentRepository;
import com.stripe.model.PaymentIntent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@Slf4j
@Validated
@RestController
@RequestMapping("/__admin")
public class AdminController {


    @Autowired
    PaymentIntentRepository paymentIntentRepository;

    @PostMapping("/payment_intents/complete")
    public ResponseEntity<Void> completePaymentIntent(@RequestParam(required = false) String id, @RequestParam(required = false) Long amount) {
        for(PaymentIntent paymentIntent: paymentIntentRepository.findAll()) {
            if (paymentIntent.getId().equals(id) || paymentIntent.getAmount().equals(amount)) {
                paymentIntent.setStatus("succeeded");
                log.info("PaymentIntent with id [{}] has been completed.");
                return ResponseEntity.ok().build();
            }
        }
        String message = "Cannot find PaymentIntent with id [%s] or amount [%s].".formatted(id, amount);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
    }
}
