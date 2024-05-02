package com.pl.controller.contracts;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code CharacterVoiceRecognitionController} interface defines the contract for a REST controller
 * responsible for handling voice recognition requests in a multilingual environment.
 *
 * @param <O> The type of the response object returned by the controller methods.
 * @param <I> The type of the request object expected by the controller methods.
 */
@RestController
public interface CharacterVoiceRecognitionController<O, I> {

    /**
     * Handles voice recognition requests for validating audio inputs against language models.
     *
     * @param i    The input data representing the audio to be recognized.
     * @param lang The language identifier specifying the language for recognition.
     * @return A ResponseEntity representing the response to the recognition request.
     */
    @PostMapping("multilinguify/lang/{lang}/validate/audio")
    ResponseEntity<O> voiceController(I i, @PathVariable String lang);
}