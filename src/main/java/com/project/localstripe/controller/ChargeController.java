package com.project.localstripe.controller;

import com.project.localstripe.request.ChargeRequestDTO;
import com.project.localstripe.service.ChargeService;
import com.project.localstripe.service.impl.ChargeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/charge")
public class ChargeController {

    private final ChargeServiceImpl chargeServiceImpl;

    public ChargeController(ChargeServiceImpl chargeServiceImpl){
        this.chargeServiceImpl = chargeServiceImpl;
    }

    @Autowired
    ChargeService chargeService;

    @PostMapping("/")
    public String charge(@RequestBody ChargeRequestDTO chargeRequestDTO){
        String response = chargeService.charge(chargeRequestDTO);
        return response;
    }
}
