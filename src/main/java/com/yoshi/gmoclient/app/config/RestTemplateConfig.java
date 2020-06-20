package com.yoshi.gmoclient.app.config;

import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.springframework.security.core.context.*;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.authentication.*;
import org.springframework.web.client.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(OAuth2AuthorizedClientService clientService) {
        return new RestTemplateBuilder()
                .interceptors((httpRequest, bytes, execution) -> {
                    OAuth2AuthenticationToken token =
                            (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

                    OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
                            token.getAuthorizedClientRegistrationId(),
                            token.getName());
                    httpRequest.getHeaders().add(AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
                    return execution.execute(httpRequest, bytes);
                }).build();
    }
}
