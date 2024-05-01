//package com.pl.controller.implementation;
//
//
//import com.pl.controller.contracts.CharacterWriteRecognition;
//import com.pl.dto.WriteRequestDTO;
//import com.pl.service.impl.CharacterIdentificationService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//
//@RestController
//public class CharacterWriteRecognitionImpl implements CharacterWriteRecognition<String,> {
//
//    @Autowired
//    CharacterIdentificationService characterIdentificationService;
//
////    @PostMapping("api/punjabi/")
////    public ResponseEntity<String> characterIdentfication(@RequestBody WriteRequestDTO imageDTO) {
////
////        String result = null;
////        try {
////            result = characterIdentificationService.recognizingCharacter(imageDTO.getCorrectImage(),imageDTO.getDrawnImage() );
////        } catch (  IOException e) {
////            throw new RuntimeException(e);
////        }
////        return new ResponseEntity<>(result,
////                                    HttpStatusCode.valueOf(200));
////    }
//
//    @Override
//    public ResponseEntity<String> characterWrite(Object o) {
//        return null;
//    }
//}
