package com.pl.service.impl;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;


import com.pl.dto.WriteRequestDTO;
import com.pl.dto.WriteResponseDTO;
import com.pl.util.Base64Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class DetectText {


    @Autowired

    Base64Decoder base64Decoder;
    /**
     * character,
     * percentage accuracy
     * get :200
     * error :

     * @param encodedString
     * @return
     * @throws IOException
     */
    public  WriteResponseDTO detectDocumentText(String encodedString) throws IOException {
        ArrayList<WriteRequestDTO> temp = new ArrayList<>();

        List<AnnotateImageRequest> requests = new ArrayList<>();

        WriteResponseDTO imageResponseDTO = new WriteResponseDTO();

        System.out.println("encoded string --" + encodedString);


        ByteString imgBytes = base64Decoder.imageDecoder(encodedString);

        String result = "";
        ImageContext imageContext = ImageContext.newBuilder().addLanguageHints("pan").build();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).setImageContext(imageContext).build();
        requests.add(request);

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            client.close();
            System.out.println("response request size is -----"  + responses.size());

            for (AnnotateImageResponse res : responses) {

                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
//                    return;
                    imageResponseDTO.setCharacter("");
                    imageResponseDTO.setPercentageAccuracy(0d);
                    imageResponseDTO.setError(res.getError().getMessage());
                }

                else{

                    TextAnnotation annotation = res.getFullTextAnnotation();
                    //                System.out.println("number of pages --" +  annotation.getText());
                    System.out.println("annotation boject is --" + annotation.toString());
                    //                System.out.println("number of pages --" +  annotation.getPagesCount());

                    if ( annotation.getPagesCount() >= 1) {
                        for (Page page : annotation.getPagesList()) {
                            String pageText = "";
                            for (Block block : page.getBlocksList()) {
                                String blockText = "";
                                for (Paragraph para : block.getParagraphsList()) {
                                    String paraText = "";
                                    for (Word word : para.getWordsList()) {
                                        String wordText = "";
                                        for (Symbol symbol : word.getSymbolsList()) {
                                            wordText = wordText + symbol.getText();
                                            System.out.println("hashcode ---" + symbol.hashCode());
                                            System.out.format("Symbol text: %s (confidence: %f)%n" ,
                                                              symbol.getText() ,
                                                              symbol.getConfidence());
                                            result = symbol.getText();
                                            imageResponseDTO.setCharacter(symbol.getText());
                                            imageResponseDTO.setPercentageAccuracy((double) symbol.getConfidence());
                                            imageResponseDTO.setError("");
                                            break;
                                        }
                                        System.out.format("Word text: %s (confidence: %f)%n%n" ,
                                                          wordText ,
                                                          word.getConfidence());
                                        paraText = String.format("%s %s" ,
                                                                 paraText ,
                                                                 wordText);
                                    }
                                    // Output Example using Paragraph:
                                    System.out.println("%nParagraph: %n" + paraText);
                                    System.out.format("Paragraph Confidence: %f%n" ,
                                                      para.getConfidence());
                                    blockText = blockText + paraText;
                                }
                                pageText = pageText + blockText;
                            }
                        }
                    }
                    else{
                        imageResponseDTO.setCharacter("");
                        imageResponseDTO.setPercentageAccuracy(0d);
                        imageResponseDTO.setError("Character is not being recognized");
                    }
                    System.out.println("%nComplete annotation:");
                    System.out.println(annotation.getText());
                    //                return annotation.getText();
                }
                }
                // For full list of available annotations, see http://g.co/cloud/vision/docs

        }
        return imageResponseDTO;
    }


}
