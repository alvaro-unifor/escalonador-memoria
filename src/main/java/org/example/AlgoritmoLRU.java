package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlgoritmoLRU {
    private int quadros;

    public AlgoritmoLRU(int quadros) {
        this.quadros = quadros;
    }

    public int simular(int[] referencias) {
        LinkedHashMap<Integer, Boolean> cache = new LinkedHashMap<>(quadros, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Boolean> maisAntiga) {
                return size() > quadros;
            }
        };
        int faltas = 0;
        
        for (int pagina : referencias) {
            if (!cache.containsKey(pagina)) {
                faltas++;
            }
            cache.put(pagina, true);
        }
        return faltas;
    }
}