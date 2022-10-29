package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.request.CreateTokenDTO;
import com.project.localstripe.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String createToken(CreateTokenDTO createTokenDTO){

        Map<String, Object> params = new HashMap<>();

        params.put("id","tok_1LxvAq2eZvKYlo2CqMuC9BjC");
        params.put("object","token");
        Map<String, Object> card = new HashMap<>();
        card.put("id", "card_1LxvAq2eZvKYlo2CibeADLm9");
        card.put("object", "card");
        card.put("address_city", "null");
        card.put("address_country", "null");
        card.put("address_line1", "null");
        card.put("address_line1_check", "null");
        card.put("address_line2", "null");
        card.put("address_state", "null");
        card.put("address_zip", "null");
        card.put("address_zip_check", "null");
        card.put("brand", "Visa");
        card.put("country", "US");
        card.put("cvc_check", "pass");
        card.put("dynamic_last4", "null");
        card.put("exp_month", createTokenDTO.getExpiryMonth());
        card.put("exp_year", createTokenDTO.getExpiryYear());
        card.put("fingerprint", "Xt5EWLLDS7FJjR1c");
        card.put("funding", "credit");
        card.put("last4", "4242");
        card.put("metadata", "{}");
        card.put("name", "null");
        card.put("redaction", "null");
        card.put("tokenization_method", "null");
        params.put("card", card);
        params.put("client_ip","null");
        params.put("created",1666973568);
        params.put("livemode",false);
        params.put("redaction","null");
        params.put("type","card");
        params.put("used","null");


        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }
}
