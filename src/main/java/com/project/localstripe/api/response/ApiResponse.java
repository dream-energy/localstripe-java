package com.project.localstripe.api.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>{

    private String statusCode;
    private String statusDescription;
    private T result;

}
