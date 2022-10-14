package com.project.localstripe.service.impl;

import com.project.localstripe.common.Constants;
import com.project.localstripe.request.WebHookRequestDTO;
import com.project.localstripe.service.WebHookService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.WebhookEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WebHookServiceImpl implements WebHookService {

    @Value("${stripe.api.key}")
    private String API_KEY;
    @Override
    public WebhookEndpoint createWebHook(WebHookRequestDTO requestDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        List<Object> enabledEvents = new ArrayList<>();
        enabledEvents.add(Constants.CHARGE_FAILED);
        enabledEvents.add(Constants.CHARGE_SUCCEED);
        Map<String, Object> params = new HashMap<>();
        params.put("url", requestDTO.getUrl());
        params.put("enabled_events", enabledEvents);
        WebhookEndpoint webhookEndpoint = WebhookEndpoint.create(params);
        return webhookEndpoint;
    }

    @Override
    public WebhookEndpoint getWebHook(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        WebhookEndpoint webhookEndpoint = WebhookEndpoint.retrieve(id);
        return webhookEndpoint;
    }

    @Override
    public WebhookEndpoint updateWebHook(String id, WebHookRequestDTO requestDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        WebhookEndpoint webhookEndpoint = WebhookEndpoint.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("url", requestDTO.getUrl());
        WebhookEndpoint updatedWebhookEndpoint = webhookEndpoint.update(params);
        return updatedWebhookEndpoint;
    }
}
