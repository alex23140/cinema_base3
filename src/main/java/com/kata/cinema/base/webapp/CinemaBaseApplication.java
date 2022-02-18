package com.kata.cinema.base.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.kata.cinema.base"})
@EntityScan("com.kata.cinema.base.models")
@EnableTransactionManagement
@EnableSwagger2
public class CinemaBaseApplication {


    public static void main(String[] args) {
        SpringApplication.run(CinemaBaseApplication.class, args);
    }
}
