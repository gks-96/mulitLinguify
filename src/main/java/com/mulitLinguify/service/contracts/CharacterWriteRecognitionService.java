package com.mulitLinguify.service.contracts;


import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CharacterWriteRecognitionService<O,I>{

    public O writerecognize(I i) throws IOException;
}
