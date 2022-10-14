package com.project.localstripe.service.impl;

import com.project.localstripe.service.PayOutService;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Payout;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PayOutServiceImpl implements PayOutService {

    @Value("${stripe.api.key}")
    private String API_KEY;
    @Override
    public Payout makePayout(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        Payout payout = Payout.retrieve(id);
        Payout updatedPayout = payout.cancel();
        return updatedPayout;
    }
}
