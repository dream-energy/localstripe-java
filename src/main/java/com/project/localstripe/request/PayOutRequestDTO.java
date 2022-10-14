package com.project.localstripe.request;

import lombok.Data;

@Data
public class PayOutRequestDTO {
    private String id;
    private int amount;
    private String currency;
    private String status;
}
