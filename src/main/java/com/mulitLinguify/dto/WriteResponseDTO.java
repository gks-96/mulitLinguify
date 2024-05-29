package com.mulitLinguify.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WriteResponseDTO {

    private String character;

    private Double percentageAccuracy;

    private String error;

    public WriteResponseDTO(String character , Double percentageAccuracy , String error) {
        this.character = character;
        this.percentageAccuracy = percentageAccuracy;
        this.error = error;
    }
    public WriteResponseDTO(){

    }

    @Override
    public String toString() {
        return "WriteResponseDTO{" + "character='" + character + '\'' + ", percentageAccuracy=" + percentageAccuracy +
                ", error='" + error + '\'' + '}';
    }
}
