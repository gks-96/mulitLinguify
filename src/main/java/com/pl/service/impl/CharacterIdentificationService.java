package com.pl.service.impl;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Service
public class CharacterIdentificationService {


    public  String recognizingCharacter(String correctImageDecoded, String drawnImageDecoded) throws  IOException {

        System.out.println("decoded image is " + correctImageDecoded);
        tesseract.TessBaseAPI instance = new tesseract.TessBaseAPI();

        if ( instance.Init("src/main/resources/tessdata","pan")!=0 )
        {
            System.out.println("error initializing tesseract");
        }

        byte[] decodedBytesCorrectImage = Base64.getDecoder().decode(correctImageDecoded);
        String decodedString = new String(decodedBytesCorrectImage);
        System.out.println("decoded String is -------"+ decodedString);
//        System.out.println(Arrays.toString(decodedBytesCorrectImage));
//        BytePointer bytePointerInputCorrectImage = new BytePointer(decodedBytesCorrectImage);
//        lept.PIX correctImage = lept.pixReadMem(bytePointerInputCorrectImage,decodedBytesCorrectImage.length);
//        instance.SetImage(correctImage);
//        BytePointer bytePointerCorrectOutput = instance.GetUTF8Text();
//        String correctPrediction = bytePointerCorrectOutput.getString();
//        System.out.println("correct prediction is " + correctPrediction);

        byte[] decodedBytesPredictedImage = Base64.getDecoder().decode(drawnImageDecoded);
        System.out.println(Arrays.toString(decodedBytesPredictedImage));
        BytePointer bytePointerInputPredictedImage = new BytePointer(decodedBytesPredictedImage);
        lept.PIX predictedImage = lept.pixReadMem(bytePointerInputPredictedImage,decodedBytesPredictedImage.length);
        instance.SetImage(predictedImage);
        BytePointer bytePointerDrawnOutput = instance.GetUTF8Text();
        String drawnPrediction = bytePointerDrawnOutput.getString();
        System.out.println("predicted Image   is " + drawnPrediction);

//        String predictedImageDecoded = new String(decodedBytesPredictedImage);
//        System.out.println("predicted image decoded is ---"+predictedImageDecoded);

//        return "TRUE";

        return decodedString.equals(drawnPrediction)? "TRUE":"FALSE";
    }



}
