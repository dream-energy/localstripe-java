package com.project.localstripe.service.impl;

import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreatePaymentDTO;
import com.project.localstripe.service.PaymentMethodService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Value("${stripe.api.key}")
    private String API_KEY;

    @Override
    public PaymentMethod paymentMethodAttach(String id, String customerId) throws StripeException {
        Stripe.apiKey = API_KEY;
        if(!(id.contains("pm_")) && !(customerId.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_METHOD);
        }

        PaymentMethod paymentMethod = PaymentMethod.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerId);
        PaymentMethod updatedPaymentMethod = paymentMethod.attach(params);
        return updatedPaymentMethod;
    }

    @Override
    public PaymentMethod paymentMethodDetach(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        if(!(id.contains("pm_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_METHOD);
        }
        PaymentMethod paymentMethod = PaymentMethod.retrieve(id);
        PaymentMethod updatedPaymentMethod = paymentMethod.detach();
        return updatedPaymentMethod;
    }

    @Override
    public PaymentMethod createPaymentMethod(CreatePaymentDTO createPaymentDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> card = new HashMap<>();
        card.put("number", createPaymentDTO.getNumber());
        card.put("exp_month", createPaymentDTO.getExpMonth());
        card.put("exp_year", createPaymentDTO.getExpYear());
        card.put("cvc", createPaymentDTO.getCvc());
        Map<String, Object> params = new HashMap<>();
        params.put("type", createPaymentDTO.getType());
        params.put("card", card);

        PaymentMethod paymentMethod =
                PaymentMethod.create(params);
        return paymentMethod;
    }
}
