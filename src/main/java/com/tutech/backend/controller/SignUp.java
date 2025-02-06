package com.tutech.backend.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUp {
    @PostMapping
    public String signUp(@RequestBody String a) {return null;}
    @PostMapping("/checkId")
    public String checkId(@RequestBody String a) {return null;}
}
