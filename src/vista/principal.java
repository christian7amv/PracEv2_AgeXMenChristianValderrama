/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.AgendaXMEN;
import java.io.IOException;
import miLibreria.Utiles;

/**
 *
 * @author chris
 */
public class principal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Utiles.mostrarSecuestro();
        AgendaXMEN.controlAcceso();
        AgendaXMEN.menuProfesor();
    }

}
