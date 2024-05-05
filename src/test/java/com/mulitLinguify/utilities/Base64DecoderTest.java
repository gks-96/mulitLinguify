package com.mulitLinguify.utilities;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;
import com.mulitLinguify.dto.WriteRequestDTO;
import com.mulitLinguify.utilities.Base64Decoder;
import org.aspectj.lang.annotation.Before;
import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Base64DecoderTest {


    @Autowired
     Base64Decoder decoder = new Base64Decoder();

    String encodedCharacters = "aGVsbG8gd29ybGQ="; // "hello world" in base64
    String expectedString = "hello world";




    @org.junit.jupiter.api.Test
    void testDecodeImageWhenCorrectImageProvided() {
        ByteString decodedBytes = decoder.stringDecoder(encodedCharacters);
       System.out.println("decoded string " + new String(decodedBytes.toByteArray()));
        assertEquals(expectedString, new String(decodedBytes.toByteArray() ) );
    }
}
