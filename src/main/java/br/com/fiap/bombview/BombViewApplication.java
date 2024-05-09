package br.com.fiap.bombview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
	
@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "BomBView",
		version = "1.0",
		summary = "API do site de reviews BomBView"
	)
)
public class BombViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BombViewApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Bem-vindo(a) ao BomBView!";
	}
}
