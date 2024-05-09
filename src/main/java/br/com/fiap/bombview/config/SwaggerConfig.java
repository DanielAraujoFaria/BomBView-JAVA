package br.com.fiap.bombview.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{
    @Bean
    public OpenAPI customAPI(){

            return new OpenAPI().info(new Info().title("Swagger Example API").version("1.0.0")
                .license(new License().name("Lincença do Sistema").url("www.techdevbrazil.com"))
        );
    }
}
