package org.example;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoNFU {
    private List<Pagina> paginas;
    private int capacidade;
    private int[] contadorUso;

    public AlgoritmoNFU(int capacidade) {
        this.capacidade = capacidade;
        this.paginas = new ArrayList<>();
        this.contadorUso = new int[capacidade];
    }

    public int simular(int[] referencias) {
        int faltasDePagina = 0;

        for (int ref : referencias) {
            if (!contem(ref)) {
                faltasDePagina++;
                adicionar(ref);
            } else {
                for (int i = 0; i < paginas.size(); i++) {
                    if (paginas.get(i).getValor() == ref) {
                        contadorUso[i]++;
                        break;
                    }
                }
            }
        }

        return faltasDePagina;
    }

    private boolean contem(int valor) {
        for (Pagina pagina : paginas) {
            if (pagina.getValor() == valor) {
                return true;
            }
        }
        return false;
    }

    private void adicionar(int valor) {
        if (paginas.size() < capacidade) {
            paginas.add(new Pagina(valor));
            contadorUso[paginas.size() - 1] = 1;
        } else {
            int indiceMenorUso = encontrarMenorUso();
            paginas.set(indiceMenorUso, new Pagina(valor));
            contadorUso[indiceMenorUso] = 1;
        }
    }

    private int encontrarMenorUso() {
        int menorUso = Integer.MAX_VALUE;
        int indiceMenorUso = -1;

        for (int i = 0; i < paginas.size(); i++) {
            if (contadorUso[i] < menorUso) {
                menorUso = contadorUso[i];
                indiceMenorUso = i;
            }
        }

        return indiceMenorUso;
    }
}