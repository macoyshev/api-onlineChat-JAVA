package com.macoyshev.restAPI.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

  @GetMapping("/auth/success")
  public String success() {
    return "home";
  }

  @GetMapping("/auth/login")
  public String login() {
    return "login";
  }
}
