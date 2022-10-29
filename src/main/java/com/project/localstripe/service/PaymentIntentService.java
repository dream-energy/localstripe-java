package com.project.localstripe.service;

import com.project.localstripe.request.CreatePaymentIntentDTO;
import com.project.localstripe.request.PaymentIntentRequestDTO;
import com.project.localstripe.request.UpdatePaymentIntentDTO;

public interface PaymentIntentService {
    public String confirmPaymentIntent(String id, PaymentIntentRequestDTO requestDTO);
    public String cancelPaymentIntent(String id);

    public String createPaymentIntent(CreatePaymentIntentDTO createPaymentIntentDTO);

    public String getPaymentIntent(String id);

    public String updatePaymentIntent(String id, UpdatePaymentIntentDTO updatePaymentIntentDTO);
    public String isAuthorized(String id, Integer amount);

    public String capturePaymentIntent(String id);

    public String getAllPaymentIntents();

}
