package com.project.localstripe.controller;


import com.project.localstripe.request.WebHookRequestDTO;
import com.project.localstripe.service.WebHookService;
import com.stripe.exception.StripeException;
import com.stripe.model.WebhookEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/webhook_endpoints")
public class WebHookController {
    @Autowired
    WebHookService webHookService;

    @PostMapping
    public WebhookEndpoint createWebHook(@RequestBody WebHookRequestDTO requestDTO) throws StripeException {
        log.info(":: create-webhook Method ::");
        WebhookEndpoint response = webHookService.createWebHook(requestDTO);
        return response;
    }

    @GetMapping("/{id}")
    public WebhookEndpoint getWebHook(@PathVariable("id") String id) throws StripeException {
        log.info(":: get-webhook Method ::");
        WebhookEndpoint response = webHookService.getWebHook(id);
        return response;
    }

    @PostMapping("/{id}")
    public WebhookEndpoint updateWebHook(@PathVariable("id") String id,@RequestBody WebHookRequestDTO requestDTO) throws StripeException {
        log.info(":: update-webhook Method ::");
        WebhookEndpoint response = webHookService.updateWebHook(id, requestDTO);
        return response;
    }

}
