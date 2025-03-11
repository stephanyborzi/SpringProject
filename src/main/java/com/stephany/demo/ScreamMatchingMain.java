package com.stephany.demo;

import com.stephany.demo.model.DadosSerie;
import com.stephany.demo.service.ConsumoApi;
import com.stephany.demo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreamMatchingMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreamMatchingMain.class, args);
	}

	@Override

	public void run (String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}

}
