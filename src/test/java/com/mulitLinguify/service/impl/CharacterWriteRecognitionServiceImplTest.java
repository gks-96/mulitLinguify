package com.mulitLinguify.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.mulitLinguify.controller.implementation.CharacterWriteRecognitionControllerImpl;
import com.mulitLinguify.dto.WriteRequestDTO;
import com.mulitLinguify.dto.WriteResponseDTO;
import com.mulitLinguify.utilities.Base64Decoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class CharacterWriteRecognitionServiceImplTest {

    // mock the external dependencies
    private CharacterWriteRecognitionServiceImpl service;
    private Base64Decoder base64DecoderMock;
    private ImageAnnotatorClient imageAnnotatorClientMock;

    @BeforeEach
    void setup() {
        base64DecoderMock = mock(Base64Decoder.class);
        service = new CharacterWriteRecognitionServiceImpl();
        service.base64Decoder = base64DecoderMock;
    }


    @Test
    void testWriterecognizeWithInvalidImageTest() throws IOException {
        // Setup
        WriteRequestDTO requestDTO = new WriteRequestDTO("A","QQ=");
        when(base64DecoderMock.stringDecoder(any())).thenReturn(null);

        // Execute
        WriteResponseDTO responseDTO = service.writerecognize(requestDTO);

        // Verify
        assertNotNull(responseDTO);
        assertEquals("", responseDTO.getCharacter());
        assertEquals(0.0d, responseDTO.getPercentageAccuracy());
        assertEquals("Image Sent is not base 64", responseDTO.getError());
    }

    @Test
    void testWriterecognizeWithValidInputTest() throws IOException {
        // Setup
        ObjectMapper objectMapper = new ObjectMapper();
        WriteRequestDTO requestDTO = objectMapper.readValue(new File("/Users/gurki/Documents/intellij-workspace/multiLinguify_Backend/src/main/resources/testData/SampleWriteRequestDTO.json"), WriteRequestDTO.class);
        System.out.println(requestDTO.toString());

//        ByteString imgBytes = "";
          ByteString expectedImageBytes = ByteString.copyFrom(Base64.getDecoder().decode(requestDTO.getDrawnImage()));
//        System.out.println("image byte in Test are --"+ imgBytes);
        when(base64DecoderMock.stringDecoder(requestDTO.getDrawnImage())).thenReturn(expectedImageBytes);

        // Create a mock response for the Vision API
        Symbol symbol = Symbol.newBuilder().setText("म").setConfidence(0.9f).build();
        Word word = Word.newBuilder().addSymbols(symbol).build();
        Paragraph paragraph = Paragraph.newBuilder().addWords(word).build();
        Block block = Block.newBuilder().addParagraphs(paragraph).build();
        Page page = Page.newBuilder().addBlocks(block).build();
        TextAnnotation annotation = TextAnnotation.newBuilder().addPages(page).build();
        AnnotateImageResponse mockImageResponse = AnnotateImageResponse.newBuilder().setFullTextAnnotation(annotation).build();
        List<AnnotateImageResponse> responses = List.of(mockImageResponse);
        BatchAnnotateImagesResponse mockBatchResponse = BatchAnnotateImagesResponse.newBuilder().addAllResponses(responses).build();

        imageAnnotatorClientMock = mock(ImageAnnotatorClient.class);
        when(imageAnnotatorClientMock.batchAnnotateImages(anyList())).thenReturn(mockBatchResponse);

        // Execute
        WriteResponseDTO responseDTO = service.writerecognize(requestDTO);

        System.out.println(responseDTO);

        // Verify
        assertNotNull(responseDTO);
        assertEquals("म", responseDTO.getCharacter());
//        assertEquals(0.9d, responseDTO.getPercentageAccuracy());
        assertEquals("", responseDTO.getError());
    }

    @Test
    void testpopulateCorrectResponse()
    {
       WriteResponseDTO expectedResponseDTO = new WriteResponseDTO();

       WriteResponseDTO actualRespondTO = new WriteResponseDTO("",5.3d,"some error");

       String errorString = "some error";

        service.populateErrorResponse(expectedResponseDTO, errorString);

        assertEquals(actualRespondTO.getError(),errorString);

     }
    }

