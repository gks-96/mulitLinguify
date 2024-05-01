package com.pl.controller.implementation;



import com.pl.controller.contracts.CharacterWriteRecognitionController;
import com.pl.dto.WriteRequestDTO;
import com.pl.dto.WriteResponseDTO;
import com.pl.service.contracts.CharacterWriteRecognitionService;
//import com.pl.service.impl.DetectText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


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
    public ResponseEntity<WriteResponseDTO> writeController(WriteRequestDTO writeRequestDTO,@PathVariable String lang) {

        WriteResponseDTO res = null ;
                try {
                     res  = characterWriteService.writerecognize(writeRequestDTO);
                } catch (Exception e) {
                    return new ResponseEntity<>(res,
                                                HttpStatusCode.valueOf(400));
                }
                return new ResponseEntity<>(res,
                                            HttpStatusCode.valueOf(200));
//        return null;
    }
}
