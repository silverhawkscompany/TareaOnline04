/**
 *
 */
package Utilidades;

/**
 *
 * @author Daniel Díaz González
 */
public class Color {

    public static String azul() {
        return "\033[34m";
    }

    public static String rojo() {
        return "\033[31m";
    }

    public static String verde() {
        return "\033[32m";
    }

    public static String amarillo() {
        return "\033[33m";
    }

    public static String morado() {
        return "\033[35m";
    }

    public static String cyan() {
        return "\033[36m";
    }

    public static String reset() {
        return "\u001B[0m";
    }
}
