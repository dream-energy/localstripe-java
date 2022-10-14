package com.project.localstripe.service;

import com.project.localstripe.request.ChargeRequestDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface ChargeService {
    public Charge charge(ChargeRequestDTO chargeRequestDTO) throws StripeException;
}
