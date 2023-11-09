package com.example.simpleStore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Hanspeter",
            email =  "contactdevhanspeter@gmail.com"

        ),
        description = "OpenApi Documentação para Projeto ",
        title= "OpenApi Especificação - Hanspeter",
        version = "1.0",
        license = @License (
            name = "Licence Hanspeter ",
            url = "https://github.com/hanspeterdietiker/"
        ),
        termsOfService = "Termos de Serviço"
    ),
        servers = {
            @Server(
                description = "Server Local",
                url = "http://localhost/8080"
            )
        }
        
)

public class OpenApiConfig {
    
}
