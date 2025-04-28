package org.example;


public interface ListaEncadeada<T> {

    void adicionar(T elemento);


    boolean remover(T elemento);


    boolean contem(T elemento);

    int tamanho();

    boolean estaVazia();

    void limpar();
}
