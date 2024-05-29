package com.mulitLinguify.utilities;

import java.util.HashMap;

public class LanguageMapper {

    // key is what we receive from the front-end
    // value is what we pass in the api calls

       static  HashMap<String,String> map = new HashMap<>();
        static {
            map.put("punjabi","pa-Guru-IN");
            map.put("english","en-US");
            map.put("hindi","hi-IN");
        }

        public static String getLanguage(String key)
        {
            if ( map.containsKey(key))
            {
                return map.get(key);
            }
            return "";
        }

}
