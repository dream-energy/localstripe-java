package com.project.localstripe.service;

import com.project.localstripe.request.CreatePaymentIntentDTO;
import com.project.localstripe.request.PaymentIntentRequestDTO;
import com.project.localstripe.request.UpdatePaymentIntentDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;

public interface PaymentIntentService {
    public PaymentIntent confirmPaymentIntent(String id, PaymentIntentRequestDTO requestDTO) throws StripeException;
    public PaymentIntent cancelPaymentIntent(String id) throws StripeException;

    public PaymentIntent createPaymentIntent(CreatePaymentIntentDTO createPaymentIntentDTO) throws StripeException;

    public PaymentIntent getPaymentIntent(String id) throws StripeException;

    public PaymentIntent updatePaymentIntent(String id, UpdatePaymentIntentDTO updatePaymentIntentDTO) throws StripeException;
    public PaymentIntent isAuthorized(String id, Integer amount) throws StripeException;

    public PaymentIntent capturePaymentIntent(String id) throws StripeException;

    public PaymentIntentCollection getAllPaymentIntents(Integer limit) throws StripeException;

}
