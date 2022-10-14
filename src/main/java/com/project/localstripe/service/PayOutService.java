package com.project.localstripe.service;

import com.project.localstripe.request.PayOutRequestDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Payout;
import org.springframework.ui.Model;

public interface PayOutService {
    public Payout makePayout(String id) throws StripeException;
}
