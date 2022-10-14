package com.project.localstripe.controller;

import com.project.localstripe.service.BalanceService;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/balance")
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    @GetMapping
    public Balance balance() throws StripeException {
        log.info(":: Inside Balance Controller ::");
        return Balance.retrieve();
    }

}
