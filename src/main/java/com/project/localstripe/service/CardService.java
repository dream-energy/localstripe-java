package com.project.localstripe.service;

import com.project.localstripe.request.CreateCardDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Source;

public interface CardService {

    public Card createCard(String id, CreateCardDTO createCardDTO) throws StripeException;
    public Card getCard(String id, String cardId) throws StripeException;
}
