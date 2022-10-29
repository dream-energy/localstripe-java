package com.project.localstripe.service;

import com.project.localstripe.request.WebHookRequestDTO;

public interface WebHookService {
    public String createWebHook(WebHookRequestDTO requestDTO);
    public String getWebHook(String id);

    public String updateWebHook(String id, WebHookRequestDTO requestDTO);



}
