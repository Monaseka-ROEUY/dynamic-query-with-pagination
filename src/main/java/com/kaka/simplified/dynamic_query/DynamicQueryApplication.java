package com.kaka.simplified.dynamic_query;

import com.kaka.simplified.dynamic_query.service.FootballPlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DynamicQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicQueryApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(FootballPlayerService footballPlayerService) {
        return args -> {

        };
    }
}
