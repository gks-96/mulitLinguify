package com.mulitLinguify.utilities;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LanguageMapperTest {


    @Autowired
    LanguageMapper mapper = new LanguageMapper();


     @Test
    void testLanguageWhenExistsTest()
    {
        String inputLanguage  = "punjabi";
        String expectedLanguage ="pa-Guru-IN";
        System.out.println(LanguageMapper.map);
        assertEquals(expectedLanguage,
                   LanguageMapper.getLanguage(inputLanguage));
    }


    @Test
    void testLanguageWhenDoesNoExistsTest()
    {
        String inputLanguage = "pan";  // testing when language does not exists
//        String expectedLanguage ="pa-Guru-IN";
        String expectedLanguage="";
        assertEquals(expectedLanguage,
                     LanguageMapper.getLanguage(inputLanguage));
    }
}

