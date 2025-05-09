package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] referencias = {1, 3, 0, 3, 5, 6, 3, 0, 1, 5}; // sequência de páginas acessadas
        int quadros = 3; // número de quadros na memória +++++++

        // Algoritmo do Relógio (existente)
        AlgoritmoRelogio relogio = new AlgoritmoRelogio(quadros);
        System.out.println("Relógio: " + relogio.simular(referencias) + " faltas de página");

        // Algoritmo FIFO
        AlgoritmoFIFO fifo = new AlgoritmoFIFO(quadros);
        System.out.println("FIFO: " + fifo.simular(referencias) + " faltas de página");

        // Algoritmo LRU
        AlgoritmoLRU lru = new AlgoritmoLRU(quadros);
        System.out.println("LRU: " + lru.simular(referencias) + " faltas de página");

        // Algoritmo NFU (substitui o Ótimo)
        AlgoritmoNFU nfu = new AlgoritmoNFU(quadros);
        System.out.println("NFU: " + nfu.simular(referencias) + " faltas de página");

//        Relógio: 9 faltas de página
//        FIFO: 9 faltas de página
//        LRU: 8 faltas de página
//        NFU: 8 faltas de página





    }
}