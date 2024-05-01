package com.pl.controller.contracts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CharacterWriteRecognitionController <O ,I> {

    @PostMapping("multilinguify/lang/{lang}/validate/write")
    public ResponseEntity<O> writeController(I i);
}
