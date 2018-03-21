package com.guige.springbootdemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping("helloworld")
    public String hello(Map<String,Object> map) {
        
        map.put("msg", "Hello Jsp");
        return "hello";
    }
}