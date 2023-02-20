package com.drone.dronedeliverysystem.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class ApplicationApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .version("1.0.0")
                        .title("Drone Deliver Service")
                        .description("Documentation for  Drone Delivery System APIs. "));
    }
}
