package org.example;

public class Pagina {

    private Integer valor;

    private Pagina proximo;

    private int bitUso;

    public Pagina(int valor) {
        this.valor = valor;
        this.bitUso = 1;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Pagina getProximo() {
        return proximo;
    }

    public void setProximo(Pagina proximo) {
        this.proximo = proximo;
    }

    public int getBitUso() {
        return bitUso;
    }

    public void setBitUso(int bitUso) {
        this.bitUso = bitUso;
    }
}
