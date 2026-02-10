/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author chris
 */
public class ContacXMen implements Comparable<ContacXMen> {

    private Persona persona;
    private String telefono;
    private String email;

    public ContacXMen(Persona persona, String telefono, String email) {
        this.persona = persona;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters necesarios
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void presentarInfoTabulada(int id) {
        // Formato: [ID] NOMBRE TELÉFONO EMAIL usando tabuladores
        System.out.println("[" + id + "]\t" + persona.getNombre() + "\t\t" + this.telefono + "\t" + this.email);
    }

    @Override
    public int compareTo(ContacXMen otro) {
        // Criterio de ordenación natural por nombre
        return this.persona.getNombre().compareToIgnoreCase(otro.getPersona().getNombre());
    }
    @Override
    public String toString() {
        return "ContactoSuperHeroe{" + persona.toString() + ", telefono=" + telefono + ", email=" + email + "}";
    }
}
