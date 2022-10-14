package com.project.localstripe.service;

import com.project.localstripe.request.WebHookRequestDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.WebhookEndpoint;

public interface WebHookService {
    public WebhookEndpoint createWebHook(WebHookRequestDTO requestDTO) throws StripeException;
    public WebhookEndpoint getWebHook(String id) throws StripeException;

    public WebhookEndpoint updateWebHook(String id, WebHookRequestDTO requestDTO) throws StripeException;



}
