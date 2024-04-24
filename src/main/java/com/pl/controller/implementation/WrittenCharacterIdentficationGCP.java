package com.pl.controller.implementation;


import com.pl.dto.WriteRequestDTO;
import com.pl.dto.WriteResponseDTO;
import com.pl.service.impl.CharacterIdentificationService;
import com.pl.service.impl.DetectText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintStream;


@RestController
public class WrittenCharacterIdentficationGCP {

    @Autowired
    DetectText detectText;

    @PostMapping("api/punjabi/gcp")
    public ResponseEntity<WriteResponseDTO> characterIdentfication(@RequestBody WriteRequestDTO imageRequestDTO) {

        WriteResponseDTO res = null ;
        try {
             res  = detectText.detectDocumentText(imageRequestDTO.getDrawnImage());
        } catch (Exception e) {
            return new ResponseEntity<>(res,
                                        HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(res,
                                    HttpStatusCode.valueOf(200));
    }
}
