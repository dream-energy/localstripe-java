package com.project.localstripe.controller;

import com.project.localstripe.request.WebHookRequestDTO;
import com.project.localstripe.service.WebHookService;
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
    public String createWebHook(@RequestBody WebHookRequestDTO requestDTO){
        log.info(":: create-webhook Method ::");
        String response = webHookService.createWebHook(requestDTO);
        return response;
    }

    @GetMapping("/{id}")
    public String getWebHook(@PathVariable("id") String id){
        log.info(":: get-webhook Method ::");
        String response = webHookService.getWebHook(id);
        return response;
    }

    @PostMapping("/{id}")
    public String updateWebHook(@PathVariable("id") String id,@RequestBody WebHookRequestDTO requestDTO){
        log.info(":: update-webhook Method ::");
        String response = webHookService.updateWebHook(id, requestDTO);
        return response;
    }

}
