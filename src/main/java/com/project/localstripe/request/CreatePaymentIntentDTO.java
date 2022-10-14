package com.project.localstripe.request;


import lombok.Data;

@Data
public class CreatePaymentIntentDTO {

    private String paymentMethodType;
    private Integer amount;
    private String currency;
}
