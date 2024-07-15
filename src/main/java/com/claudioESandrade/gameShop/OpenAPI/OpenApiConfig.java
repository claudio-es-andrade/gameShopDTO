package com.claudioESandrade.gameShop.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    public OpenApiConfig() {
    }

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(" Game Shop ")
                        .description("Select your favorite game here with us!")
                        .version("1.0"));
    }
}
