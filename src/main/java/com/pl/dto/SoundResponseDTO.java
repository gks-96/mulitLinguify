package com.pl.dto;

import lombok.Data;

@Data
public class SoundResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error;
}
