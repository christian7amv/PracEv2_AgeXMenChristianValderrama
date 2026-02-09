/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import miLibreria.Utiles;

/**
 *
 * @author chris
 */
public class AgendaXMEN {
//---------------------------------------------------------------------------------

//---------------------------------------------------------------------------------
    private static final String USER_VALIDO = "profesorx";
    private static final String PASS_VALIDO = "macarena";

    public static void controlAcceso() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.println("----------------------------------------------------");
        System.out.println("CONTROL DE ACCESO");
        System.out.println("----------------------------------------------------");
        String user;
        String pass;
        int intentos = 3;
        boolean accesoConcedido = false;
        while (intentos > 0 && !accesoConcedido) {
            System.out.print("Introduce usuario: ");
            user = teclado.readLine();

            System.out.print("Introduce contraseña: ");
            pass = teclado.readLine();

            if (user.equalsIgnoreCase(USER_VALIDO) && pass.equalsIgnoreCase(PASS_VALIDO)) {
                accesoConcedido = true;
                System.out.println("\nAcceso concedido.\n");
                Utiles.Pausar();
                Utiles.LimpiarPantalla();
                menuProfesor();
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas.");
                System.out.println("Intentos restantes: " + intentos + "\n");
            }
        }

        if (!accesoConcedido) {
            System.out.println("Acceso bloqueado. Demasiados intentos fallidos.");
        }
    }
//-----------------------------------------------------------------------------------

    public static void menuProfesor() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        int opcionMenu;

        do {
            mostrarMenu();
            opcionMenu = leerOpcion(teclado);
            switchMenu(opcionMenu);
        } while (opcionMenu != 0);
    }

    private static void mostrarMenu() {
        System.out.println("====================================================");
        System.out.println("\tAGENDA DE CONTACTOS DE XMEN");
        System.out.println("====================================================");
        System.out.println("1. Ver agenda resumida");
        System.out.println("2. ver agenda completa");
        System.out.println("3. Importar XMen de confianza");
        System.out.println("4. Añadir XMen datos básicos");
        System.out.println("5. Editar XMen por nombre");
        System.out.println("6. Buscar Superhéroe por número de posición");
        System.out.println("7. Busca Xmen por nombre");
        System.out.println("8. Eliminar XMen por numero de posición");
        System.out.println("9. Eliminar Xmen por  nombre");
        System.out.println("10. Activar XMen");
        System.out.println("99. Vaciar Agenda");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion(BufferedReader teclado) throws IOException {
        int opcion = -1;
        boolean correcto = false;
        do {
            try {
                opcion = Integer.parseInt(teclado.readLine());
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("\tError:Introduce un numero...");
            }
        } while (!correcto);
        return opcion;
    }

    private static void switchMenu(int opcionMenu) throws IOException {
        switch (opcionMenu) {
            case 1:
                System.out.println("Mostrando contenido resumido de la agenda:");
                System.out.println("------------------------------------------");
                
                Utiles.Pausar();
                break;
            case 2:
                System.out.println("Mostrando contenido resumido de la agenda:");
                System.out.println("------------------------------------------");
                
                Utiles.Pausar();
                break;
            case 3:
                System.out.println("->->->-> Rellenando con los clásicos ->->->->");
                System.out.println("------------------------------------------");
                
                Utiles.Pausar();
                break;
            case 4:
                System.out.println("Añadiendo XMen con sus datos básicos:");
                System.out.println("------------------------------------------");
                
                Utiles.Pausar();
                break;
            case 5:
                System.out.println("5. Editar XMen por nombre");
                break;
            case 6:
                System.out.println("6. Buscar Superhéroe por número de posición");
                break;
            case 7:
                System.out.println("7. Busca Xmen por nombre");

                break;
            case 8:
                System.out.println("8. Eliminar XMen por numero de posición");

                break;
            case 9:
                System.out.println("9. Eliminar Xmen por  nombre");

                break;
            case 10:
                System.out.println("10. Activar XMen");

                break;
            case 99:
                System.out.println("99. Vaciar Agenda");

                break;
            case 0:
                System.out.println("0. Saliendo de los contactos");

                break;
            default:
                System.out.println("Opción no válida.");
        }

    }
//--------------------------------------------------------------------------------
}
