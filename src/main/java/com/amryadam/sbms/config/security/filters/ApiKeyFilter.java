package com.amryadam.sbms.config.security.filters;

import com.amryadam.sbms.config.security.authentication.ApiKeyAuthentication;
import com.amryadam.sbms.config.security.mangers.CustomerAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final CustomerAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. create an authentication object which is not yet authenticated
        // 2. delegate the authentication object to the manager
        // 3. get back the authentication from the manager
        // 4. if the object is authenticated then send request to the next filter in the chain
        String requestKey = request.getHeader("key");

        if (request == null || "null".equals(requestKey)) {
            filterChain.doFilter(request, response);
        }

        var auth = new ApiKeyAuthentication(false, requestKey);


        try {
            var manager = customAuthenticationManager.authenticate(auth);
            if (manager.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(manager);
                filterChain.doFilter(request, response); // only when authentication work
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }
}
