package com.pl.service.contracts;


import com.pl.dto.SoundResponseDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CharacterVoiceRecognitionService<O,I>
{
    public O voiceRecognize(I i, String language) ;


}