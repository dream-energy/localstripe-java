package com.project.localstripe.request;

import lombok.Data;

@Data
public class ChargeRequestDTO {
    private String description;
    private int amount;
    private String currency;
    private String source;

    public ChargeRequestDTO(String description, int amount, String currency, String source) {
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.source = source;
    }
}
