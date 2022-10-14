package com.project.localstripe.service.impl;

import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreatePaymentIntentDTO;
import com.project.localstripe.request.PaymentIntentRequestDTO;
import com.project.localstripe.request.UpdatePaymentIntentDTO;
import com.project.localstripe.service.PaymentIntentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PaymentIntentServiceImpl implements PaymentIntentService {

    @Value("${stripe.api.key}")
    private String API_KEY;

    @Override
    public PaymentIntent confirmPaymentIntent(String id, PaymentIntentRequestDTO requestDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_INTENT_METHOD);
        }

        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", requestDTO.getPaymentMethod());
        PaymentIntent updatedPaymentIntent = paymentIntent.confirm(params);
        return updatedPaymentIntent;
    }

    @Override
    public PaymentIntent cancelPaymentIntent(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_INTENT_METHOD);
        }

        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        PaymentIntent updatedPaymentIntent = paymentIntent.cancel();
        return updatedPaymentIntent;
    }

    @Override
    public PaymentIntent createPaymentIntent(CreatePaymentIntentDTO createPaymentIntentDTO) throws StripeException {
        Stripe.apiKey = API_KEY;

        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add(createPaymentIntentDTO.getPaymentMethodType());
        Map<String, Object> params = new HashMap<>();
        params.put("amount", createPaymentIntentDTO.getAmount());
        params.put("currency", createPaymentIntentDTO.getCurrency());
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );

        PaymentIntent paymentIntent =
                PaymentIntent.create(params);
        return paymentIntent;
    }

    @Override
    public PaymentIntent getPaymentIntent(String id) throws StripeException {
        Stripe.apiKey = API_KEY;

        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(
                        id
                );

        return paymentIntent;
    }

    @Override
    public PaymentIntent updatePaymentIntent(String id, UpdatePaymentIntentDTO updatePaymentIntentDTO) throws StripeException {

        Stripe.apiKey = API_KEY;

        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(
                        id
                );

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", updatePaymentIntentDTO.getOrderId());
        Map<String, Object> params = new HashMap<>();
        params.put("metadata", metadata);

        PaymentIntent updatedPaymentIntent =
                paymentIntent.update(params);
        return updatedPaymentIntent;
    }


    @Override
    public PaymentIntent isAuthorized(String id, Integer amount) throws StripeException {
        Stripe.apiKey = API_KEY;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        PaymentIntent updatedPaymentIntent = paymentIntent.incrementAuthorization(params);
        return updatedPaymentIntent;
    }

    @Override
    public PaymentIntent capturePaymentIntent(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(
                        id
                );

        PaymentIntent updatedPaymentIntent =
                paymentIntent.capture();
        return  updatedPaymentIntent;
    }

    @Override
    public PaymentIntentCollection getAllPaymentIntents(Integer limit) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> params = new HashMap<>();
        params.put("limit", limit);

        PaymentIntentCollection paymentIntents =
                PaymentIntent.list(params);
        return paymentIntents;
    }


}
