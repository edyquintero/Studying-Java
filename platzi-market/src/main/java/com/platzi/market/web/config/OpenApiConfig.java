package com.platzi.market.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Platzi Market API")
                        .version("1.0")
                        .description("Documentación de la API de Platzi Market"));
    }

    //URL: http://localhost:8090/platzi-market/api/swagger-ui/index.html#/
}
