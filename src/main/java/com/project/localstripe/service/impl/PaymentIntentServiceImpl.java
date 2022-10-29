package com.project.localstripe.service.impl;

import com.google.gson.Gson;
import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreatePaymentIntentDTO;
import com.project.localstripe.request.PaymentIntentRequestDTO;
import com.project.localstripe.request.UpdatePaymentIntentDTO;
import com.project.localstripe.service.PaymentIntentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PaymentIntentServiceImpl implements PaymentIntentService {

    @Override
    public String confirmPaymentIntent(String id, PaymentIntentRequestDTO requestDTO){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        String response = """
                {
                  "id": "%s",
                  "object": "payment_intent",
                  "amount": 1000,
                  "amount_capturable": 0,
                  "amount_details": {
                    "tip": {}
                  },
                  "amount_received": 1000,
                  "application": null,
                  "application_fee_amount": null,
                  "automatic_payment_methods": null,
                  "canceled_at": null,
                  "cancellation_reason": null,
                  "capture_method": "automatic",
                  "charges": {
                    "object": "list",
                    "data": [
                      {
                        "id": "ch_1EXUPv2eZvKYlo2CStIqOmbY",
                        "object": "charge",
                        "amount": 1000,
                        "amount_captured": 1000,
                        "amount_refunded": 0,
                        "application": null,
                        "application_fee": null,
                        "application_fee_amount": null,
                        "balance_transaction": "txn_1EXUPv2eZvKYlo2CNUI18wV8",
                        "billing_details": {
                          "address": {
                            "city": null,
                            "country": null,
                            "line1": null,
                            "line2": null,
                            "postal_code": null,
                            "state": null
                          },
                          "email": null,
                          "name": null,
                          "phone": null
                        },
                        "calculated_statement_descriptor": "Stripe",
                        "captured": true,
                        "created": 1557239835,
                        "currency": "usd",
                        "customer": null,
                        "description": "One blue fish",
                        "disputed": false,
                        "failure_balance_transaction": null,
                        "failure_code": null,
                        "failure_message": null,
                        "fraud_details": {},
                        "invoice": null,
                        "livemode": false,
                        "metadata": {},
                        "on_behalf_of": null,
                        "outcome": {
                          "network_status": "approved_by_network",
                          "reason": null,
                          "risk_level": "normal",
                          "risk_score": 9,
                          "seller_message": "Payment complete.",
                          "type": "authorized"
                        },
                        "paid": true,
                        "payment_intent": "pi_1DseIh2eZvKYlo2CwahhN9YI",
                        "payment_method": "pm_1EXUPv2eZvKYlo2CUkqZASBe",
                        "payment_method_details": {
                          "card": {
                            "brand": "visa",
                            "checks": {
                              "address_line1_check": null,
                              "address_postal_code_check": null,
                              "cvc_check": null
                            },
                            "country": "US",
                            "exp_month": 5,
                            "exp_year": 2020,
                            "fingerprint": "Xt5EWLLDS7FJjR1c",
                            "funding": "credit",
                            "installments": null,
                            "last4": "4242",
                            "mandate": null,
                            "moto": null,
                            "network": "visa",
                            "three_d_secure": null,
                            "wallet": null
                          },
                          "type": "card"
                        },
                        "receipt_email": null,
                        "receipt_number": "1230-7299",
                        "receipt_url": "https://pay.stripe.com/receipts/payment/CAcaFwoVYWNjdF8xMDMyRDgyZVp2S1lsbzJDKJqv8JoGMgYk4S4od0A6LBYAKc5iM0cXGsBIgOK02tLvSM3J3dE8kko3yUxwXNG8TTKzw6cKea2SOZYv",
                        "redaction": null,
                        "refunded": false,
                        "refunds": {
                          "object": "list",
                          "data": [],
                          "has_more": false,
                          "url": "/v1/charges/ch_1EXUPv2eZvKYlo2CStIqOmbY/refunds"
                        },
                        "review": null,
                        "shipping": null,
                        "source_transfer": null,
                        "statement_descriptor": null,
                        "statement_descriptor_suffix": null,
                        "status": "succeeded",
                        "transfer_data": null,
                        "transfer_group": null
                      }
                    ],
                    "has_more": false,
                    "url": "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI"
                  },
                  "client_secret": "pi_1DseIh2eZvKYlo2CwahhN9YI_secret_9J35eTzWlxVmfbbQhmkNbewuL",
                  "confirmation_method": "automatic",
                  "created": 1524505326,
                  "currency": "usd",
                  "customer": null,
                  "description": "One blue fish",
                  "invoice": null,
                  "last_payment_error": null,
                  "livemode": false,
                  "metadata": {},
                  "next_action": null,
                  "on_behalf_of": null,
                  "payment_method": "pm_1EXUPv2eZvKYlo2CUkqZASBe",
                  "payment_method_options": {},
                  "payment_method_types": [
                    "card"
                  ],
                  "processing": null,
                  "receipt_email": null,
                  "redaction": null,
                  "review": null,
                  "setup_future_usage": null,
                  "shipping": null,
                  "statement_descriptor": null,
                  "statement_descriptor_suffix": null,
                  "status": "succeeded",
                  "transfer_data": null,
                  "transfer_group": null
                }
                """.formatted(id);

        return response;
    }

    @Override
    public String cancelPaymentIntent(String id){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);
        params.put("object", "payment_intent");
        params.put("amount", 1099);
        params.put("amount_capturable", 0);

        Map<String, Object> amountDetails = new HashMap<>();
        amountDetails.put("tip","{}");
        params.put("amount_details",amountDetails);

        params.put("amount_received", 0);
        params.put("application", "null");
        params.put("application_fee_amount", "null");
        params.put("automatic_payment_methods", "null");
        params.put("canceled_at", "null");
        params.put("cancellation_reason", "null");
        params.put("capture_method", "automatic");

        Map<String, Object> charges = new HashMap<>();
        charges.put("object", "list");
        charges.put("data", "[]");
        charges.put("has_more", "false");
        charges.put("url", "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI");
        params.put("charges", charges);

        params.put("client_secret","pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF");
        params.put("confirmation_method","automatic");
        params.put("created",1547506379);
        params.put("currency","eur");
        params.put("customer","null");
        params.put("description","null");
        params.put("invoice","null");
        params.put("last_payment_error","null");
        params.put("livemode",false);
        params.put("metadata","{}");
        params.put("next_action","null");
        params.put("on_behalf_of","null");
        params.put("payment_method","null");
        params.put("payment_method_options","{}");

        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        params.put("processing","null");
        params.put("receipt_email","null");
        params.put("redaction","null");
        params.put("review","null");
        params.put("setup_future_usage","null");
        params.put("shipping","null");
        params.put("statement_descriptor","null");
        params.put("statement_descriptor_suffix","null");
        params.put("status","cancelled");
        params.put("transfer_data","null");
        params.put("transfer_group","null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String createPaymentIntent(CreatePaymentIntentDTO createPaymentIntentDTO){

        Map<String, Object> params = new HashMap<>();

        params.put("id", "pi_1DseIh2eZvKYlo2CwahhN9YI");
        params.put("object", "payment_intent");
        params.put("amount", createPaymentIntentDTO.getAmount());
        params.put("amount_capturable", 0);

        Map<String, Object> amountDetails = new HashMap<>();
        amountDetails.put("tip","{}");
        params.put("amount_details",amountDetails);

        params.put("amount_received", 0);
        params.put("application", "null");
        params.put("application_fee_amount", "null");
        params.put("automatic_payment_methods", "null");
        params.put("canceled_at", "null");
        params.put("cancellation_reason", "null");
        params.put("capture_method", "automatic");

        Map<String, Object> charges = new HashMap<>();
        charges.put("object", "list");
        charges.put("data", "[]");
        charges.put("has_more", "false");
        charges.put("url", "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI");
        params.put("charges", charges);

        params.put("client_secret","pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF");
        params.put("confirmation_method","automatic");
        params.put("created",1547506379);
        params.put("currency",createPaymentIntentDTO.getCurrency());
        params.put("customer","null");
        params.put("description","null");
        params.put("invoice","null");
        params.put("last_payment_error","null");
        params.put("livemode",false);
        params.put("metadata","{}");
        params.put("next_action","null");
        params.put("on_behalf_of","null");
        params.put("payment_method","null");
        params.put("payment_method_options","{}");

        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        params.put("processing","null");
        params.put("receipt_email","null");
        params.put("redaction","null");
        params.put("review","null");
        params.put("setup_future_usage","null");
        params.put("shipping","null");
        params.put("statement_descriptor","null");
        params.put("statement_descriptor_suffix","null");
        params.put("status","requires_payment_method");
        params.put("transfer_data","null");
        params.put("transfer_group","null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String getPaymentIntent(String id){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);
        params.put("object", "payment_intent");
        params.put("amount", 2000);
        params.put("amount_capturable", 0);

        Map<String, Object> amountDetails = new HashMap<>();
        amountDetails.put("tip","{}");
        params.put("amount_details",amountDetails);

        params.put("amount_received", 0);
        params.put("application", "null");
        params.put("application_fee_amount", "null");
        params.put("automatic_payment_methods", "null");
        params.put("canceled_at", "null");
        params.put("cancellation_reason", "null");
        params.put("capture_method", "automatic");

        Map<String, Object> charges = new HashMap<>();
        charges.put("object", "list");
        charges.put("data", "[]");
        charges.put("has_more", "false");
        charges.put("url", "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI");
        params.put("charges", charges);

        params.put("client_secret","pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF");
        params.put("confirmation_method","automatic");
        params.put("created",1547506379);
        params.put("currency","usd");
        params.put("customer","null");
        params.put("description","null");
        params.put("invoice","null");
        params.put("last_payment_error","null");
        params.put("livemode",false);
        params.put("metadata","{}");
        params.put("next_action","null");
        params.put("on_behalf_of","null");
        params.put("payment_method","null");
        params.put("payment_method_options","{}");

        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        params.put("processing","null");
        params.put("receipt_email","null");
        params.put("redaction","null");
        params.put("review","null");
        params.put("setup_future_usage","null");
        params.put("shipping","null");
        params.put("statement_descriptor","null");
        params.put("statement_descriptor_suffix","null");
        params.put("status","requires_payment_method");
        params.put("transfer_data","null");
        params.put("transfer_group","null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;
    }

    @Override
    public String updatePaymentIntent(String id, UpdatePaymentIntentDTO updatePaymentIntentDTO){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);
        params.put("object", "payment_intent");
        params.put("amount", 2000);
        params.put("amount_capturable", 0);

        Map<String, Object> amountDetails = new HashMap<>();
        amountDetails.put("tip","{}");
        params.put("amount_details",amountDetails);

        params.put("amount_received", 0);
        params.put("application", "null");
        params.put("application_fee_amount", "null");
        params.put("automatic_payment_methods", "null");
        params.put("canceled_at", "null");
        params.put("cancellation_reason", "null");
        params.put("capture_method", "automatic");

        Map<String, Object> charges = new HashMap<>();
        charges.put("object", "list");
        charges.put("data", "[]");
        charges.put("has_more", "false");
        charges.put("url", "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI");
        params.put("charges", charges);

        params.put("client_secret","pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF");
        params.put("confirmation_method","automatic");
        params.put("created",1547506379);
        params.put("currency","usd");
        params.put("customer","null");
        params.put("description","null");
        params.put("invoice","null");
        params.put("last_payment_error","null");
        params.put("livemode",false);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", updatePaymentIntentDTO.getOrderId());
        params.put("metadata", metadata);
        params.put("next_action","null");
        params.put("on_behalf_of","null");
        params.put("payment_method","null");
        params.put("payment_method_options","{}");

        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        params.put("processing","null");
        params.put("receipt_email","null");
        params.put("redaction","null");
        params.put("review","null");
        params.put("setup_future_usage","null");
        params.put("shipping","null");
        params.put("statement_descriptor","null");
        params.put("statement_descriptor_suffix","null");
        params.put("status","requires_payment_method");
        params.put("transfer_data","null");
        params.put("transfer_group","null");

        Gson gson = new Gson();
        String json = gson.toJson(params);

        return json;

    }


    @Override
    public String isAuthorized(String id, Integer amount){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        String response = """
                {
                  "id": "%s",
                  "object": "payment_intent",
                  "amount": %s,
                  "amount_capturable": 2099,
                  "amount_details": {
                    "tip": {}
                  },
                  "amount_received": 0,
                  "application": null,
                  "application_fee_amount": null,
                  "automatic_payment_methods": null,
                  "canceled_at": null,
                  "cancellation_reason": null,
                  "capture_method": "manual",
                  "charges": {
                    "object": "list",
                    "data": [
                      {
                        "id": "ch_3LvScZ2eZvKYlo2C0p0nhllF",
                        "object": "charge",
                        "amount": 2099,
                        "amount_captured": 0,
                        "amount_refunded": 0,
                        "application": null,
                        "application_fee": null,
                        "application_fee_amount": null,
                        "balance_transaction": null,
                        "billing_details": {
                          "address": {
                            "city": null,
                            "country": null,
                            "line1": null,
                            "line2": null,
                            "postal_code": null,
                            "state": null
                          },
                          "email": null,
                          "name": null,
                          "phone": null
                        },
                        "calculated_statement_descriptor": "Stripe",
                        "captured": false,
                        "created": 1666387160,
                        "currency": "usd",
                        "customer": null,
                        "description": null,
                        "disputed": false,
                        "failure_balance_transaction": null,
                        "failure_code": null,
                        "failure_message": null,
                        "fraud_details": {},
                        "invoice": null,
                        "livemode": false,
                        "metadata": {},
                        "on_behalf_of": null,
                        "outcome": {
                          "network_status": "approved_by_network",
                          "reason": null,
                          "risk_level": "normal",
                          "risk_score": 54,
                          "seller_message": "Payment complete.",
                          "type": "authorized"
                        },
                        "paid": true,
                        "payment_intent": "pi_1DseIh2eZvKYlo2CwahhN9YI",
                        "payment_method": "pm_1LvScZ2eZvKYlo2C9i24ceYI",
                        "payment_method_details": {
                          "card": {
                            "brand": "visa",
                            "checks": {
                              "address_line1_check": null,
                              "address_postal_code_check": null,
                              "cvc_check": "pass"
                            },
                            "country": "DE",
                            "exp_month": 11,
                            "exp_year": 2050,
                            "fingerprint": "sHDtv5WzkN3N0VXv",
                            "funding": "credit",
                            "installments": null,
                            "last4": "3184",
                            "mandate": null,
                            "moto": null,
                            "network": "visa",
                            "three_d_secure": {
                              "authentication_flow": "challenge",
                              "result": "authenticated",
                              "result_reason": null,
                              "version": "1.0.2"
                            },
                            "wallet": null
                          },
                          "type": "card"
                        },
                        "receipt_email": null,
                        "receipt_number": null,
                        "receipt_url": "https://pay.stripe.com/receipts/payment/CAcaFwoVYWNjdF8xMDMyRDgyZVp2S1lsbzJDKJuv8JoGMgZPaDRSIgo6LBawqp7-uz2FZlzgDBe78e-DqLyZtJ2bTU2zF5cei5J3NFJ7Gkb5NcFmjT8B",
                        "redaction": null,
                        "refunded": false,
                        "refunds": {
                          "object": "list",
                          "data": [],
                          "has_more": false,
                          "url": "/v1/charges/ch_3LvScZ2eZvKYlo2C0p0nhllF/refunds"
                        },
                        "review": null,
                        "shipping": null,
                        "source_transfer": null,
                        "statement_descriptor": null,
                        "statement_descriptor_suffix": null,
                        "status": "succeeded",
                        "transfer_data": null,
                        "transfer_group": null
                      }
                    ],
                    "has_more": false,
                    "url": "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI"
                  },
                  "client_secret": "pi_1DseIh2eZvKYlo2CwahhN9YI_secret_VDNyNtCXWvQWx4JrfAhl7aaoV",
                  "confirmation_method": "automatic",
                  "created": 1666387155,
                  "currency": "usd",
                  "customer": null,
                  "description": null,
                  "invoice": null,
                  "last_payment_error": null,
                  "livemode": false,
                  "metadata": {},
                  "next_action": null,
                  "on_behalf_of": null,
                  "payment_method": "pm_1LvScZ2eZvKYlo2C9i24ceYI",
                  "payment_method_options": {
                    "card": {
                      "installments": null,
                      "mandate_options": null,
                      "network": null,
                      "request_three_d_secure": "automatic"
                    }
                  },
                  "payment_method_types": [
                    "card"
                  ],
                  "processing": null,
                  "receipt_email": null,
                  "redaction": null,
                  "review": null,
                  "setup_future_usage": null,
                  "shipping": null,
                  "statement_descriptor": null,
                  "statement_descriptor_suffix": null,
                  "status": "requires_capture",
                  "transfer_data": null,
                  "transfer_group": null
                }
                """.formatted(id, amount);

        return response;
    }

    @Override
    public String capturePaymentIntent(String id){
        if(!(id.contains("pi_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_INTENT_ID);
        }

        String response = """
                {
                  "id": "%s",
                  "object": "payment_intent",
                  "amount": 2099,
                  "amount_capturable": 2099,
                  "amount_details": {
                    "tip": {}
                  },
                  "amount_received": 0,
                  "application": null,
                  "application_fee_amount": null,
                  "automatic_payment_methods": null,
                  "canceled_at": null,
                  "cancellation_reason": null,
                  "capture_method": "manual",
                  "charges": {
                    "object": "list",
                    "data": [
                      {
                        "id": "ch_3LvScZ2eZvKYlo2C0p0nhllF",
                        "object": "charge",
                        "amount": 2099,
                        "amount_captured": 0,
                        "amount_refunded": 0,
                        "application": null,
                        "application_fee": null,
                        "application_fee_amount": null,
                        "balance_transaction": null,
                        "billing_details": {
                          "address": {
                            "city": null,
                            "country": null,
                            "line1": null,
                            "line2": null,
                            "postal_code": null,
                            "state": null
                          },
                          "email": null,
                          "name": null,
                          "phone": null
                        },
                        "calculated_statement_descriptor": "Stripe",
                        "captured": false,
                        "created": 1666387160,
                        "currency": "usd",
                        "customer": null,
                        "description": null,
                        "disputed": false,
                        "failure_balance_transaction": null,
                        "failure_code": null,
                        "failure_message": null,
                        "fraud_details": {},
                        "invoice": null,
                        "livemode": false,
                        "metadata": {},
                        "on_behalf_of": null,
                        "outcome": {
                          "network_status": "approved_by_network",
                          "reason": null,
                          "risk_level": "normal",
                          "risk_score": 54,
                          "seller_message": "Payment complete.",
                          "type": "authorized"
                        },
                        "paid": true,
                        "payment_intent": "pi_1DseIh2eZvKYlo2CwahhN9YI",
                        "payment_method": "pm_1LvScZ2eZvKYlo2C9i24ceYI",
                        "payment_method_details": {
                          "card": {
                            "brand": "visa",
                            "checks": {
                              "address_line1_check": null,
                              "address_postal_code_check": null,
                              "cvc_check": "pass"
                            },
                            "country": "DE",
                            "exp_month": 11,
                            "exp_year": 2050,
                            "fingerprint": "sHDtv5WzkN3N0VXv",
                            "funding": "credit",
                            "installments": null,
                            "last4": "3184",
                            "mandate": null,
                            "moto": null,
                            "network": "visa",
                            "three_d_secure": {
                              "authentication_flow": "challenge",
                              "result": "authenticated",
                              "result_reason": null,
                              "version": "1.0.2"
                            },
                            "wallet": null
                          },
                          "type": "card"
                        },
                        "receipt_email": null,
                        "receipt_number": null,
                        "receipt_url": "https://pay.stripe.com/receipts/payment/CAcaFwoVYWNjdF8xMDMyRDgyZVp2S1lsbzJDKJuv8JoGMgZPaDRSIgo6LBawqp7-uz2FZlzgDBe78e-DqLyZtJ2bTU2zF5cei5J3NFJ7Gkb5NcFmjT8B",
                        "redaction": null,
                        "refunded": false,
                        "refunds": {
                          "object": "list",
                          "data": [],
                          "has_more": false,
                          "url": "/v1/charges/ch_3LvScZ2eZvKYlo2C0p0nhllF/refunds"
                        },
                        "review": null,
                        "shipping": null,
                        "source_transfer": null,
                        "statement_descriptor": null,
                        "statement_descriptor_suffix": null,
                        "status": "succeeded",
                        "transfer_data": null,
                        "transfer_group": null
                      }
                    ],
                    "has_more": false,
                    "url": "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI"
                  },
                  "client_secret": "pi_1DseIh2eZvKYlo2CwahhN9YI_secret_VDNyNtCXWvQWx4JrfAhl7aaoV",
                  "confirmation_method": "automatic",
                  "created": 1666387155,
                  "currency": "usd",
                  "customer": null,
                  "description": null,
                  "invoice": null,
                  "last_payment_error": null,
                  "livemode": false,
                  "metadata": {},
                  "next_action": null,
                  "on_behalf_of": null,
                  "payment_method": "pm_1LvScZ2eZvKYlo2C9i24ceYI",
                  "payment_method_options": {
                    "card": {
                      "installments": null,
                      "mandate_options": null,
                      "network": null,
                      "request_three_d_secure": "automatic"
                    }
                  },
                  "payment_method_types": [
                    "card"
                  ],
                  "processing": null,
                  "receipt_email": null,
                  "redaction": null,
                  "review": null,
                  "setup_future_usage": null,
                  "shipping": null,
                  "statement_descriptor": null,
                  "statement_descriptor_suffix": null,
                  "status": "requires_capture",
                  "transfer_data": null,
                  "transfer_group": null
                }
                """.formatted(id);

        return  response;
    }

    @Override
    public String getAllPaymentIntents(){
        String response = """
                {
                  "object": "list",
                  "url": "/v1/payment_intents",
                  "has_more": false,
                  "data": [
                    {
                      "id": "pi_1DseIh2eZvKYlo2CwahhN9YI",
                      "object": "payment_intent",
                      "amount": 1099,
                      "amount_capturable": 0,
                      "amount_details": {
                        "tip": {}
                      },
                      "amount_received": 0,
                      "application": null,
                      "application_fee_amount": null,
                      "automatic_payment_methods": null,
                      "canceled_at": null,
                      "cancellation_reason": null,
                      "capture_method": "automatic",
                      "charges": {
                        "object": "list",
                        "data": [],
                        "has_more": false,
                        "url": "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI"
                      },
                      "client_secret": "pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF",
                      "confirmation_method": "automatic",
                      "created": 1547506379,
                      "currency": "eur",
                      "customer": null,
                      "description": null,
                      "invoice": null,
                      "last_payment_error": null,
                      "livemode": false,
                      "metadata": {},
                      "next_action": null,
                      "on_behalf_of": null,
                      "payment_method": null,
                      "payment_method_options": {},
                      "payment_method_types": [
                        "card"
                      ],
                      "processing": null,
                      "receipt_email": null,
                      "redaction": null,
                      "review": null,
                      "setup_future_usage": null,
                      "shipping": null,
                      "statement_descriptor": null,
                      "statement_descriptor_suffix": null,
                      "status": "requires_payment_method",
                      "transfer_data": null,
                      "transfer_group": null
                    },
                    {
                      "id": "pi_2AseIh2eZvKYlo2CwafgI8IP",
                      "object": "payment_intent",
                      "amount": 3521,
                      "amount_capturable": 0,
                      "amount_details": {
                        "tip": {}
                      },
                      "amount_received": 0,
                      "application": null,
                      "application_fee_amount": null,
                      "automatic_payment_methods": null,
                      "canceled_at": null,
                      "cancellation_reason": null,
                      "capture_method": "automatic",
                      "charges": {
                        "object": "list",
                        "data": [],
                        "has_more": false,
                        "url": "/v1/charges?payment_intent=pi_1DseIh2eZvKYlo2CwahhN9YI"
                      },
                      "client_secret": "pi_1DseIh2eZvKYlo2CwahhN9YI_secret_YiNJu2AhD8LTrjLjBU3KgLcdF",
                      "confirmation_method": "automatic",
                      "created": 2017506693,
                      "currency": "eur",
                      "customer": null,
                      "description": null,
                      "invoice": null,
                      "last_payment_error": null,
                      "livemode": false,
                      "metadata": {},
                      "next_action": null,
                      "on_behalf_of": null,
                      "payment_method": null,
                      "payment_method_options": {},
                      "payment_method_types": [
                        "card"
                      ],
                      "processing": null,
                      "receipt_email": null,
                      "redaction": null,
                      "review": null,
                      "setup_future_usage": null,
                      "shipping": null,
                      "statement_descriptor": null,
                      "statement_descriptor_suffix": null,
                      "status": "requires_payment_method",
                      "transfer_data": null,
                      "transfer_group": null
                    }
                  ]
                }
                """;
        return response;
    }


}
