/**
 *
 */
package Utilidades;

import java.util.*;

/**
 *
 * @author Daniel Díaz González
 */
public class IO_ES {

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
                entrada.nextLine();//Con este comando limpiamos el buffer al meter un dato erroneo, sino se produce un bucle infinito
            }

        } while (correcto == false);
        return numero;
    }

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

    public static void escribir(String mensaje) {
        System.out.print(mensaje);
    }

    public static void escribirLN(String mensaje) {
        System.out.println(mensaje);
    }
}
