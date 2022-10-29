package com.project.localstripe.Modules;

import com.project.localstripe.controller.ChargeController;
import com.project.localstripe.request.ChargeRequestDTO;
import com.project.localstripe.service.impl.ChargeServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ChargeTestController {

    @Mock
    private ChargeServiceImpl chargeService;

    @InjectMocks
    private ChargeController chargeController;

    private static final ChargeRequestDTO CHARGE_REQUEST = new ChargeRequestDTO("abc",2200,"PKR","djs");


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        chargeController = new ChargeController(chargeService);
    }


    @Test
    public void successScenario(){
        String charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("success"+charge);
    }


    @Test
    public void scenarioWithNullDescription(){
        CHARGE_REQUEST.setDescription(null);
        CHARGE_REQUEST.setAmount(2300);
        CHARGE_REQUEST.setCurrency("USD");
        CHARGE_REQUEST.setSource("tok_visa");
        String charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("Scenario with Description Null"+charge);
    }

    @Test
    public void scenarioWithNullSource(){
        CHARGE_REQUEST.setDescription("Hello World");
        CHARGE_REQUEST.setAmount(2300);
        CHARGE_REQUEST.setCurrency("USD");
        CHARGE_REQUEST.setSource(null);
        String charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("success with Description Null"+charge);
    }
}
