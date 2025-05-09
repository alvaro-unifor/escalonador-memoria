package org.example;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoRelogio {
    private List<Pagina> paginas;
    private int capacidade;
    private int ponteiro;

    public AlgoritmoRelogio(int capacidade) {
        this.capacidade = capacidade;
        this.paginas = new ArrayList<>();
        this.ponteiro = 0;
    }

    public int simular(int[] referencias) {
        int faltasDePagina = 0;

        for (int ref : referencias) {
            if (!contem(ref)) {
                faltasDePagina++;
                adicionar(ref);
            } else {
                for (Pagina pagina : paginas) {
                    if (pagina.getValor() == ref) {
                        pagina.setBitUso(1);
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
        } else {
            while (true) {
                Pagina paginaAtual = paginas.get(ponteiro);
                if (paginaAtual.getBitUso() == 0) {
                    paginas.set(ponteiro, new Pagina(valor));
                    ponteiro = (ponteiro + 1) % capacidade;
                    break;
                } else {
                    paginaAtual.setBitUso(0);
                    ponteiro = (ponteiro + 1) % capacidade;
                }
            }
        }
    }
}