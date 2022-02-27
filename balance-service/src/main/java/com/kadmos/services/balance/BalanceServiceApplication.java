package com.kadmos.services.balance;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Balance API", version = "1.0", description = "Documentation for Balance API v1.0")
)
public class BalanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalanceServiceApplication.class, args);
    }

}
