package br.com.fiap.bombview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
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
