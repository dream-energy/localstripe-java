package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.common.Constants;
import com.project.localstripe.request.WebHookRequestDTO;
import com.project.localstripe.service.WebHookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WebHookServiceImpl implements WebHookService {

    @Override
    public String createWebHook(WebHookRequestDTO requestDTO){
        Map<String, Object> params = new HashMap<>();
        List<Object> enabledEvents = new ArrayList<>();
        params.put("id", "we_1Lxvyc2eZvKYlo2C3Qukbfex");
        params.put("object", "webhook_endpoint");
        params.put("api_version", "null");
        params.put("application", "null");
        params.put("created", 1666976654);
        params.put("description", "This is my webhook, I like it a lot");
        enabledEvents.add(Constants.CHARGE_FAILED);
        enabledEvents.add(Constants.CHARGE_SUCCEED);
        params.put("enabled_events", enabledEvents);
        params.put("livemode", false);
        params.put("metadata", "{}");
        params.put("status", "enabled");
        params.put("url", requestDTO.getUrl());
        params.put("secret", "whsec_zEX2yLdp76lneaJIxAhD4qeYcIQ6XbUL");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String getWebHook(String id){

        if(!(id.contains("we_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_WEBHOOK_ID);
        }


        Map<String, Object> params = new HashMap<>();
        List<Object> enabledEvents = new ArrayList<>();
        params.put("id", id);
        params.put("object", "webhook_endpoint");
        params.put("api_version", "null");
        params.put("application", "null");
        params.put("created", 1666976654);
        params.put("description", "This is my webhook, I like it a lot");
        enabledEvents.add(Constants.CHARGE_FAILED);
        enabledEvents.add(Constants.CHARGE_SUCCEED);
        params.put("enabled_events", enabledEvents);
        params.put("livemode", false);
        params.put("metadata", "{}");
        params.put("status", "enabled");
        params.put("url", "https://example.com/my/webhook/endpoint");

        Gson gson = new Gson();
        String json = gson.toJson(params);
        return json;
    }

    @Override
    public String updateWebHook(String id, WebHookRequestDTO requestDTO){
        if(!(id.contains("we_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_WEBHOOK_ID);
        }
        Map<String, Object> params = new HashMap<>();
        List<Object> enabledEvents = new ArrayList<>();
        params.put("id", id);
        params.put("object", "webhook_endpoint");
        params.put("api_version", "null");
        params.put("application", "null");
        params.put("created", 1666976654);
        params.put("description", "This is my webhook, I like it a lot");
        enabledEvents.add(Constants.CHARGE_FAILED);
        enabledEvents.add(Constants.CHARGE_SUCCEED);
        params.put("enabled_events", enabledEvents);
        params.put("livemode", false);
        params.put("metadata", "{}");
        params.put("status", "enabled");
        params.put("url", requestDTO.getUrl());

        Gson gson = new Gson();
        String json = gson.toJson(params);
        return json;
    }
}
