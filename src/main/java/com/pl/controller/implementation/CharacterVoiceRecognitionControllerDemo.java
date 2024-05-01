//package com.pl.controller.implementation;
//
//
//import com.pl.controller.contracts.CharacterVoiceRecognitionController;
//import com.pl.dto.SoundDTO;
//import com.pl.service.impl.CharacterVoiceRecognitionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class CharacterVoiceRecognitionControllerDemo implements CharacterVoiceRecognitionController<String, SoundDTO> {
//
//    @Autowired
//    CharacterVoiceRecognitionService characterVoiceRecognitionService;
//
////    @PostMapping("api/punjabi/sound/verify/")
//////    public ResponseEntity<String> characterIdentfication(@RequestBody SoundDTO soundDTO) throws IOException {
//////
//////        System.out.println("sound dto  is -------- "+ soundDTO.getEncodedAudio());
//////        String result = characterVoiceRecognitionService.recognizeVoice(soundDTO.getEncodedAudio());
//////        return new ResponseEntity<>(result,
//////                                    HttpStatusCode.valueOf(201));
//////    }
//
//    @Override
//    public ResponseEntity<String> voiceController(SoundDTO dto) {
//        return null;
//    }
//}
