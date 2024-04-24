package com.pl.util;

import java.lang.constant.Constable;
import java.util.HashMap;

public class LanguageMapper {

    // key is what we receive from the front-end
    // value is what we pass in the api calls


       static  HashMap<String,String> map = new HashMap<>();
        static {
            map.put("pan","pa-Guru-IN");
            map.put("en","en-IN");
            map.put("hin","hi-IN");
        }
        

        public static String getLanguage(String key)
        {
            return map.get(key);
        }



}
