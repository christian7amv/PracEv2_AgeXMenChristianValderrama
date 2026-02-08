/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miLibreria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chris
 */
public class Utiles {

    // ============================
    //  FORMATO Y PRESENTACIÓN
    // ============================
    /**
     * Imprime una línea separadora
     */
    public static void Linea() {
        System.out.println("---------------------------------------");
    }

    /**
     * Imprime un título centrado con líneas arri
     *
     * @param texto
     */
    public static void Titulo(String texto) {
        Linea();
        System.out.println("" + texto.toUpperCase());
        Linea();
    }

    /**
     * Inserta saltos de línea
     *
     * @param n
     */
    static final int NUM_LINEAS = 20;

    public static void LimpiarPantalla() {
        for (int i = 0; i < NUM_LINEAS; i++) {
            System.out.println("");
        }
    }

    /**
     * Pausa hasta que el usuario pulse Enter
     *
     * @throws java.io.IOException
     */
    public static void Pausar() throws IOException {
        System.out.print("Presiona Enter para continuar...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
}
