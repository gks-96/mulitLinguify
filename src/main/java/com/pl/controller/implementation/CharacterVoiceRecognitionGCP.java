//package com.pl.controller.implementation;
//
//
//import com.pl.dto.SoundDTO;
//import com.pl.service.impl.CharacterVoiceRecognitionService;
//import com.pl.service.impl.CharacterVoiceRecognitionServiceGCP;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//
//@RestController
//public class CharacterVoiceRecognitionGCP {
//
//    @Autowired
//    CharacterVoiceRecognitionServiceGCP characterVoiceRecognitionServiceGCP;
//
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
//}
