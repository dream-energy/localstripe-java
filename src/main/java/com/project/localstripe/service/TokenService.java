package com.project.localstripe.service;

import com.project.localstripe.request.CreateTokenDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;

public interface TokenService {

    public Token createToken(CreateTokenDTO createTokenDTO) throws StripeException;
}
