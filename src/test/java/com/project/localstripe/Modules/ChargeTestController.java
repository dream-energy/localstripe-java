package com.project.localstripe.Modules;

import com.project.localstripe.controller.ChargeController;
import com.project.localstripe.controller.CustomerController;
import com.project.localstripe.request.ChargeRequestDTO;
import com.project.localstripe.request.CustomerRequestDTO;
import com.project.localstripe.service.impl.ChargeServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
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

    private static final ChargeRequestDTO CHARGE_REQUEST = new ChargeRequestDTO("abc",2200,"PKR","abc@gmail.com","djs");


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        chargeController = new ChargeController(chargeService);
    }


    @Test
    public void successScenario() throws StripeException {
        Charge charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("success"+charge);
    }


    @Test
    public void scenarioWithNullDescription() throws StripeException {
        CHARGE_REQUEST.setDescription(null);
        CHARGE_REQUEST.setAmount(2300);
        CHARGE_REQUEST.setCurrency("USD");
        CHARGE_REQUEST.setStripeEmail("def@gmail.com");
        CHARGE_REQUEST.setSource("tok_visa");
        Charge charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("Scenario with Description Null"+charge);
    }

    @Test
    public void scenarioWithNullStripeEmail() throws StripeException {
        CHARGE_REQUEST.setDescription("Hello World");
        CHARGE_REQUEST.setAmount(2300);
        CHARGE_REQUEST.setCurrency("USD");
        CHARGE_REQUEST.setStripeEmail("def@gmail.com");
        CHARGE_REQUEST.setSource("tok_visa");
        Charge charge = chargeController.charge(CHARGE_REQUEST);
        System.out.println("success with Description Null"+charge);
    }
}
