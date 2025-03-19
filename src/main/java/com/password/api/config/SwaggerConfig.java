package com.password.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Password Validation API")
                        .version("1.0.0")
                        .description("API for password validation following security criteria"))
                .addServersItem(new Server().url("http://localhost:8080").description("Local server"));
    }
}
