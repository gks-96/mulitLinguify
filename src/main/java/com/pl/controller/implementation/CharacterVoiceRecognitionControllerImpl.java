package com.pl.controller.implementation;


import com.pl.controller.contracts.CharacterVoiceRecognitionController;

import com.pl.dto.SoundRequestDTO;
import com.pl.dto.SoundResponseDTO;
//import com.pl.service.impl.CharacterVoiceRecognitionService;
//import com.pl.service.impl.CharacterVoiceRecognitionServiceGCP;
import com.pl.service.contracts.CharacterVoiceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;



public class CharacterVoiceRecognitionControllerImpl implements CharacterVoiceRecognitionController<SoundResponseDTO, SoundRequestDTO> {

    @Autowired
    CharacterVoiceRecognitionService<SoundResponseDTO, SoundRequestDTO> characterVoiceRecognitionService;

//    @PostMapping("api/punjabi/sound/verify/gcp")
//    public ResponseEntity<String> characterIdentfication(@RequestBody SoundDTO soundDTO) throws IOException {
//
//        System.out.println("sound dto  is -------- "+ soundDTO.getEncodedAudio());
//        String result = characterVoiceRecognitionServiceGCP.recognizeVoice(soundDTO.getEncodedAudio(),"pan");
//        if ( result.isEmpty())
//        {
//            return new ResponseEntity<>(result,
//                                        HttpStatusCode.valueOf(400));
//        }
//        else{
//            return new ResponseEntity<>(result,
//                                        HttpStatusCode.valueOf(200));
//        }
//    }

    @PostMapping("multilinguify/lang/{lang}/validate/audio")
    public ResponseEntity<SoundResponseDTO> voiceController(SoundRequestDTO soundRequestDTO,@PathVariable String lang) {
        SoundResponseDTO result = characterVoiceRecognitionService.voiceRecognize(soundRequestDTO,lang);
                if ( result.getError().equals(""))
                {
                    return new ResponseEntity<>(result,
                                                HttpStatusCode.valueOf(400));
                }
                else{
                    return new ResponseEntity<>(result,
                                                HttpStatusCode.valueOf(200));
                }
    }



}
