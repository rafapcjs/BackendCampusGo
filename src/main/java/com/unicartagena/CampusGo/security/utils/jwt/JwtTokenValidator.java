package com.unicartagena.CampusGo.security.utils.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.unicartagena.CampusGo.security.utils.constants.AuthConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



@Component
@RequiredArgsConstructor
public class JwtTokenValidator extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el token del encabezado de autorización
        String jwtToken = request.getHeader(AuthConstants.AUTHORIZATION_HEADER);

        if (jwtToken != null && jwtToken.startsWith(AuthConstants.BEARER_PREFIX)) {
            try {
                // Elimina el prefijo "Bearer "
                jwtToken = jwtToken.substring(AuthConstants.BEARER_PREFIX.length());

                // Valida el token
                DecodedJWT decodedJWT = jwtTokenProvider.validateToken(jwtToken);
                String username = jwtTokenProvider.extractUsername(decodedJWT);

                // Crea un contexto de seguridad solo si el usuario es válido
                if (username != null) {
                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, null);
                    context.setAuthentication(authentication);
                    SecurityContextHolder.setContext(context);
                }

            } catch (JWTVerificationException e) {
                // Captura y maneja errores de verificación, pero permite que el request continúe
                logger.warn("Token JWT no válido: " + e.getMessage());
            }
        }

        // Continúa la cadena de filtros
        filterChain.doFilter(request, response);
    }
}