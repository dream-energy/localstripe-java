package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;
import com.project.localstripe.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

import java.util.Map;

@Slf4j
@Service

public class CustomerServiceImpl implements CustomerService {


    @Override
    public String CreateCustomer(CreateCustomerDTO customerRequestDTO){

        Map<String, Object> params = new HashMap<>();
        params.put("id", "cus_9BoKyB2Km2T7TE");
        params.put("object", "customer");
        params.put("address", "null");
        params.put("balance", 0);
        params.put("created", 1473810745);
        params.put("currency", "usd");
        params.put("default_source", "card_18tQhR2eZvKYlo2CuNh554KH");
        params.put("delinquent", false);
        params.put("description", customerRequestDTO.getDescription());
        params.put("discount", "null");
        params.put("email", "null");
        params.put("invoice_prefix", "2ACFF7A");
        Map<String, Object> invoice_settings = new HashMap<>();
        invoice_settings.put("custom_fields","null");
        invoice_settings.put("default_payment_method","null");
        invoice_settings.put("footer","null");
        invoice_settings.put("rendering_options","null");
        params.put("invoice_settings", invoice_settings);
        params.put("livemode", false);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id","6735");
        params.put("metadata", metadata);
        params.put("name", "null");
        params.put("next_invoice_sequence", 4474);
        params.put("phone", "null");
        params.put("preferred_locales", "{}");
        params.put("shipping", "null");
        params.put("tax_exempt", "none");
        params.put("test_clock", "null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String getCustomers(String id){
        if(!(id.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CUSTOMER_ID);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("object", "customer");
        params.put("address", "null");
        params.put("balance", 0);
        params.put("created", 1473810745);
        params.put("currency", "usd");
        params.put("default_source", "card_18tQhR2eZvKYlo2CuNh554KH");
        params.put("delinquent", false);
        params.put("description", "null");
        params.put("discount", "null");
        params.put("email", "null");
        params.put("invoice_prefix", "2ACFF7A");
        Map<String, Object> invoice_settings = new HashMap<>();
        invoice_settings.put("custom_fields","null");
        invoice_settings.put("default_payment_method","null");
        invoice_settings.put("footer","null");
        invoice_settings.put("rendering_options","null");
        params.put("invoice_settings", invoice_settings);
        params.put("livemode", false);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id","6735");
        params.put("metadata", metadata);
        params.put("name", "null");
        params.put("next_invoice_sequence", 4474);
        params.put("phone", "null");
        params.put("preferred_locales", "{}");
        params.put("shipping", "null");
        params.put("tax_exempt", "none");
        params.put("test_clock", "null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;

    }

    @Override
    public String updateCustomer(String id, UpdateCustomerDTO updateCustomerDTO){

        if(!(id.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CUSTOMER_ID);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("object", "customer");
        params.put("address", "null");
        params.put("balance", 0);
        params.put("created", 1473810745);
        params.put("currency", "usd");
        params.put("default_source", "card_18tQhR2eZvKYlo2CuNh554KH");
        params.put("delinquent", false);
        params.put("description", "null");
        params.put("discount", "null");
        params.put("email", "null");
        params.put("invoice_prefix", "2ACFF7A");
        Map<String, Object> invoice_settings = new HashMap<>();
        invoice_settings.put("custom_fields","null");
        invoice_settings.put("default_payment_method","null");
        invoice_settings.put("footer","null");
        invoice_settings.put("rendering_options","null");
        params.put("invoice_settings", invoice_settings);
        params.put("livemode", false);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id",updateCustomerDTO.getOrderId());
        params.put("metadata", metadata);
        params.put("name", "null");
        params.put("next_invoice_sequence", 4474);
        params.put("phone", "null");
        params.put("preferred_locales", "{}");
        params.put("shipping", "null");
        params.put("tax_exempt", "none");
        params.put("test_clock", "null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String deleteCustomer(String id){

        if(!(id.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_CUSTOMER_ID);
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);
        params.put("object", "customer");
        params.put("deleted", true);
        Gson gson = new Gson();
        String json = gson.toJson(params);
        return json;
    }

    @Override
    public String getAllCustomers(){

        String response = """
                {
                  "object": "list",
                  "url": "/v1/customers",
                  "has_more": false,
                  "data": [
                    {
                      "id": "cus_9BoKyB2Km2T7TE",
                      "object": "customer",
                      "address": null,
                      "balance": 0,
                      "created": 1473810745,
                      "currency": "usd",
                      "default_source": "card_18tQhR2eZvKYlo2CuNh554KH",
                      "delinquent": false,
                      "description": null,
                      "discount": null,
                      "email": null,
                      "invoice_prefix": "2ACFF7A",
                      "invoice_settings": {
                        "custom_fields": null,
                        "default_payment_method": null,
                        "footer": null,
                        "rendering_options": null
                      },
                      "livemode": false,
                      "metadata": {
                        "order_id": "6735"
                      },
                      "name": null,
                      "next_invoice_sequence": 4474,
                      "phone": null,
                      "preferred_locales": [],
                      "shipping": null,
                      "tax_exempt": "none",
                      "test_clock": null
                    },
                    {
                      "id": "cus_9BoKyB2Km21tY9",
                      "object": "customer",
                      "address": null,
                      "balance": 200,
                      "created": 147310745,
                      "currency": "usd",
                      "default_source": "card_18tQhR2eZvKYlo2CuNh554KH",
                      "delinquent": false,
                      "description": null,
                      "discount": null,
                      "email": null,
                      "invoice_prefix": "2ACFF7A",
                      "invoice_settings": {
                        "custom_fields": null,
                        "default_payment_method": null,
                        "footer": null,
                        "rendering_options": null
                      },
                      "livemode": false,
                      "metadata": {
                        "order_id": "6800"
                      },
                      "name": null,
                      "next_invoice_sequence": 4474,
                      "phone": null,
                      "preferred_locales": [],
                      "shipping": null,
                      "tax_exempt": "none",
                      "test_clock": null
                    }
                  
                  ]
                }
                """;

        return response;
    }

    @Override
    public String searchCustomers(String query){

        String response = """
                {
                  "object": "search_result",
                  "url": "/v1/customers/search",
                  "has_more": false,
                  "data": [
                    {
                      "id": "cus_9BoKyB2Km2T7TE",
                      "object": "customer",
                      "address": null,
                      "balance": 0,
                      "created": 1473810745,
                      "currency": "usd",
                      "default_source": "card_18tQhR2eZvKYlo2CuNh554KH",
                      "delinquent": false,
                      "description": null,
                      "discount": null,
                      "email": null,
                      "invoice_prefix": "2ACFF7A",
                      "invoice_settings": {
                        "custom_fields": null,
                        "default_payment_method": null,
                        "footer": null,
                        "rendering_options": null
                      },
                      "livemode": false,
                      "metadata": {
                        "foo": "bar"
                      },
                      "name": "fakename",
                      "next_invoice_sequence": 4474,
                      "phone": null,
                      "preferred_locales": [],
                      "shipping": null,
                      "tax_exempt": "none",
                      "test_clock": null
                    },
                    {
                      "id": "cus_8AoKyB2Km2T897",
                      "object": "customer",
                      "address": null,
                      "balance": 0,
                      "created": 1473810745,
                      "currency": "usd",
                      "default_source": "card_18tQhR2eZvKYlo2CuNh554KH",
                      "delinquent": false,
                      "description": null,
                      "discount": null,
                      "email": null,
                      "invoice_prefix": "2ACFF7A",
                      "invoice_settings": {
                        "custom_fields": null,
                        "default_payment_method": null,
                        "footer": null,
                        "rendering_options": null
                      },
                      "livemode": true,
                      "metadata": {
                        "foo": "bar"
                      },
                      "name": "fakename",
                      "next_invoice_sequence": 4474,
                      "phone": null,
                      "preferred_locales": [],
                      "shipping": null,
                      "tax_exempt": "none",
                      "test_clock": null
                    },
                    {
                      "id": "cus_5VoKyB2Km2T7YT",
                      "object": "customer",
                      "address": null,
                      "balance": 0,
                      "created": 1473109746,
                      "currency": "usd",
                      "default_source": "card_18tQhR2eZvKYlo2CuNh554KH",
                      "delinquent": false,
                      "description": null,
                      "discount": null,
                      "email": null,
                      "invoice_prefix": "2ACFF7A",
                      "invoice_settings": {
                        "custom_fields": null,
                        "default_payment_method": null,
                        "footer": null,
                        "rendering_options": null
                      },
                      "livemode": false,
                      "metadata": {
                        "foo": "bar"
                      },
                      "name": "fakename",
                      "next_invoice_sequence": 4474,
                      "phone": null,
                      "preferred_locales": [],
                      "shipping": null,
                      "tax_exempt": "none",
                      "test_clock": null
                    }
                  ]
                }
                """;

        return response;
    }


}
