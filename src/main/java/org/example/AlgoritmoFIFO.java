package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class AlgoritmoFIFO {
    private int quadros;

    public AlgoritmoFIFO(int quadros) {
        this.quadros = quadros;
    }

    public int simular(int[] referencias) {
        Queue<Integer> fila = new LinkedList<>();
        Set<Integer> naMemoria = new HashSet<>();
        int faltas = 0;
        
        for (int pagina : referencias) {
            if (!naMemoria.contains(pagina)) {
                faltas++;
                if (fila.size() == quadros) {
                    int maisAntiga = fila.poll();
                    naMemoria.remove(maisAntiga);
                }
                fila.add(pagina);
                naMemoria.add(pagina);
            }
        }
        return faltas;
    }
}