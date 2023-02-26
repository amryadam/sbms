//package com.amryadam.sbms.config;
//
//import com.amryadam.sbms.services.administration.JpaUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//
//public class SessionConfig {
//    @Autowired
//    private JpaUserDetailsService customUserDetailsService;
//
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    /*
//     AuthenticationManager is the API that defines how Spring Security’s Filters perform authentication.
//     it delegates the authentication work to list of AuthenticationProvider
//
//    */
//
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(customUserDetailsService);
//        authenticationProvider.setPasswordEncoder(encoder);
//
//
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//
//
//
//}
