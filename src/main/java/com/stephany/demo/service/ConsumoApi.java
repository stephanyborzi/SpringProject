package com.stephany.demo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi
{
    public String obterDados(String endereco) {
        /* o metodo cria um cliente HTTP para enviar as requisicoes */
        HttpClient client = HttpClient.newHttpClient();
        /* o metodo constroi uma requisicao HTTP com o endereco fornecido */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        /* a requisicao é mandada para a web */
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e)/* erro de entrada ou saida */ {
            throw new RuntimeException(e);
        } catch (InterruptedException e) /* erro de interrupcao */ {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
