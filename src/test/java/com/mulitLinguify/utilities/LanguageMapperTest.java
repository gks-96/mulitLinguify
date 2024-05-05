package com.mulitLinguify.utilities;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LanguageMapperTest {


    @Autowired
    LanguageMapper mapper = new LanguageMapper();


    String inputLanguage  = "pan";
    String expectedLanguage ="pa-Guru-IN";



    @org.junit.jupiter.api.Test
    void getLanguageWhenExists()
    {
        System.out.println(mapper.map);
      assertEquals(expectedLanguage,mapper.getLanguage(inputLanguage));
    }

    @org.junit.jupiter.api.Test
    void getLanguageWhenDoesNoExists()
    {
          inputLanguage = "pun";  // testing when language does not exists
        String expectedLanguage="";
        assertEquals(expectedLanguage,mapper.getLanguage(inputLanguage));
    }
}

