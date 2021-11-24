package com.salesianostriana.dam.Proyecto3SpringSecurity.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType("aplication/json");

        /* Preguntar a luismi por este error*/
        Map<String, String> mensajes =
                Map.of("mensaje", authException.getMessage());

        String strjson = mapper.writeValueAsString(mensajes);

        httpServletResponse.getWriter().println(strjson);

    }
}
