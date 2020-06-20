package com.yoshi.gmoclient.app.config;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.client.oidc.web.logout.*;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.security.web.util.matcher.*;

import java.net.*;
import java.util.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientRegistrationRepository clientRegistrationRepository;
    private final Environment environment;

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        @formatter:off
        http
            .authorizeRequests()
            .antMatchers("/login**").permitAll()
            .antMatchers( "/favicon.ico").permitAll()
            .anyRequest().authenticated();

        http
            .oauth2Login()
            .defaultSuccessUrl("/home");

        http
            .csrf()
            .ignoringAntMatchers("/**");

        http
            .logout()
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessHandler(oidcLogoutSuccessHandler())
            .deleteCookies("JSESSIONID").permitAll();

//        @formatter:on
    }

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler handler
                = new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
        handler.setPostLogoutRedirectUri(URI.create(Objects.requireNonNull(environment.getProperty("auth2.post-logout-redirect-uri"))));
        return handler;
    }
}
