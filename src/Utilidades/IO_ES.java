package Utilidades;

import java.util.*;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class IO_ES {

    /**
     * Método para la lectura de un dato entero
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número entero
     */
    public static int leerInteger(String frase) {
        int numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = entrada.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                System.err.println("Dato no válido");
                entrada.nextLine();
            }

        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato con decimal
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número con decimal
     */
    public static float leerReal(String frase) {
        float numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = entrada.nextFloat();
                correcto = true;
            } catch (InputMismatchException e) {
                System.err.println("Dato real no válido");
                //Limpiamos el buffer, al meter un dato erroneo, sino se produce un bucle infinito
                entrada.nextLine();
            }

        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero largo
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número entero largo
     */
    public static long leerIntegerlargo(String frase) {
        long numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = entrada.nextLong();
                correcto = true;
            } catch (InputMismatchException e) {
                System.err.println("Dato entero no válido");
                entrada.nextLine();
            }

        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato real largo
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número real largo
     */
    public static double leerReallargo(String frase) {
        double numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = entrada.nextDouble();
                correcto = true;
            } catch (InputMismatchException e) {
                System.err.println("Dato real no válido");
                entrada.nextLine();
            }

        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato con un formato de decimales deseado
     *
     * @param format Intruducimos el formato de decimales deseado
     * @param i El número que deseamos darle formato. Ej: dos decimales %1.2f
     */
    public static void escribirFormato(String format, double i) {
        try {
            System.out.printf(format, i);
            System.out.print("");
        } catch (Exception e) {
            System.err.println("El formato debe ser '%1.decimales + f'");
        }
    }

    /**
     * Método para la lectura de una cadena de texto sin salto de linea
     *
     * @param mensaje Introducir el mensaje que queremos mostrar por consola
     */
    public static void escribir(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Método para la lectura de una cadena de texto con salto de linea
     *
     * @param mensaje Introducir el mensaje que queremos mostrar por consola,
     * nos añade un salto de linea
     */
    public static void escribirLN(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Método para ordenar arrays
     *
     * @param nombreArray Indicamos el array que deseamos ordenar
     * @param tamaño Indicamos el tamaño de array
     */
    public static void ordenarArrayDecimal(double[] nombreArray, int tamaño) {
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 1; j < (tamaño - i); j++) {
                // si el elemento anterior es mayor, hacemos el cambio
                if (nombreArray[j - 1] > nombreArray[j]) {
                    double aux_elem = nombreArray[j];
                    nombreArray[j] = nombreArray[j - 1];
                    nombreArray[j - 1] = aux_elem;
                }
            }
        }
    }

    /**
     * Método para mostrar un array con números reales
     *
     * @param nombreArray Indicamos el array que deseamos mostrar
     */
    public static void mostrarArrayDecimal(double[] nombreArray) {
        for (double i : nombreArray) {
            IO_ES.escribirFormato("%1.2f", i);
            IO_ES.escribir(" - ");
        }
        IO_ES.escribirLN("");
    }

    /**
     * Método para ordenar arrays
     *
     * @param nombreArray Indicamos el array que deseamos ordenar
     * @param tamaño Indicamos el tamaño de array
     */
    public static void ordenarArrayEntero(int[] nombreArray, int tamaño) {
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 1; j < (tamaño - i); j++) {
                // si el elemento anterior es mayor, hacemos el cambio
                if (nombreArray[j - 1] > nombreArray[j]) {
                    int aux_elem = nombreArray[j];
                    nombreArray[j] = nombreArray[j - 1];
                    nombreArray[j - 1] = aux_elem;
                }
            }
        }
    }

    /**
     * Método para mostrar un array con números enteros
     *
     * @param nombreArray Indicamos el array que deseamos mostrar
     */
    public static void mostrarArrayEntero(int[] nombreArray) {
        for (int i : nombreArray) {
            IO_ES.escribir(i + " - ");
        }
        IO_ES.escribirLN("");
    }
}
