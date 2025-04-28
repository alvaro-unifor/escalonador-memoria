package org.example;

public class AlgoritmoRelogio implements ListaEncadeada<Integer> {

    private Pagina ponteiro;
    private int tamanho;
    private int capacidade; // capacidade máxima de quadros (frames) de memória

    public AlgoritmoRelogio(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public void adicionar(Integer elemento) {
        if (tamanho < capacidade) {
            // Ainda tem espaço na memória
            Pagina novaPagina = new Pagina(elemento);
            if (ponteiro == null) {
                ponteiro = novaPagina;
                ponteiro.setProximo(ponteiro); // circular
            } else {
                Pagina ultimo = ponteiro;
                while (ultimo.getProximo() != ponteiro) {
                    ultimo = ultimo.getProximo();
                }
                ultimo.setProximo(novaPagina);
                novaPagina.setProximo(ponteiro);
            }
            tamanho++;
        } else {
            // Memória cheia, aplicar substituição (Relógio)
            while (true) {
                if (ponteiro.getBitUso() == 0) {
                    // Substitui esta página
                    ponteiro.setValor(elemento);
                    ponteiro.setBitUso(1);
                    ponteiro = ponteiro.getProximo();
                    break;
                } else {
                    // Dá segunda chance e avança
                    ponteiro.setBitUso(0);
                    ponteiro = ponteiro.getProximo();
                }
            }
        }
    }

    @Override
    public boolean remover(Integer elemento) {
        // Opcional no contexto de substituição, mas podemos implementar se quiser.
        return false;
    }

    @Override
    public boolean contem(Integer elemento) {
        if (ponteiro == null) return false;
        Pagina atual = ponteiro;
        do {
            if (atual.getValor().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        } while (atual != ponteiro);
        return false;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void limpar() {
        ponteiro = null;
        tamanho = 0;
    }

    public int simular(int[] referencias) {
        int faltasDePagina = 0;
        for (int ref : referencias) {
            if (!contem(ref)) {
                adicionar(ref);
                faltasDePagina++;
            } else {
                // Se já está, só marca o bit de uso como 1
                Pagina atual = ponteiro;
                do {
                    if (atual.getValor().equals(ref)) {
                        atual.setBitUso(1);
                        break;
                    }
                    atual = atual.getProximo();
                } while (atual != ponteiro);
            }
        }
        return faltasDePagina;
    }
}
