package com.project.localstripe.Modules;

import com.project.localstripe.controller.TokenController;
import com.project.localstripe.request.CreateTokenDTO;
import com.project.localstripe.service.impl.TokenServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TokenTestController {

    @Mock
    private TokenServiceImpl tokenService;

    @InjectMocks
    private TokenController tokenController;

    private static final CreateTokenDTO TOKEN_REQUEST = new CreateTokenDTO("1",2,2021,"715");

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        tokenController = new TokenController(tokenService);
    }


    @Test
    public void successScenario(){
        String token = tokenController.createToken(TOKEN_REQUEST);
        System.out.println("success"+token);
    }


    @Test
    public void scenarioWithNullNumber(){
        TOKEN_REQUEST.setNumber(null);
        TOKEN_REQUEST.setExpiryMonth(5);
        TOKEN_REQUEST.setExpiryYear(2011);
        TOKEN_REQUEST.setCvc("123");
        String token  = tokenController.createToken(TOKEN_REQUEST);
        System.out.println("Scenario with number Null"+token);
    }

    @Test
    public void scenarioWithNullCvc(){
        TOKEN_REQUEST.setNumber(null);
        TOKEN_REQUEST.setExpiryMonth(5);
        TOKEN_REQUEST.setExpiryYear(2011);
        TOKEN_REQUEST.setCvc("123");
        String token  = tokenController.createToken(TOKEN_REQUEST);
        System.out.println("Scenario with cvc Null"+token);
    }



}
