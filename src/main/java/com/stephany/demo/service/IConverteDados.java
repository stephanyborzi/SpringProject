package com.stephany.demo.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
    /*<T> é um generics. Ele representa que eu tenho que dar algum tipo de saida ao
    metodo obter dados*/
}
