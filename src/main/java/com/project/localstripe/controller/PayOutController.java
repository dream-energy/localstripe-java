package com.project.localstripe.controller;

import com.project.localstripe.api.response.ApiResponse;
import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CustomerRequestDTO;
import com.project.localstripe.request.PayOutRequestDTO;
import com.project.localstripe.service.PayOutService;
import com.project.localstripe.service.impl.PayOutServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.Payout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/payouts")
public class PayOutController {


    private final PayOutServiceImpl payOutServiceImpl;


    public PayOutController(PayOutServiceImpl payOutServiceImpl){
        this.payOutServiceImpl = payOutServiceImpl;
    }

    @Autowired
    PayOutService payOutService;

    @PostMapping("/{id}/cancel")
    public Payout payout(@PathVariable("id") String id) throws StripeException {
        log.info("::: In PayOut Controller");
        Payout response = payOutService.makePayout(id);
        return response;
    }


}
