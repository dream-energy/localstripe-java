package com.project.localstripe.service.impl;

import com.project.localstripe.request.ChargeRequestDTO;
import com.project.localstripe.service.ChargeService;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ChargeServiceImpl implements ChargeService {

    @Value("${stripe.api.key}")
    private String API_KEY;
    @Override
    public Charge charge(ChargeRequestDTO chargeRequestDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount",chargeRequestDTO.getAmount());
        chargeParams.put("currency",chargeRequestDTO.getCurrency());
        chargeParams.put("description",chargeRequestDTO.getDescription());
        chargeParams.put("source",chargeRequestDTO.getSource());

        return Charge.create(chargeParams);


    }
}
