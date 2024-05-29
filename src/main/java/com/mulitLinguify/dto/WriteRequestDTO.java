package com.mulitLinguify.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriteRequestDTO {

    private String correctImage;

    private String drawnImage;

    public WriteRequestDTO(String correctImage , String drawnImage) {
        this.correctImage = correctImage;
        this.drawnImage = drawnImage;
    }

    public WriteRequestDTO(){

    }
}
