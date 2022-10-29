package com.project.localstripe.controller;

import com.project.localstripe.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/balance")
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    @GetMapping
    public String balance(){
        log.info(":: Inside Balance Controller ::");
        String response = balanceService.getBalance();
        return response;
    }

}
