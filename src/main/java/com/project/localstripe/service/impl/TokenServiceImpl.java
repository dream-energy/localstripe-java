package com.project.localstripe.service.impl;

import com.project.localstripe.request.CreateTokenDTO;
import com.project.localstripe.service.TokenService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Value("${stripe.api.key}")
    private String API_KEY;

    @Override
    public Token createToken(CreateTokenDTO createTokenDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> card = new HashMap<>();
        card.put("number", createTokenDTO.getNumber());
        card.put("exp_month", createTokenDTO.getExpiryMonth());
        card.put("exp_year", createTokenDTO.getExpiryYear());
        card.put("cvc", createTokenDTO.getCvc());
        Map<String, Object> params = new HashMap<>();
        params.put("card", card);
        Token token = Token.create(params);
        return token;
    }
}
