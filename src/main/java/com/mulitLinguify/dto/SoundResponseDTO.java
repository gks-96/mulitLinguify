package com.mulitLinguify.dto;

import lombok.Data;
import lombok.Setter;

@Setter
public class SoundResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error;
}
