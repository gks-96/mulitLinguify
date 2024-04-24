package com.pl.controller.implementation;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("api/hi")
    public String helloWorld()
    {
        return "Hello World";
    }

    @PostMapping("api/hi")
    public String helloWorld(@RequestBody Map<String,String> imageDTO)
    {
        System.out.println(imageDTO);
        return "Hello " ;
    }

}
