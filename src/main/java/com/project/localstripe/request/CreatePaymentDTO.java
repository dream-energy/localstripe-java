package com.project.localstripe.request;

import lombok.Data;

@Data
public class CreatePaymentDTO {
    private String number;
    private Integer expMonth;
    private Integer expYear;
    private String cvc;
    private String type;
}
