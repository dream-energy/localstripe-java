package com.project.localstripe.controller;

import com.project.localstripe.request.CreatePaymentDTO;
import com.project.localstripe.service.PaymentMethodService;
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
    public String createPaymentMethod(@RequestBody CreatePaymentDTO createPaymentDTO){
        String response = paymentMethodService.createPaymentMethod(createPaymentDTO);
        return response;
    }


    @PostMapping("/{id}/attach")
    public String paymentMethodAttach(@PathVariable("id") String id, @RequestParam("customerId") String customerId){
        log.info(":: Payment-Method-Attach method ::");
        String response = paymentMethodService.paymentMethodAttach(id, customerId);
        return response;
    }


    @PostMapping("/{id}/detach")
    public String paymentMethodDetach(@PathVariable("id") String id){
        log.info(":: Payment-Method-Attach method ::");
        String response = paymentMethodService.paymentMethodDetach(id);
        return response;
    }

}
