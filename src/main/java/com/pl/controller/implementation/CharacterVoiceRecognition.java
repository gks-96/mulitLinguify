package com.pl.controller.implementation;


import com.pl.dto.SoundDTO;
import com.pl.service.impl.CharacterIdentificationService;
import com.pl.service.impl.CharacterVoiceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class CharacterVoiceRecognition {

    @Autowired
    CharacterVoiceRecognitionService characterVoiceRecognitionService;

    @PostMapping("api/punjabi/sound/verify/")
    public ResponseEntity<String> characterIdentfication(@RequestBody SoundDTO soundDTO) throws IOException {

        System.out.println("sound dto  is -------- "+ soundDTO.getEncodedAudio());
        String result = characterVoiceRecognitionService.recognizeVoice(soundDTO.getEncodedAudio());
        return new ResponseEntity<>(result,
                                    HttpStatusCode.valueOf(201));
    }
}
