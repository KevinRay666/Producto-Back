package com.productos.producto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.GET, "/api/v1/products").hasAnyRole("lectura", "admin")
                    .requestMatchers(HttpMethod.GET, "/api/v1/products/**").hasAnyRole("lectura","admin")
                        .requestMatchers(HttpMethod.POST, "/api/v1/products").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/products/**").hasRole("admin")
                        .requestMatchers("/api/v1/products/**").authenticated()
                        .anyRequest().permitAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
