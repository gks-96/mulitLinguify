package com.mulitLinguify.utilities;


import com.google.protobuf.ByteString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


public class Base64DecoderTest {

    @Autowired
     Base64Decoder decoder = new Base64Decoder();

    String encodedCharacters = "aGVsbG8gd29ybGQ="; // "hello world" in base64
    String expectedString = "hello world";

    @Test
    void testDecodeImageWhenCorrectImageProvidedTest() {
        ByteString decodedBytes = decoder.stringDecoder(encodedCharacters);
       System.out.println("decoded string " + new String(decodedBytes.toByteArray()));
        assertEquals(expectedString, new String(decodedBytes.toByteArray() ) );
    }
}
