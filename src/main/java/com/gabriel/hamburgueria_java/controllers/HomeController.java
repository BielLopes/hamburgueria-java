package com.gabriel.hamburgueria_java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  String home() {
    return "Hello, World!";
  }
  
}
