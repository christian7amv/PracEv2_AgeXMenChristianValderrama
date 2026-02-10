/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos;

/**
 *
 * @author chris
 */
public interface Gestionar {
    void verResumido();

    void verCompleto();

    void añadirUno(Object obj);

    void borrarUno(Object obj);

    void editarUno(Object obj);

    void vaciar();
}
