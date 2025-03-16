package com.unicartagena.reservationsApi.config.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Configuración de Swagger para la documentación de la API de Reservas.
 *
 * <p>
 * Esta configuración muestra los desarrolladores del proyecto, la universidad y la versión del API.
 * </p>
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Reservas API - Universidad de Cartagena",
                description = "API REST Backend para la gestión de reservas.",
                termsOfService = "reservas.ucartagena@gmail.com",
                version = "1.0.0",
                contact = @Contact(
                        name = "John Morales, Rafael Corredor y Nelson Ruiz",
                        url = "https://www.unicartagena.edu.co",
                        email = "reservas.ucartagena@gmail.com"
                ),
                license = @License(
                        name = "Universidad de Cartagena - Desarrollo de Apps",
                        url = "https://www.unicartagena.edu.co"
                )
        ),
        servers = {
                @Server(
                        description = "Servidor de Desarrollo",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Servidor de Producción",
                        url = "https://reservas.example.com"
                )
        }
)
public class SwaggerConfig {
    // Configuración para Swagger/OpenAPI.
    // No es necesario implementar métodos adicionales.
}
