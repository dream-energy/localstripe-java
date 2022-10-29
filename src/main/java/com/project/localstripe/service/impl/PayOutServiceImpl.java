package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.common.Constants;
import com.project.localstripe.service.PayOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class PayOutServiceImpl implements PayOutService {

    @Override
    public String makePayout(String id){

        if(!(id.contains("po_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYOUT_ID);
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);
        params.put("obejct", "payout");
        params.put("amount", 1100);
        params.put("arrival_date", 1666915200);
        params.put("automatic", false);
        params.put("balance_transaction", "txn_1032HU2eZvKYlo2CEPtcnUvl");
        params.put("created", 1666970392);
        params.put("currency", "usd");
        params.put("description", "STRIPE PAYOUT");
        params.put("destination", "ba_1LxuLc2eZvKYlo2Ck82EYsPu");
        params.put("failure_balance_transaction", "null");
        params.put("failure_code", "null");
        params.put("failure_message", "null");
        params.put("livemode", false);
        params.put("metadata", "{}");
        params.put("method", "standard");
        params.put("original_payout", "null");
        params.put("reversed_by", "null");
        params.put("source_type", "card");
        params.put("statement_descriptor", "null");
        params.put("status", "canceled");
        params.put("type", "bank_account");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }
}
