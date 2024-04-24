package com.pl.util;

import com.google.protobuf.ByteString;

import java.util.Base64;

public class Base64Decoder {

    public ByteString imageDecoder(String encodedCharacter)
    {
        byte[] decodedBytesCorrectImage = Base64.getDecoder().decode(encodedCharacter);

        ByteString imgBytes = ByteString.copyFrom(decodedBytesCorrectImage) ;
        return imgBytes;
    }
}
