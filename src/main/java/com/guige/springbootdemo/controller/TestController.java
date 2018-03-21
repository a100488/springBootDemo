package com.guige.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @GetMapping("/helloworld2")
    public String helloworld2() {
        return "helloworld2";
    }
}