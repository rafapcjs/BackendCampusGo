package com.unicartagena.CampusGo.commons.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Configuración de Swagger/OpenAPI para la documentación de la API de Campus GO.
 *
 * <p>
 * Este archivo define la información general del proyecto, incluyendo el equipo de desarrollo,
 * los términos de uso, la universidad y los servidores disponibles.
 * </p>
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Campus GO - API de Gestión Académica 📚",
                description = "API REST para la gestión académica integral: estudiantes, materias, matrículas, docentes y más.",
                termsOfService = "mailto:campusgo.soporte@gmail.com",
                version = "1.0.0",
                contact = @Contact(
                        name = "John Morales, Rafael Corredor y Nelson Ruiz",
                        url = "https://www.unicartagena.edu.co",
                        email = "campusgo.soporte@gmail.com"
                ),
                license = @License(
                        name = "Universidad de Cartagena - Proyecto Campus GO",
                        url = "https://www.unicartagena.edu.co"
                )
        ),
        servers = {
                @Server(
                        description = "Swagger UI - Campus GO",
                        url = "https://backendcampusgo-2.onrender.com/swagger-ui/index.html"
                )
        }
)
public class SwaggerConfig {
    // Esta clase no requiere métodos adicionales. La configuración se define mediante anotaciones.
}
