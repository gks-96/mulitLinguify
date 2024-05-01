package com.pl.controller.contracts;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("@RestController")
public interface CharacterVoiceRecognitionController<O,I> {

    @PostMapping("multilinguify/lang/{lang}/validate/audio")
    public ResponseEntity<O> voiceController( I i);
}
