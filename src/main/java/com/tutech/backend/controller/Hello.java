package com.tutech.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {
    @GetMapping("/hello")
    public static String hello() {
        return "hello";
    }


}
