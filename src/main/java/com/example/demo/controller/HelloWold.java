package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWold {

    @RequestMapping("/test1")
    public String test01(){
        return "hello world!";
    }

}
