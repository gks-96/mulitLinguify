package com.mulitLinguify.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SoundResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error="";

    public SoundResponseDTO(String character , Double percentageAccuracy , String error) {
        this.character = character;
        this.percentageAccuracy = percentageAccuracy;
        this.error = error;
    }

    public SoundResponseDTO(){

    }
}
