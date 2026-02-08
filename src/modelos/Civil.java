/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author chris
 */
public class Civil extends Persona {

    public Civil(String nombre, int edad, float altura, Sexo sexo) {
        super(nombre, edad, altura, sexo);
    }

    @Override
    public void presentarInfo() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Mide: "+altura);
        System.out.println("Sexo: "+sexo);
    }

}
