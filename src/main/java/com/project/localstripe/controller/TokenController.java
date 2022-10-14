package com.project.localstripe.controller;

import com.project.localstripe.request.CreateTokenDTO;
import com.project.localstripe.service.TokenService;
import com.project.localstripe.service.impl.TokenServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/tokens")
public class TokenController {


    private final TokenServiceImpl tokenServiceImpl;

    public TokenController(TokenServiceImpl tokenService){
        this.tokenServiceImpl = tokenService;
    }

    @Autowired
    TokenService tokenService;

    @PostMapping
    public Token createToken(@RequestBody CreateTokenDTO createTokenDTO) throws StripeException {
        log.info(":: Create-Token method");
        Token response = tokenService.createToken(createTokenDTO);
        return response;
    }
}
