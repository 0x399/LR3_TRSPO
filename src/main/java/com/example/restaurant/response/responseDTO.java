package com.example.restaurant.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class responseDTO {

    private String statusCode;
    private String statusMessage;
}
