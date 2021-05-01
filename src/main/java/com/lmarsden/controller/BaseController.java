package com.lmarsden.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "The current time is " + LocalDateTime.now();
    }

    @GetMapping("/secret")
    public String secret() {
        return "You found the secret page!";
    }
}
