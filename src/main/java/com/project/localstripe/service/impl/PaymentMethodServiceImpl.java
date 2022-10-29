package com.project.localstripe.service.impl;

import com.project.localstripe.common.Constants;
import com.project.localstripe.request.CreatePaymentDTO;
import com.project.localstripe.service.PaymentMethodService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Override
    public String paymentMethodAttach(String id, String customerId){

        if(!(id.contains("pm_")) && !(customerId.contains("cus_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_METHOD);
        }

        String response = """
                {
                  "id": "pm_1Lw6Db2eZvKYlo2CsbAYSXpj",
                  "object": "payment_method",
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
                  "card": {
                    "brand": "visa",
                    "checks": {
                      "address_line1_check": null,
                      "address_postal_code_check": null,
                      "cvc_check": "unchecked"
                    },
                    "country": "US",
                    "exp_month": 8,
                    "exp_year": 2023,
                    "fingerprint": "Xt5EWLLDS7FJjR1c",
                    "funding": "credit",
                    "generated_from": null,
                    "last4": "4242",
                    "networks": {
                      "available": [
                        "visa"
                      ],
                      "preferred": null
                    },
                    "three_d_secure_usage": {
                      "supported": true
                    },
                    "wallet": null
                  },
                  "created": 1666539368,
                  "customer": "%s",
                  "livemode": false,
                  "metadata": {},
                  "redaction": null,
                  "type": "card"
                }
                """.formatted(customerId);

        return response;
    }

    @Override
    public String paymentMethodDetach(String id){

        if(!(id.contains("pm_"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAYMENT_METHOD);
        }

        String response = """
                {
                  "id": "pm_1Lw6Db2eZvKYlo2CsbAYSXpj",
                  "object": "payment_method",
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
                  "card": {
                    "brand": "visa",
                    "checks": {
                      "address_line1_check": null,
                      "address_postal_code_check": null,
                      "cvc_check": "unchecked"
                    },
                    "country": "US",
                    "exp_month": 8,
                    "exp_year": 2023,
                    "fingerprint": "Xt5EWLLDS7FJjR1c",
                    "funding": "credit",
                    "generated_from": null,
                    "last4": "4242",
                    "networks": {
                      "available": [
                        "visa"
                      ],
                      "preferred": null
                    },
                    "three_d_secure_usage": {
                      "supported": true
                    },
                    "wallet": null
                  },
                  "created": 1666539368,
                  "customer": null,
                  "livemode": false,
                  "metadata": {},
                  "redaction": null,
                  "type": "card"
                }
                """;

        return response;
    }

    @Override
    public String createPaymentMethod(CreatePaymentDTO createPaymentDTO){

        String response = """
                {
                  "id": "pm_1Lw6Db2eZvKYlo2CsbAYSXpj",
                  "object": "payment_method",
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
                  "card": {
                    "brand": "visa",
                    "checks": {
                      "address_line1_check": null,
                      "address_postal_code_check": null,
                      "cvc_check": "unchecked"
                    },
                    "country": "US",
                    "exp_month": %s,
                    "exp_year": %s,
                    "fingerprint": "Xt5EWLLDS7FJjR1c",
                    "funding": "credit",
                    "generated_from": null,
                    "last4": "4242",
                    "networks": {
                      "available": [
                        "visa"
                      ],
                      "preferred": null
                    },
                    "three_d_secure_usage": {
                      "supported": true
                    },
                    "wallet": null
                  },
                  "created": 1666539368,
                  "customer": null,
                  "livemode": false,
                  "metadata": {},
                  "redaction": null,
                  "type": "%s"
                }
                """.formatted(createPaymentDTO.getExpMonth(), createPaymentDTO.getExpYear(),createPaymentDTO.getType());

        return response;
    }
}
