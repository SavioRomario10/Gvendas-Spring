package com.gvendas.gestao_vendas.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API Gestão de Vendas",
        version = "1.0",
        description = "Documentação da API de Gestão de Vendas"
    )
)
public class OpenApiConfig {
}
