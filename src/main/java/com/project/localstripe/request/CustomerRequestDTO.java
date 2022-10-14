package com.project.localstripe.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String object;
    private Long balance;
    private Long created;
    private String currency;

    public CustomerRequestDTO(String object, Long balance, Long created, String currency, String defaultSource, boolean delinquent, String description, String email, String name) {
        this.object = object;
        this.balance = balance;
        this.created = created;
        this.currency = currency;
        this.defaultSource = defaultSource;
        this.delinquent = delinquent;
        this.description = description;
        this.email = email;
        this.name = name;
    }

    private String defaultSource;
    private boolean delinquent;
    private String description;
    private String email;
    private String name;

}
