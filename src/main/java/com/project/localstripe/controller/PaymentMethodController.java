package com.project.localstripe.controller;

import com.project.localstripe.request.CreatePaymentDTO;
import com.project.localstripe.service.PaymentMethodService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/payment_methods")
public class PaymentMethodController {
    @Autowired
    PaymentMethodService paymentMethodService;

    @PostMapping("/")
    public PaymentMethod createPaymentMethod(@RequestBody CreatePaymentDTO createPaymentDTO) throws StripeException {
        PaymentMethod response = paymentMethodService.createPaymentMethod(createPaymentDTO);
        return response;
    }


    @PostMapping("/{id}/attach")
    public PaymentMethod paymentMethodAttach(@PathVariable("id") String id, @RequestParam("customerId") String customerId) throws StripeException {
        log.info(":: Payment-Method-Attach method ::");
        PaymentMethod response = paymentMethodService.paymentMethodAttach(id, customerId);
        return response;
    }


    @PostMapping("/{id}/detach")
    public PaymentMethod paymentMethodDetach(@PathVariable("id") String id) throws StripeException {
        log.info(":: Payment-Method-Attach method ::");
        PaymentMethod response = paymentMethodService.paymentMethodDetach(id);
        return response;
    }

}
