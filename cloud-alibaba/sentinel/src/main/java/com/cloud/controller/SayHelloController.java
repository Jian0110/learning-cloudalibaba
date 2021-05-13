package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello Jian";
    }
}
