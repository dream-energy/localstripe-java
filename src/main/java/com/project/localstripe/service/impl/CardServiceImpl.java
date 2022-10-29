package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreateCardDTO;
import com.project.localstripe.service.CardService;
import com.stripe.exception.StripeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CardServiceImpl implements CardService {

    @Override
    public String createCard(String id, CreateCardDTO createCardDTO){

        Map<String, Object> params = new HashMap<>();
        if(!(id.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CUSTOMER_ID);
        }
        params.put("id", "card_1LxaFv2eZvKYlo2CHDtF6Isx");
        params.put("object", "card");
        params.put("address_city", "null");
        params.put("address_country", "null");
        params.put("address_line1", "null");
        params.put("address_line1_check", "null");
        params.put("address_line2", "null");
        params.put("address_state", "null");
        params.put("address_zip", "null");
        params.put("address_zip_check", "null");
        params.put("brand", "Visa");
        params.put("country", "US");
        params.put("customer", id);
        params.put("cvc_check", "pass");
        params.put("dynamic_last4", "null");
        params.put("exp_month", 8);
        params.put("exp_year", 2023);
        params.put("fingerprint", "Xt5EWLLDS7FJjR1c");
        params.put("funding", "credit");
        params.put("last4", "4242");
        params.put("metadata", "{}");
        params.put("name", "null");
        params.put("redaction", "null");
        params.put("tokenization_method", "null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;

    }

    @Override
    public String getCard(String id, String cardId){

        Map<String, Object> params = new HashMap<>();
        if(!(id.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CUSTOMER_ID);
        }

        if(!(cardId.contains("card_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CARD_ID);
        }

        params.put("id", cardId);
        params.put("object", "card");
        params.put("address_city", "null");
        params.put("address_country", "null");
        params.put("address_line1", "null");
        params.put("address_line1_check", "null");
        params.put("address_line2", "null");
        params.put("address_state", "null");
        params.put("address_zip", "null");
        params.put("address_zip_check", "null");
        params.put("brand", "Visa");
        params.put("country", "US");
        params.put("customer", id);
        params.put("cvc_check", "pass");
        params.put("dynamic_last4", "null");
        params.put("exp_month", 5);
        params.put("exp_year", 2025);
        params.put("fingerprint", "Xt5EWLLDS7FJjR1c");
        params.put("funding", "credit");
        params.put("last4", "5050");
        params.put("metadata", "{}");
        params.put("name", "null");
        params.put("redaction", "null");
        params.put("tokenization_method", "null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;


    }
}
