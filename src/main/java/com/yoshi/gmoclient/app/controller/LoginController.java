package com.yoshi.gmoclient.app.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }
}
