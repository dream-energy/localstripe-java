package com.project.localstripe.request;

import lombok.Data;

@Data
public class ChargeRequestDTO {
    private String description;
    private int amount;
    private String currency;
    private String stripeEmail;
    private String source;

    public ChargeRequestDTO(String description, int amount, String currency, String stripeEmail, String source) {
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.stripeEmail = stripeEmail;
        this.source = source;
    }
}
