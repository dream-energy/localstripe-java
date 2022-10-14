package com.project.localstripe.controller;


import com.project.localstripe.request.CreateCardDTO;
import com.project.localstripe.service.CardService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/v1/customers")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/{id}/sources")
    public Card createCard(@PathVariable("id") String id, @RequestBody CreateCardDTO createCardDTO) throws StripeException {
        log.info(":: Inside create-card method ::");
        Card response = cardService.createCard(id, createCardDTO);
        return response;

    }


    @GetMapping("/{id}/sources/{cardId}")
    public Card getCard(@PathVariable("id") String id,@PathVariable("cardId") String cardId) throws StripeException {
        log.info(":: Inside create-card method ::");
        Card response = cardService.getCard(id, cardId);
        return response;
    }


}
