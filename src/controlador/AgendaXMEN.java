/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

import miLibreria.Leer;
import miLibreria.Utiles;
import modelos.*;

/**
 *
 * @author chris
 */
public class AgendaXMEN {
//---------------------------------------------------------------------------------

    private static TreeSet<ContacXMen> listaContactos = new TreeSet();
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
                // Comprobamos si la agenda tiene contactos
                if (listaContactos.isEmpty()) {
                    System.out.println("La agenda está vacía actualmente.");
                } else {
                    // Encabezado seg�n el ejemplo del PDF
                    System.out.println("ID\tNOMBRE\t\tTELÉFONO\tEMAIL");
                    // Usamos un Iterator, que es una de las interfaces a evaluar
                    Iterator<ContacXMen> it = listaContactos.iterator();
                    int i = 1; // Contador para el ID visual [1], [2], etc.
                    while (it.hasNext()) {
                        ContacXMen contacto = it.next();
                        // Llamamos al m�todo de la clase modelo pas�ndole el n�mero actual
                        contacto.presentarInfoTabulada(i);
                        i++;
                    }
                }
                Utiles.Pausar();
                break;
            case 2:
                System.out.println("Mostrando contenido resumido de la agenda:");
                System.out.println("------------------------------------------");
                if (listaContactos.isEmpty()) {
                    System.out.println("\tLa agenda está vacía.");
                } else {
                    Iterator<ContacXMen> itCompleto = listaContactos.iterator();
                    int i = 1;

                    while (itCompleto.hasNext()) {
                        ContacXMen contacto = itCompleto.next();
                        // Al imprimir 'contacto', se ejecuta su toString() y los de sus padres
                        System.out.println("[" + i + "] " + contacto.toString());
                        i++;
                    }
                }

                System.out.println("Pulse intro para continuar.");
                Utiles.Pausar();
                break;
            case 3:
                System.out.println("->->->-> Rellenando con los clásicos ->->->->");
                System.out.println("------------------------------------------");
                // Creamos unos cuantos XMen usando el constructor completo de tu clase XMen
                // Parametros: frase, esAnonimo, usaArtefactos, nombre, edad, altura, sexo
                XMen lobezno = new XMen("Soy el mejor en lo que hago", false, false, "Lobezno", 150, 1.80f, Persona.Sexo.HOMBRE);
                XMen ciclope = new XMen("�Por el profesor!", false, true, "Ciclope", 30, 1.90f, Persona.Sexo.HOMBRE);
                XMen tormenta = new XMen("Siente el rayo", false, false, "Tormenta", 32, 1.75f, Persona.Sexo.MUJER);
                XMen bestia = new XMen("�Cielos!", false, false, "Bestia", 35, 1.85f, Persona.Sexo.HOMBRE);

                // Los empaquetamos en objetos ContacXMen con datos de contacto ficticios
                ContacXMen c1 = new ContacXMen(lobezno, "666000111", "lobezno@xmen.org");
                ContacXMen c2 = new ContacXMen(ciclope, "666333999", "c@xmen.org");
                ContacXMen c3 = new ContacXMen(tormenta, "666000333", "tormenta@xmen.org");
                ContacXMen c4 = new ContacXMen(bestia, "666000115", "bestia@xmen.org");

                // Los a�adimos al TreeSet (se ordenar�n solos por el compareTo)
                listaContactos.add(c1);
                listaContactos.add(c2);
                listaContactos.add(c3);
                listaContactos.add(c4);

                System.out.println("Se han importado 4 XMen de confianza correctamente.");
                Utiles.Pausar();
                break;
            case 4:
                System.out.println("A�adiendo XMen con sus datos b�sicos:");
                System.out.println("------------------------------------------");

                //Pedir datos
                String nombre = Leer.LeerCadena("Introduce el nombre: ");
                String tlf = Leer.LeerTelefono("Introduce su tel�fono: ");
                String mail = Leer.LeerEmail("Introduce su email: ");
                XMen nuevoXmen = new XMen("Sin frase", false, false, nombre, 0);

                //Crear el contacto y a�adirlo
                ContacXMen nuevoContacto = new ContacXMen(nuevoXmen, tlf, mail);
                //Control de datos
                if (listaContactos.add(nuevoContacto)) {
                    System.out.println("Datos introducidos correctamente.");
                } else {
                    System.out.println("Error: El XMen ya existe en la agenda.");
                }

                Utiles.Pausar();
                break;
            case 5:
                System.out.println("5. Editar XMen por nombre");
                break;
            case 6:
                System.out.println("6. Buscar Superh�roe por n�mero de posici�n");
                break;
            case 7:
                System.out.println("7. Busca Xmen por nombre");
                String nombreBuscar = Leer.LeerCadena("Introduce el nombre del superh�roe a buscar: ");

                boolean encontrado = false;
                Iterator<ContacXMen> itBusqueda = listaContactos.iterator();

                while (itBusqueda.hasNext() && !encontrado) {
                    ContacXMen contactoActual = itBusqueda.next();

                    // Comparamos el nombre ignorando may�sculas/min�sculas
                    if (contactoActual.getPersona().getNombre().equalsIgnoreCase(nombreBuscar)) {
                        System.out.println("\n�Superh�roe encontrado!");
                        System.out.println("------------------------------------------");
                        // Usamos el m�todo presentarInfo() de la clase Persona (que XMen sobreescribe)
                        contactoActual.getPersona().presentarInfo();
                        System.out.println("Teléfono: " + contactoActual.getTelefono());
                        System.out.println("Email: " + contactoActual.getEmail());
                        System.out.println("------------------------------------------");
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("\tError: No se ha encontrado a '" + nombreBuscar + "' en la agenda.");
                }

                Utiles.Pausar();

                break;
            case 8:
                System.out.println("8. Eliminar XMen por numero de posici�n");

                break;
            case 9:
                System.out.println("9. Eliminar Xmen por  nombre");
                if (listaContactos.isEmpty()) {
                    System.out.println("No hay nada en la agenda");
                } else {
                    String nombreEliminar = Leer.LeerCadena("Introduce el nombre del heroe a eliminar: ");
                    boolean borrado = false;
                    Iterator<ContacXMen> itBorrado = listaContactos.iterator();
                    while (itBorrado.hasNext()) {
                        ContacXMen contaco = itBorrado.next();

                        //Comparamos
                        if (contaco.getPersona().getNombre().equalsIgnoreCase(nombreEliminar)) {
                            itBorrado.remove();//Elimina el heroe seleccionado
                            borrado = true;
                            System.out.println("El heroe a sido eliminado: " + nombreEliminar);
                            break;
                        }
                    }
                    if (!borrado) {
                        System.out.println("\tNo hay ningun heroe a eliminar.");
                    }
                }
                Utiles.Pausar();
                break;
            case 10:
                System.out.println("10. Activar XMen");

                break;
            case 99:
                System.out.println("99. Vaciar Agenda");
                if (listaContactos.isEmpty()) {
                    System.out.println("No hay nada en la agenda");
                }else {
                    char respuesta=Leer.confirmarSoN("¿Quieres elimirar toda la agenda? (s/n)");
                    if (respuesta == 's'|| respuesta == 'S') {
                        listaContactos.clear();//Eliminamos todo los heroes/civiles de la agenda
                        System.out.println("\tLa agenda ha sido borrada");
                    }else  {
                        System.out.println("Operaicon cancelada");
                    }
                }
                Utiles.Pausar();
                break;
            case 0:
                System.out.println("0. Saliendo de los contactos");

                break;
            default:
                System.out.println("Opci�n no v�lida.");
        }

    }
//--------------------------------------------------------------------------------
}
