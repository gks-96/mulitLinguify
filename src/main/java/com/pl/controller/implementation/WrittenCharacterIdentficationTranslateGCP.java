//package com.pl.controller.implementation;
//
//
//import com.pl.dto.ImageRequestDTO;
//import com.pl.dto.ImageResponseDTO;
//import com.pl.service.impl.DetectText;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Base64;
//
//
//@RestController
//public class WrittenCharacterIdentficationTranslateGCP {
//
//    @Autowired
//    TranslatorService translationService;
//
//    @PostMapping("api/punjabi/gcp/translate")
//    public ResponseEntity<ImageResponseDTO> characterIdentfication(@RequestBody ImageRequestDTO imageRequestDTO) {
//
//        try {
//            // Decode base64 encoded text
//            byte[] decodedBytes = Base64.getDecoder().decode(imageRequestDTO.getDrawnImage());
//            String originalText = new String(decodedBytes);
//
//            // Translate the decoded text
//            String translatedText = translationService.translateText(originalText, sourceLanguage, targetLanguage);
//
//            return ResponseEntity.ok().body(translatedText);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error translating text.");
//        }
//
//
//
//        return new ResponseEntity<>(res,
//                                    HttpStatusCode.valueOf(200));
//    }
//}
