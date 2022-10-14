package com.project.localstripe.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Balance;

import java.util.Collection;

public interface BalanceService {
    public Balance getBalance() throws StripeException;
}
