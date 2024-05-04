package com.mulitLinguify.dto;

import lombok.Data;

@Data
public class WriteResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error;
}
