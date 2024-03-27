package com.example.projetoBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ProjetoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBankApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home() {
		return "Projeto Bank - Integrantes Igor Miguel Silva RM99495 João Pedro Costa Feitosa RM98442";
	}
}
