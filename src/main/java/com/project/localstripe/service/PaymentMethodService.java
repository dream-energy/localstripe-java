package com.project.localstripe.service;

import com.project.localstripe.request.CreatePaymentDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;

public interface PaymentMethodService {

    public PaymentMethod paymentMethodAttach(String id, String customerId) throws StripeException;

    public PaymentMethod paymentMethodDetach(String id) throws StripeException;

    public PaymentMethod createPaymentMethod(CreatePaymentDTO createPaymentDTO) throws StripeException;

}
