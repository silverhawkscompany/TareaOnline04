/**
 *
 */
package Utilidades;

import java.util.Scanner;

/**
 *
 * @author dgdan
 */
public class ValidarCadenas {

    public static void opcionesMenu() {
        Scanner entrada = new Scanner(System.in);
        byte opciones = 0;
        boolean correcto = false;

        do {
            System.out.println("------------------MENU COMPROBACIÓN DE MATRÍCULAS------------------");
            System.out.println("1. Comprobar matrícula de un automóvil");
            System.out.println("2. Comprobar matrícula de un ciclomotor");
            System.out.println("0. Salir");//Solo se debe salir al pulsar 0
            System.out.print("Escribe una opción: ");
            try {
                opciones = entrada.nextByte();
                correcto = true;
            } catch (Exception e) {
                System.out.println("Elije una opción posible");
            }
            entrada.nextLine();

            switch (opciones) {
                case 1:
                    correcto = false;
                    comprobarMatriculaAutomovil();
                    break;
                case 2:
                    correcto = false;
                    comprobarMatriculaCiclomotor();
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }

    private static void comprobarMatriculaAutomovil() {

    }

    private static void comprobarMatriculaCiclomotor() {

    }
}
