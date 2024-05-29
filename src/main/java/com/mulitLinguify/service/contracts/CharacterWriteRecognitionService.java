package com.mulitLinguify.service.contracts;


import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CharacterWriteRecognitionService<O,I>{

    O writerecognize(I i,String lang) throws IOException;
}
