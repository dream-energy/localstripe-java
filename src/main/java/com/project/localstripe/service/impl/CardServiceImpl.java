package com.project.localstripe.service.impl;

import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreateCardDTO;
import com.project.localstripe.service.CardService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.Source;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CardServiceImpl implements CardService {

    @Value("${stripe.api.key}")
    private String API_KEY;
    @Override
    public Card createCard(String id, CreateCardDTO createCardDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> retrieveParams =
                new HashMap<>();
        List<String> expandList = new ArrayList<>();
        expandList.add(Constants.SOURCES);
        retrieveParams.put("expand", expandList);
        Customer customer =
                Customer.retrieve(
                        id,
                        retrieveParams,
                        null
                );

        Map<String, Object> params = new HashMap<>();
        params.put("source", createCardDTO.getSource());

        Card card =
                (Card) customer.getSources().create(params);
        return card;
    }

    @Override
    public Card getCard(String id, String cardId) throws StripeException {
        Stripe.apiKey = API_KEY;

        Map<String, Object> retrieveParams =
                new HashMap<>();
        List<String> expandList = new ArrayList<>();
        expandList.add(Constants.SOURCES);
        retrieveParams.put("expand", expandList);
        Customer customer =
                Customer.retrieve(
                        id,
                        retrieveParams,
                        null
                );

        Card card =
                (Card) customer.getSources().retrieve(
                        cardId
                );

        return card;
    }
}
