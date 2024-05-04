package com.mulitLinguify.service.contracts;


import org.springframework.stereotype.Service;

@Service
public interface CharacterVoiceRecognitionService<O,I>
{
    public O voiceRecognize(I i, String language) ;


}