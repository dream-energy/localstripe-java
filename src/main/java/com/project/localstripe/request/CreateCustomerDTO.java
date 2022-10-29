package com.project.localstripe.request;

import lombok.Data;

@Data
public class CreateCustomerDTO {
    String description;

    public CreateCustomerDTO(String description) {
        this.description = description;
    }
}
