package org.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Yorushika desu!!!", version = "1.0", description = "Products Information"))
public class FirstRestApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstRestApiSpringApplication.class, args);
    }

}
