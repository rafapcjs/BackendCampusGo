package com.unicartagena.CampusGo.security.config;

import com.unicartagena.CampusGo.security.utils.jwt.JwtTokenValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenValidator jwtTokenValidator;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(http -> {

                    // Endpoints públicos
                    http.requestMatchers(HttpMethod.POST, "/api/v1/auth/sign-up").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll();

                    // Endpoints Swagger
                    http.requestMatchers(
                            "/swagger-ui/**",
                            "/swagger-ui.html",
                            "/v3/api-docs/**",
                            "/v3/api-docs.yaml",
                            "/v3/api-docs.json"
                            ,"/"
                    ).permitAll();

                    // Endpoints solo para TEACHER
                    http.requestMatchers("/teacher/**").hasRole("TEACHER");

                    // Endpoints solo para STUDENT
                    http.requestMatchers("/student/**").hasRole("STUDENT");

                    // Endpoints accesibles por TEACHER y STUDENT
                    http.requestMatchers("/common/**").hasAnyRole("TEACHER", "STUDENT");

                    // Cualquier otra petición requiere autenticación
                    http.anyRequest().authenticated();
                })

                .addFilterBefore(jwtTokenValidator, BasicAuthenticationFilter.class)
                .build();
    }
}