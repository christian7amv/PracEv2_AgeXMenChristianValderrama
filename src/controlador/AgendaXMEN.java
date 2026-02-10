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

    private static TreeSet<ContacXMen> listaContactos = new TreeSet<>();
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

                // Los añaadimos al TreeSet (se ordenar�n solos por el compareTo)
                listaContactos.add(c1);
                listaContactos.add(c2);
                listaContactos.add(c3);
                listaContactos.add(c4);

                System.out.println("Se han importado 4 XMen de confianza correctamente.");
                Utiles.Pausar();
                break;
            case 4:
                System.out.println("Añádiendo XMen con sus datos básicos:");
                System.out.println("------------------------------------------");
                //Pedir datos
                String nombre = Leer.LeerCadena("Introduce el nombre: ");
                String telefono = Leer.LeerTelefono("Introduce su tel�fono: ");
                String mail = Leer.LeerEmail("Introduce su email: ");
                XMen nuevoXmen = new XMen("Sin frase", false, false, nombre, 0);

                //Crear el contacto y añadirlo
                ContacXMen nuevoContacto = new ContacXMen(nuevoXmen, telefono, mail);
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
                System.out.println("------------------------------------------");
                String nombreAEditar = Leer.LeerCadena("Introduce el nombre del superhéroe: ");
                ContacXMen contactoEncontrado = null;
                //barremos con un fore para buscar el contacto/XMen
                for (ContacXMen c : listaContactos) {
                    if (c.getPersona().getNombre().equalsIgnoreCase(nombreAEditar)) {
                        contactoEncontrado = c;
                        break;
                    }
                }
                if (contactoEncontrado != null) {
                    //Actualicemos telefono y email
                    String nuevoTelefono = Leer.LeerTelefono("Introduce el nuevo telefono: ");
                    String nuevoMail = Leer.LeerEmail("Introduce el nuevo email: ");
                    contactoEncontrado.setTelefono(nuevoTelefono);
                    contactoEncontrado.setEmail(nuevoMail);
                    System.out.println("Datos editados correctamente.");
                } else {
                    System.out.println("No se encontro el contacto");
                }
                Utiles.Pausar();
                break;
            case 6:
                System.out.println("6. Buscar Superhéroe por número de posición");
                System.out.println("------------------------------------------");
                if (listaContactos.isEmpty()) {
                    System.out.println("\tLa agenda está vacía.");
                } else {
                    int numBusqueda = Leer.LeerEnteroPositivo("Introduce la posición del XMen: ");
                    if (numBusqueda > listaContactos.size()) {
                        System.out.println("\tError: Los IDs que hay son: " + listaContactos.size());
                    } else {
                        Iterator<ContacXMen> itNumero = listaContactos.iterator();
                        ContacXMen encontrado = null;
                        int contador = 1;
                        while (itNumero.hasNext()) {
                            ContacXMen actual = itNumero.next();
                            if (contador == numBusqueda) {
                                encontrado = actual;
                                break;
                            }
                            contador++;
                        }
                        if (encontrado != null) {
                            System.out.println(encontrado.toString());
                        }
                    }
                }
                Utiles.Pausar();
                break;
            case 7:
                System.out.println("7. Busca Xmen por nombre");
                System.out.println("------------------------------------------");
                String nombreBuscar = Leer.LeerCadena("Introduce el nombre del superhéroe a buscar: ");

                boolean encontrado = false;
                Iterator<ContacXMen> itBusqueda = listaContactos.iterator();

                while (itBusqueda.hasNext() && !encontrado) {
                    ContacXMen contactoActual = itBusqueda.next();

                    // Comparamos el nombre ignorando mayúsculas/minúsculas
                    if (contactoActual.getPersona().getNombre().equalsIgnoreCase(nombreBuscar)) {
                        System.out.println("\nSuperhéroe encontrado");
                        System.out.println("------------------------------------------");
                        // Usamos el método presentarInfo() de la clase Persona (que XMen sobreescribe)
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
                System.out.println("8. Eliminar XMen por numero de posicion"); // Evita tildes si dan error
                System.out.println("------------------------------------------");

                if (listaContactos.isEmpty()) {
                    System.out.println("\tLa agenda ya esta vacia.");
                } else {
                    int numEliminar = Leer.LeerEnteroPositivo("Introduce la posicion del XMen a borrar: ");

                    if (numEliminar > listaContactos.size()) {
                        System.out.println("\tError: Solo hay " + listaContactos.size() + " contactos.");
                    } else {
                        Iterator<ContacXMen> itNumero = listaContactos.iterator();
                        int contador = 1;

                        while (itNumero.hasNext()) {
                            itNumero.next();

                            if (contador == numEliminar) {
                                itNumero.remove();
                                System.out.println("\tContacto en posicion [" + numEliminar + "] eliminado.");
                                break;
                            }
                            contador++;
                        }
                    }
                }

                Utiles.Pausar();
                break;
            case 9:
                System.out.println("9. Eliminar Xmen por  nombre");
                System.out.println("------------------------------------------");

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
                System.out.println("------------------------------------------");
                if (listaContactos.isEmpty()) {
                    System.out.println("\tNo hay héroes en la agenda para la misión.");
                } else {
                    // 1. Simulamos el peligro (usando tu método de Utiles)
                    Utiles.mostrarSecuestro();

                    // 2. Elegimos a un héroe de la agenda para la misión
                    // Para variar, vamos a elegir al primero de la lista (el que esté más cerca)
                    ContacXMen contactoMision = listaContactos.first(); // TreeSet permite pillar el primero fácilmente
                    XMen heroe = (XMen) contactoMision.getPersona(); // Casting a XMen para acceder a sus poderes

                    System.out.println("¡Alerta! El profesor X ha enviado a: " + heroe.getNombre());
                    System.out.println("------------------------------------------");

                    // 3. Ejecutamos sus acciones especiales (Polimorfismo e Interfaces)
                    heroe.decirFraseLlegada();
                    heroe.volar();           // Viene de la interfaz Superpoder
                    heroe.superFuerza();     // Viene de la interfaz Superpoder

                    // 4. Usamos el método salvar (Sobrecarga)
                    // Creamos un Civil rápido para rescatarlo
                    Civil victima = new Civil("Andres", 25, 1.75f, Persona.Sexo.HOMBRE);
                    heroe.salvar(victima);

                    System.out.println("------------------------------------------");
                    System.out.println("¡Misión cumplida! El civil está a salvo.");
                }

                Utiles.Pausar();

                break;
            case 99:
                System.out.println("99. Vaciar Agenda");
                System.out.println("------------------------------------------");

                if (listaContactos.isEmpty()) {
                    System.out.println("No hay nada en la agenda");
                } else {
                    char respuesta = Leer.confirmarSoN("¿Quieres elimirar toda la agenda? (s/n)");
                    if (respuesta == 's' || respuesta == 'S') {
                        listaContactos.clear();//Eliminamos todo los heroes/civiles de la agenda
                        System.out.println("\tLa agenda ha sido borrada");
                    } else {
                        System.out.println("Operaicon cancelada");
                    }
                }
                Utiles.Pausar();
                break;
            case 0:
                System.out.println("0. Saliendo de los contactos");
                System.out.println("------------------------------------------");

                break;
            default:
                System.out.println("Opci�n no v�lida.");
        }

    }
//--------------------------------------------------------------------------------
}
