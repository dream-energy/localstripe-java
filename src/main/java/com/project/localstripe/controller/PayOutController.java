package com.project.localstripe.controller;

import com.project.localstripe.service.PayOutService;
import com.project.localstripe.service.impl.PayOutServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String payout(@PathVariable("id") String id){
        log.info("::: In PayOut Controller");
        String response = payOutService.makePayout(id);
        return response;
    }


}
