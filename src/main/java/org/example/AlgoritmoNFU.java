package org.example;

import java.util.HashMap;
import java.util.Map;

public class AlgoritmoNFU {
    private int quadros;
    private Map<Integer, Integer> contadorUso;

    public AlgoritmoNFU(int quadros) {
        this.quadros = quadros;
        this.contadorUso = new HashMap<>();
    }

    public int simular(int[] referencias) {
        Map<Integer, Integer> memoria = new HashMap<>(); // Páginas na memória e seus contadores
        int faltas = 0;

        for (int pagina : referencias) {
            // Incrementa o contador para a página referenciada
            contadorUso.put(pagina, contadorUso.getOrDefault(pagina, 0) + 1);

            if (!memoria.containsKey(pagina)) {
                faltas++;
                
                if (memoria.size() >= quadros) {
                    // Encontra a página com menor contador para substituir
                    int paginaSubstituir = memoria.entrySet().stream()
                            .min(Map.Entry.comparingByValue())
                            .get().getKey();
                    
                    memoria.remove(paginaSubstituir);
                }
                
                // Adiciona a nova página com seu contador atual
                memoria.put(pagina, contadorUso.get(pagina));
            } else {
                // Atualiza o contador na memória
                memoria.put(pagina, contadorUso.get(pagina));
            }
        }
        return faltas;
    }
}