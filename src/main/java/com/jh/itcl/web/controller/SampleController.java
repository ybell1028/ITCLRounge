package com.jh.itcl.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController{
    @GetMapping("/")
    public String home(){
        return "hello world!";
    }
}