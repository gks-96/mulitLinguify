package com.mulitLinguify.utilities;

import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Decoder {



    public ByteString stringDecoder(String encodedString)
    {
//        System.out.println("inside stringDecoder");
        byte[] decodedBytesCorrectImage =   null ;

//        System.out.println("bytes image is  -- "+ decodedBytesCorrectImage);
        try {
//        ByteString imgBytes = null ;

            decodedBytesCorrectImage=   Base64.getDecoder().decode(encodedString);
            ByteString imgBytes = ByteString.copyFrom(decodedBytesCorrectImage) ;
//            System.out.println("img bytes are ---"+imgBytes) ;
            return imgBytes;
//            System.out.println("Img bytes are --" + imgBytes);
        }
         catch (Exception e) {
             System.out.println(e.getMessage());
//             System.out.println("error caught"+ e.getMessage());
         }
//        System.out.println("img bytes are -- " + imgBytes);
        return null;
    }
}
