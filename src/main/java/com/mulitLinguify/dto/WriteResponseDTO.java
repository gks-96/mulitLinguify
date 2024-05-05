package com.mulitLinguify.dto;

import lombok.Data;
import lombok.Setter;

@Setter
public class WriteResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error;
}
