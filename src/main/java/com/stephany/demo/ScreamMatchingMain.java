package com.stephany.demo;

import com.stephany.demo.model.DadosEpisodio;
import com.stephany.demo.model.DadosSerie;
import com.stephany.demo.model.DadosTemporada;
import com.stephany.demo.service.ConsumoApi;
import com.stephany.demo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
        System.out.println(dados);
        json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
        System.out.println(dadosEpisodio);

        List<DadosTemporada> temporadas = new ArrayList<>();

        DadosTemporada dadosTemporada = null;
        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
            dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
        }
       	temporadas.forEach(System.out::println);
    }

}
