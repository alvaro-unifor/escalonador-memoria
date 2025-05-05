package org.example;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoLRU {
    private List<Pagina> paginas;
    private int capacidade;

    public AlgoritmoLRU(int capacidade) {
        this.capacidade = capacidade;
        this.paginas = new ArrayList<>();
    }

    public int simular(int[] referencias) {
        int faltasDePagina = 0;

        for (int ref : referencias) {
            if (!contem(ref)) {
                faltasDePagina++;
                adicionar(ref);
            } else {
                atualizarPosicao(ref);
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
        } else {
            paginas.remove(0);
            paginas.add(new Pagina(valor));
        }
    }

    private void atualizarPosicao(int valor) {
        Pagina paginaAtual = null;
        for (Pagina pagina : paginas) {
            if (pagina.getValor() == valor) {
                paginaAtual = pagina;
                break;
            }
        }
        if (paginaAtual != null) {
            paginas.remove(paginaAtual);
            paginas.add(paginaAtual);
        }
    }
}