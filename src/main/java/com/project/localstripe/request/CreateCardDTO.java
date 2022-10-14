package com.project.localstripe.request;

import com.stripe.model.Source;
import lombok.Data;

@Data
public class CreateCardDTO {
    private String source;
}
