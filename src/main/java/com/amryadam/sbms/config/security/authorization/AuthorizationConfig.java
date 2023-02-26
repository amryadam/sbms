package com.amryadam.sbms.config.security.authorization;

import com.amryadam.sbms.config.security.filters.ApiKeyFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@AllArgsConstructor
public class AuthorizationConfig {

    private final ApiKeyFilter apiKeyFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .addFilterAt(apiKeyFilter, BasicAuthenticationFilter.class)
//                .csrf(csrfConfigurer -> csrfConfigurer.disable())
//                .authorizeRequests(auth -> {
//                    auth.anyRequest().authenticated();
//                })
//                .httpBasic();
//
//        return http.build();
//
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
                .and()
                .addFilterBefore(apiKeyFilter, BasicAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()   // authorization
                //.and().authenticationManager()   or  by adding a bean of type AuthenticationManager
                //.and().authenticationProvider() it doesn't override the AP, it adds one more to the collection
                .and().build();
    }
}
