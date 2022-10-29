package com.project.localstripe.service;

import com.project.localstripe.request.CreateCardDTO;


public interface CardService {

    public String createCard(String id, CreateCardDTO createCardDTO);
    public String getCard(String id, String cardId);
}
