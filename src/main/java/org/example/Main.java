package org.example;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] referencias = {1, 3, 0, 3, 5, 6, 3, 0, 1, 5}; // sequência de páginas acessadas
        AlgoritmoRelogio relogio = new AlgoritmoRelogio(3); // 3 quadros na memória

        int faltas = relogio.simular(referencias);
        System.out.println("Faltas de página: " + faltas);
    }
}