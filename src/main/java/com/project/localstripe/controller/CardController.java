package com.project.localstripe.controller;


import com.project.localstripe.request.CreateCardDTO;
import com.project.localstripe.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/v1/customers")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/{id}/sources")
    public String createCard(@PathVariable("id") String id, @RequestBody CreateCardDTO createCardDTO){
        log.info(":: Inside create-card method ::");
        String response = cardService.createCard(id, createCardDTO);
        return response;

    }


    @GetMapping("/{id}/sources/{cardId}")
    public String getCard(@PathVariable("id") String id,@PathVariable("cardId") String cardId){
        log.info(":: Inside create-card method ::");
        String response = cardService.getCard(id, cardId);
        return response;
    }


}
