package com.project.localstripe.request;

import lombok.Data;

@Data
public class CreateTokenDTO {
    private String number;
    private Integer expiryMonth;
    private Integer expiryYear;
    private String cvc;

    public CreateTokenDTO(String number, Integer expiryMonth, Integer expiryYear, String cvc) {
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvc = cvc;
    }
}
