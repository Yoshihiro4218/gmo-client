package com.yoshi.gmoclient.app.controller;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.authentication.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {
    private final RestTemplate restTemplate;

    @GetMapping("/home")
    public String home(OAuth2AuthenticationToken token,
                       Model model) {
        log.info("Token->{}", token);
        model.addAttribute("email", token.getPrincipal()
                                         .getAttributes().get("email"));
        ResponseEntity<String> res = restTemplate.getForEntity("https://api.sunabar.gmo-aozora.com/personal/v1/accounts",
                                                               String.class);
        log.info("RES->{}", res);
        return "pages/home";
    }
}
