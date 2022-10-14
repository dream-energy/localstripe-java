package com.project.localstripe.service.impl;

import com.project.localstripe.repository.AbstractRepository;
import com.project.localstripe.service.BalanceService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class BalanceServiceImpl implements BalanceService {

    @Value("${stripe.api.key}")
    private String API_KEY;

    @Override
    public Balance getBalance() throws StripeException {
        Stripe.apiKey = API_KEY;
        log.info(":: Inside getBalance() ::");
        return Balance.retrieve();
    }
}
