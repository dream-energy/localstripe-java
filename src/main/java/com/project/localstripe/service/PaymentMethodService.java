package com.project.localstripe.service;

import com.project.localstripe.request.CreatePaymentDTO;

public interface PaymentMethodService {

    public String paymentMethodAttach(String id, String customerId);

    public String paymentMethodDetach(String id);

    public String createPaymentMethod(CreatePaymentDTO createPaymentDTO);

}
