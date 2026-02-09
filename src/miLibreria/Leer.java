/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miLibreria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chris
 */
public class Leer {

    /**
     * Lee una cadena de texto
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerCadena(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print(mensaje);
        return teclado.readLine();
    }

    /**
     * Lee un número entero con control de error
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static int LeerEntero(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String texto;
        int numero = 0;
        boolean error;
        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine();
            try {
                numero = Integer.parseInt(texto.trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: formato de número entero no válido.");
                error = true;
            }
        } while (error);
        return numero;
    }

    /**
     * Lee un número decimal con validación
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static double LeerDecimal(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String texto;
        double numero = 0;
        boolean error;
        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine();
            try {
                numero = Double.parseDouble(texto.replace(',', '.').trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: formato de número decimal no válido.");
                error = true;
            }
        } while (error);
        return numero;
    }

    /**
     * Método para leer un correo electrónico válido. Acepta formatos tipo
     * usuario@dominio.com
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerEmail(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String email = "";
        boolean lecturaCorrecta;

        do {
            lecturaCorrecta = true;
            System.out.print(mensaje);
            try {
                email = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }

            // Expresión regular para validar email
            String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                System.err.println("\tError: formato de email incorrecto. Ejemplo: usuario@mail.com");
                lecturaCorrecta = false;
            }
        } while (!lecturaCorrecta);

        return email;
    }

    /**
     * Método para leer un número de teléfono válido. Acepta formatos tipo
     * 123456789 o +** 123456789
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerTelefono(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String telefono = "";
        boolean lecturaCorrecta;

        do {
            lecturaCorrecta = true;
            System.out.print(mensaje);
            try {
                telefono = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }

            // Expresión regular para validar teléfono (9?14 dígitos, opcional '+')
            String regex = "^[\\+]?\\d{9,14}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(telefono);

            if (!matcher.matches()) {
                System.err.println("\tError: formato de teléfono incorrecto. Ejemplo: +34600123456 o 600123456");
                lecturaCorrecta = false;
            }
        } while (!lecturaCorrecta);

        return telefono;
    }

    

    // ============================
    //  MÉTODOS DE VALIDACIÓN DE NÚMEROS
    // ============================
    /**
     * Lee un número entero mayor que 0 con control de error.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static int LeerEnteroPositivo(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        int numero = 0;
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(teclado.readLine().trim());
                if (numero <= 0) {
                    System.err.println("Error: el número debe ser mayor que 0.");
                    error = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: introduce un número entero válido.");
                error = true;
            }
        } while (error);

        return numero;
    }

    /**
     * Lee un número entero entre 0 y 10 con control de error.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static int LeerEnteroEntre0y10(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        int numero = 0;
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(teclado.readLine().trim());
                if (numero < 0 || numero > 10) {
                    System.err.println("Error: el número debe estar entre 0 y 10.");
                    error = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: introduce un número entero válido.");
                error = true;
            }
        } while (error);

        return numero;
    }

    /**
     * Lee un número decimal mayor que 0 con control de error.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static double LeerDecimalPositivo(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        double numero = 0;
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(teclado.readLine().replace(',', '.').trim());
                if (numero <= 0) {
                    System.err.println("Error: el número debe ser mayor que 0.");
                    error = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: introduce un número decimal válido.");
                error = true;
            }
        } while (error);

        return numero;
    }

    /**
     * Lee un número decimal entre 0 y 10 con control de error.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static double LeerDecimalEntre0y10(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        double numero = 0;
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(teclado.readLine().replace(',', '.').trim());
                if (numero < 0 || numero > 10) {
                    System.err.println("Error: el número debe estar entre 0 y 10.");
                    error = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: introduce un número decimal válido.");
                error = true;
            }
        } while (error);

        return numero;
    }

    // ============================
    //  MÉTODO DE LECTURA DE CARÁCTER
    // ============================
    /**
     * Lee un solo carácter (char) desde teclado.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static char LeerCaracter(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String texto;
        char caracter = ' ';
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine().trim();

            if (texto.length() != 1) {
                System.err.println("Error: introduce solo un carácter.");
                error = true;
            } else {
                caracter = texto.charAt(0);
            }

        } while (error);

        return caracter;
    }

    // ============================
    //  MÉTODOS DE VALIDACIÓN
    // ============================
    /**
     * Comprueba si un número es positivo
     *
     * @param n
     * @return
     */
    public static boolean EsPositivo(double n) {
        return n > 0;
    }

    /**
     * Comprueba si un número está dentro de un rango
     *
     * @param valor
     * @param min
     * @param max
     * @return
     */
    public static boolean EsRango(int valor, int min, int max) {
        return valor >= min && valor <= max;
    }

    // ============================
    //  MÉTODOS PARA ARRAYS
    // ============================
    /**
     * Calcula la media de un array de doubles
     *
     * @param array
     * @return
     */
    public static double MediaArray(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double suma = 0;
        for (double valor : array) {
            suma += valor;
        }
        return suma / array.length;
    }

    /**
     * Devuelve el valor máximo de un array
     *
     * @param array
     * @return
     */
    public static double MaximoArray(double[] array) {
        double max = array[0];
        for (double valor : array) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    /**
     * Devuelve el valor mínimo de un array
     *
     * @param array
     * @return
     */
    public static double MinimoArray(double[] array) {
        double min = array[0];
        for (double valor : array) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }

    /**
     * Muestra el contenido de un array de doubles
     *
     * @param array
     */
    public static void MostrarArray(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Muestra el contenido de un array bidimensional
     *
     * @param matriz
     */
    public static void MostrarArray2D(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }

    /**
     * Mira que en el array no haya valores repatidos
     *
     * @param array
     * @param hasta
     * @param valor
     * @return
     */
    public static boolean contiene(int[] array, int hasta, int valor) {
        for (int i = 0; i < hasta; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
