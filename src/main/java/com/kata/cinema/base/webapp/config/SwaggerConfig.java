package com.kata.cinema.base.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

//    http://localhost:5557/swagger-ui/#/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All")
                .select()
                .apis (RequestHandlerSelectors.basePackage ("com.kata.cinema.base.webapp.controllers")) // Пакет сканирования Swagger
                .paths(PathSelectors.any())
                .build();
    }

}


