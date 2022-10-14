package com.project.localstripe.controller;


import com.project.localstripe.request.CreatePaymentIntentDTO;
import com.project.localstripe.request.PaymentIntentRequestDTO;
import com.project.localstripe.request.UpdatePaymentIntentDTO;
import com.project.localstripe.service.PaymentIntentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@Slf4j
@RestController
@RequestMapping("/v1/payment_intents")
public class PaymentIntentController {

    @Autowired
    PaymentIntentService paymentIntentService;
//
//    private static final Logger LOG = (Logger) LoggerFactory.getLogger(PaymentIntentController.class);
//
////    @Autowired
////    PaymentIntentRepository paymentIntentRepository;
////
////    @PostMapping
////    public PaymentIntent createPaymentIntent(long amount, String currency,
////                                             @RequestParam(name = "payment_method", required = false) String paymentMethod,
////                                             @RequestParam(name = "automatic_payment_methods[enabled]", required = false) Boolean automaticPaymentMethodsEnabled) {
////        PaymentIntent paymentIntent = new PaymentIntent();
////        paymentIntent.setId("pi_" + RandomStringUtils.random(14, true, true));
////        paymentIntent.setAmount(amount);
////        paymentIntent.setCurrency(currency);
////        paymentIntent.setCharges(null); // TODO
////        if (automaticPaymentMethodsEnabled != null) {
////            AutomaticPaymentMethodsPaymentIntent automaticPaymentMethodsPaymentIntent = new AutomaticPaymentMethodsPaymentIntent();
////            automaticPaymentMethodsPaymentIntent.setEnabled(automaticPaymentMethodsEnabled);
////            paymentIntent.setAutomaticPaymentMethods(automaticPaymentMethodsPaymentIntent);
////        }
////        paymentIntent.setClientSecret(paymentIntent.getId() + "_secret_" + RandomStringUtils.random(16, true, true));
////        paymentIntent.setStatus("requires_payment_method");
////        paymentIntentRepository.save(paymentIntent);
////        LOG.info("PaymentIntent with id [{}] has been created.");
////        return paymentIntent;
////    }
////
////    @GetMapping("/{id}")
////    public PaymentIntent retrievePaymentIntent(@PathVariable String id) {
////        return paymentIntentRepository.findById(id).orElseThrow(() -> {
////            String message = "PaymentIntent with id [%s] not found.".formatted(id);
////            return new ResponseStatusException(HttpStatus.NOT_FOUND, message);
////        });
////    }
//

    @PostMapping("/")
    public PaymentIntent createPaymentIntent(@RequestBody CreatePaymentIntentDTO request) throws StripeException {
        PaymentIntent response = paymentIntentService.createPaymentIntent(request);
        return response;
    }


    @GetMapping("/{id}")
    public PaymentIntent getPaymentIntent(@PathVariable("id") String id) throws StripeException {
        PaymentIntent response = paymentIntentService.getPaymentIntent(id);
        return response;
    }

    @PostMapping("/{id}")
    public PaymentIntent updatePaymentIntent(@PathVariable("id") String id, @RequestBody UpdatePaymentIntentDTO updatePaymentIntentDTO) throws StripeException {
        PaymentIntent response = paymentIntentService.updatePaymentIntent(id, updatePaymentIntentDTO);
        return response;
    }


    @PostMapping("/{id}/confirm")
    public PaymentIntent confirmPaymentIntent(@PathVariable("id") String id,@RequestBody PaymentIntentRequestDTO requestDTO) throws StripeException {
        log.info("::: confirm-payment-intent method :::");
        PaymentIntent response = paymentIntentService.confirmPaymentIntent(id, requestDTO);
        return response;
    }

    @PostMapping("/{id}/cancel")
    public PaymentIntent cancelPaymentIntent(@PathVariable("id") String id) throws StripeException {
        log.info("::: cancel-payment-intent method :::");
        PaymentIntent response = paymentIntentService.cancelPaymentIntent(id);
        return response;
    }

    @PostMapping("/{id}/_authenticate")
    public PaymentIntent isAuthorized(@PathVariable("id") String id, @RequestParam(name = "amount") Integer amount) throws StripeException {
        log.info("::: authorize-payment-intent method :::");
        PaymentIntent response = paymentIntentService.isAuthorized(id,amount);
        return response;
    }

    @PostMapping("/{id}/capture")
    public PaymentIntent capturePaymentIntent(@PathVariable("id") String id) throws StripeException {
        PaymentIntent response = paymentIntentService.capturePaymentIntent(id);
        return response;
    }

    @GetMapping("/")
    public PaymentIntentCollection getAllPaymentIntents(@RequestParam("limit")Integer limit) throws StripeException {
        PaymentIntentCollection response = paymentIntentService.getAllPaymentIntents(limit);
        return response;
    }

}
