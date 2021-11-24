package com.salesianostriana.dam.Proyecto3SpringSecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JWTAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .exceptionHandling()
                        .authenticationEntryPoint(authenticationEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler)
                .and()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                        .antMatchers(HttpMethod.POST, "/auth/register/gestor", "inmobiliaria").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/auth/register/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/propietario").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/propietario/{id}").hasAnyRole("ADMIN", "PROPIETARIO")
                .antMatchers(HttpMethod.DELETE, "/propietario/{id}").hasAnyRole("ADMIN", "PROPIETARIO")
                .antMatchers(HttpMethod.POST, "/vivienda").hasRole("PROPIETARIO")
                .antMatchers(HttpMethod.GET, "/vivienda").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/vivienda/{id}").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/vivienda/{id}").hasAnyRole("PROPIETARIO", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/vivienda/{id}").hasAnyRole("PROPIETARIO", "ADMIN")
                .antMatchers(HttpMethod.POST, "/vivienda/{id}/inmobiliaria/{id}").hasAnyRole("PROPIETARIO", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/vivienda/{id}/inmobiliaria").hasAnyRole("ADMIN", "PROPIETARIO", "GESTOR")
                .antMatchers(HttpMethod.POST, "/inmobiliaria/{id}/gestor").hasAnyAuthority("ADMIN", "GESTOR")
                .antMatchers(HttpMethod.DELETE, "/inmobiliaria/gestor/{id}").hasAnyRole("ADMIN", "GESTOR")
                .antMatchers(HttpMethod.GET, "/inmobiliaria/gestor").hasAnyRole("ADMIN", "GESTOR")
                .antMatchers(HttpMethod.GET, "/inmobiliaria").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/inmobiliaria/{id}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/inmobiliaria/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/vivienda/{id}/meinteresa").hasRole("PROPIETARIO")
                .antMatchers(HttpMethod.DELETE, "/vivienda/{id}/meinteresa").hasAnyRole("ADMIN", "PROPIETARIO")
                .antMatchers(HttpMethod.GET, "/interesado").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/interesado/{id}").hasAnyRole("ADMIN", "PROPIETARIO")
                .antMatchers(HttpMethod.GET, "/vivienda/top?n=10").hasRole("USER")
                    .and();
    }
}