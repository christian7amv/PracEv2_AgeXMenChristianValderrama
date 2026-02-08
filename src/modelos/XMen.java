/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author chris
 */
public class XMen extends Persona implements Superpoder {

    private String fraseTipica;
    private boolean esAnonimo;
    private boolean usaArtefactos;

    public XMen(String fraseTipica, boolean esAnonimo, boolean usaArtefactos) {
        this.fraseTipica = fraseTipica;
        this.esAnonimo = esAnonimo;
        this.usaArtefactos = usaArtefactos;
    }

    public XMen(String fraseTipica, boolean esAnonimo, boolean usaArtefactos, String nombre, int edad) {
        super(nombre, edad);
        this.fraseTipica = fraseTipica;
        this.esAnonimo = esAnonimo;
        this.usaArtefactos = usaArtefactos;
    }

    public XMen(String fraseTipica, boolean esAnonimo, boolean usaArtefactos, String nombre, int edad, float altura, Sexo sexo) {
        super(nombre, edad, altura, sexo);
        this.fraseTipica = fraseTipica;
        this.esAnonimo = esAnonimo;
        this.usaArtefactos = usaArtefactos;
    }

    public String getFraseTipica() {
        return fraseTipica;
    }

    public void setFraseTipica(String fraseTipica) {
        this.fraseTipica = fraseTipica;
    }

    public boolean isEsAnonimo() {
        return esAnonimo;
    }

    public void setEsAnonimo(boolean esAnonimo) {
        this.esAnonimo = esAnonimo;
    }

    public boolean isUsaArtefactos() {
        return usaArtefactos;
    }

    public void setUsaArtefactos(boolean usaArtefactos) {
        this.usaArtefactos = usaArtefactos;
    }

    public void decirFraseLlegada() {
        System.out.println("El mutante aparece diciendo: " + this.fraseTipica);
    }

    public void salvar(Civil civil) {
        System.out.println(this.nombre + " rescata al ciudadano " + civil.getNombre());
    }

    public void salvar(XMen compañero) {
        System.out.println(this.nombre + " apoya en combate a " + compañero.getNombre());
    }

    @Override
    public void presentarInfo() {
        System.out.println("Nombre: " + (esAnonimo ? "DESCONOCIDO" : nombre));
        System.out.println("Edad: " + edad);
        System.out.println("Usa artefactos: " + (usaArtefactos ? "Sí" : "No"));
        System.out.println("Frase: " + fraseTipica);
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está surcando los cielos.");
    }

    @Override
    public void superVelocidad() {
        System.out.println(nombre + " se mueve más rápido que la luz.");
    }

    @Override
    public void superFuerza() {
        System.out.println(nombre + " ha levantado un tanque con una mano.");
    }

}
