package com.mulitLinguify.controller.implementation;


import com.mulitLinguify.controller.contracts.CharacterVoiceRecognitionController;

import com.mulitLinguify.dto.SoundRequestDTO;
import com.mulitLinguify.dto.SoundResponseDTO;
//import com.pl.service.impl.CharacterVoiceRecognitionService;
//import com.pl.service.impl.CharacterVoiceRecognitionServiceGCP;
import com.mulitLinguify.service.contracts.CharacterVoiceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
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
    public ResponseEntity<SoundResponseDTO> voiceController(@RequestBody  SoundRequestDTO soundRequestDTO, @PathVariable String lang) {
//        System.out.println("input is --" + soundRequestDTO.getEncodedAudio());
        SoundResponseDTO result = characterVoiceRecognitionService.voiceRecognize(soundRequestDTO,lang);


//        System.out.println("result is + + " + result.getPercentageAccuracy());

                if ( !result.getError().equals(""))
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
