package com.project.localstripe.Modules;

import com.project.localstripe.controller.PayOutController;
import com.project.localstripe.service.impl.PayOutServiceImpl;
import com.stripe.exception.StripeException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PayOutTestController {

    @Mock
    private PayOutServiceImpl payOutService;

    @InjectMocks
    private PayOutController payOutController;

    private static final String ID = "po_1LsXKK2eZvKYlo2CLLB9arOW";


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        payOutController = new PayOutController(payOutService);
    }


    @Test
    public void successScenario(){
        String payout= payOutController.payout(ID);
        System.out.println("success"+payout);
    }


    @Test
    public void ScenarioWithNullId(){

        String payout = payOutController.payout(ID);
        System.out.println("success with ID Null"+payout);
    }


}
