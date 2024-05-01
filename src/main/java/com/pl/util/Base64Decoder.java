package com.pl.util;

import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Decoder {

    public ByteString stringDecoder(String encodedCharacter)
    {
        byte[] decodedBytesCorrectImage = Base64.getDecoder().decode(encodedCharacter);

        ByteString imgBytes = ByteString.copyFrom(decodedBytesCorrectImage) ;
        return imgBytes;
    }
}
