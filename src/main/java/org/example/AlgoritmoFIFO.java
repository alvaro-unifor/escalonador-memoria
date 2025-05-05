package org.example;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoFIFO {
    private List<Pagina> paginas;
    private int capacidade;

    public AlgoritmoFIFO(int capacidade) {
        this.capacidade = capacidade;
        this.paginas = new ArrayList<>();
    }

    public int simular(int[] referencias) {
        int faltasDePagina = 0;

        for (int ref : referencias) {
            if (!contem(ref)) {
                faltasDePagina++;
                adicionar(ref);
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
}