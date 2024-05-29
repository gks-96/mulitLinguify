package com.mulitLinguify.controller.implementation;



import com.mulitLinguify.controller.contracts.CharacterWriteRecognitionController;
import com.mulitLinguify.dto.WriteRequestDTO;
import com.mulitLinguify.dto.WriteResponseDTO;
import com.mulitLinguify.service.contracts.CharacterWriteRecognitionService;
//import com.pl.service.impl.DetectText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CharacterWriteRecognitionControllerImpl implements CharacterWriteRecognitionController<WriteResponseDTO,WriteRequestDTO> {

    @Autowired
    CharacterWriteRecognitionService<WriteResponseDTO,WriteRequestDTO> characterWriteService;



    //    @PostMapping("api/punjabi/gcp")
//    public ResponseEntity<WriteResponseDTO> characterIdentfication(@RequestBody WriteRequestDTO imageRequestDTO) {
//
//        WriteResponseDTO res = null ;
//        try {
//             res  = detectText.detectDocumentText(imageRequestDTO.getDrawnImage());
//        } catch (Exception e) {
//            return new ResponseEntity<>(res,
//                                        HttpStatusCode.valueOf(400));
//        }
//        return new ResponseEntity<>(res,
//                                    HttpStatusCode.valueOf(200));
//    }

    @Override
    @PostMapping("multilinguify/lang/{lang}/validate/write")
    public ResponseEntity<WriteResponseDTO> writeController(@PathVariable String lang,@RequestBody  WriteRequestDTO writeRequestDTO) {

//        System.out.println("inside controller ");
        WriteResponseDTO res = null ;
                try {
                     res  = characterWriteService.writerecognize(writeRequestDTO,lang);

                     if ( !res.getError().isEmpty())
                     {
                         return new ResponseEntity<>(res,
                                                     HttpStatusCode.valueOf(400));
                     }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResponseEntity<>(res,
                                                HttpStatusCode.valueOf(400));
                }

                return new ResponseEntity<>(res,
                                            HttpStatusCode.valueOf(200));
//        return null;
    }
}
