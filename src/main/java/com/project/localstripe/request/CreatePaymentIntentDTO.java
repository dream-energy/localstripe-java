package com.project.localstripe.request;


import lombok.Data;

@Data
public class  CreatePaymentIntentDTO {

    private Integer amount;
    private String currency;
}
