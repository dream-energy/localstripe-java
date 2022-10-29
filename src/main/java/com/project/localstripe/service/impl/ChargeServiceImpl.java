package com.project.localstripe.service.impl;

import com.project.localstripe.request.ChargeRequestDTO;
import com.project.localstripe.service.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ChargeServiceImpl implements ChargeService {

    @Override
    public String charge(ChargeRequestDTO chargeRequestDTO){
        String response = """
                {
                  "id": "ch_3Lxc1X2eZvKYlo2C0UCPCgMx",
                  "object": "charge",
                  "amount": %s,
                  "amount_captured": 0,
                  "amount_refunded": 0,
                  "application": null,
                  "application_fee": null,
                  "application_fee_amount": null,
                  "balance_transaction": "txn_1032HU2eZvKYlo2CEPtcnUvl",
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
                  "calculated_statement_descriptor": null,
                  "captured": false,
                  "created": 1666899955,
                  "currency": "%s",
                  "customer": null,
                  "description": "%s",
                  "disputed": false,
                  "failure_balance_transaction": null,
                  "failure_code": null,
                  "failure_message": null,
                  "fraud_details": {},
                  "invoice": null,
                  "livemode": false,
                  "metadata": {},
                  "on_behalf_of": null,
                  "outcome": null,
                  "paid": true,
                  "payment_intent": null,
                  "payment_method": "card_103Z0w2eZvKYlo2CyzMjT1R1",
                  "payment_method_details": {
                    "card": {
                      "brand": "visa",
                      "checks": {
                        "address_line1_check": null,
                        "address_postal_code_check": null,
                        "cvc_check": "unchecked"
                      },
                      "country": "US",
                      "exp_month": 2,
                      "exp_year": 2015,
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
                  "receipt_number": null,
                  "receipt_url": "https://pay.stripe.com/receipts/payment/CAcaFwoVYWNjdF8xMDMyRDgyZVp2S1lsbzJDKPO_65oGMgYddfs6TJ46LBYuHHxYquqXQEJeyf2PFk5HsR31dtXAgqAXFtFPwpGK6YoL3dpSjWDq44oO",
                  "redaction": null,
                  "refunded": false,
                  "refunds": {
                    "object": "list",
                    "data": [],
                    "has_more": false,
                    "url": "/v1/charges/ch_3Lxc1X2eZvKYlo2C0UCPCgMx/refunds"
                  },
                  "review": null,
                  "shipping": null,
                  "source_transfer": null,
                  "statement_descriptor": null,
                  "statement_descriptor_suffix": null,
                  "status": "succeeded",
                  "transfer_data": null,
                  "transfer_group": null,
                  "source": "%s"
                }
                """.formatted(chargeRequestDTO.getAmount(),chargeRequestDTO.getCurrency(),chargeRequestDTO.getDescription(),chargeRequestDTO.getSource());

    return response;

    }
}
