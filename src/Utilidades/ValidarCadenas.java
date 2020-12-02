/**
 *
 */
package Utilidades;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dgdan
 */
public class ValidarCadenas {

    public static void opcionesMenu() {
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String cyan = "\033[36m";
        String reset = "\u001B[0m";

        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(morado + "------------------MENU COMPROBACIÓN DE MATRÍCULAS------------------" + reset);
            IO_ES.escribirLN("1. Comprobar matrícula de un automóvil");
            IO_ES.escribirLN("2. Comprobar matrícula de un ciclomotor");
            IO_ES.escribirLN("0. Salir");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones > -1 && opciones < 3) {
                correcto = true;
            } else {
                IO_ES.escribirLN(rojo + "Escribe una opción posible" + reset);
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    if (comprobarMatriculaAutomovil()) {
                        IO_ES.escribirLN(verde + "Matrícula correcta" + reset);
                    } else {
                        IO_ES.escribirLN(rojo + "La matrícula no es válida" + reset);
                    }

                    break;
                case 2:
                    correcto = false;
                    if (comprobarMatriculaCiclomotor()) {
                        System.out.println(verde + "Matrícula correcta" + reset);
                    } else {
                        System.out.println(rojo + "La matrícula no es válida" + reset);
                    }
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }

    private static boolean comprobarMatriculaAutomovil() {
        //4 números seguida de 3 letras. Ejemplo: 4231BBC
        Scanner entrada = new Scanner(System.in);
        String matricula;

        IO_ES.escribir("Escribe la matricula del automóvil: ");
        matricula = entrada.nextLine();

        Pattern p = Pattern.compile("[0-9]{4}[b-zB-Z([^aieou])]{3}");
        Matcher m = p.matcher(matricula);

        /*if (m.matches()) {
            System.out.println("Matrícula correcta");
        } else {
            System.out.println("La matrícula no es correcta");
        }¡
        return true;*/
        return m.matches();
    }

    private static boolean comprobarMatriculaCiclomotor() {
        //1 letra seguida de 4 números y, posteriormente, 3 letras más. Ejemplo: C8731BTJ
        Scanner entrada = new Scanner(System.in);
        String matricula;

        IO_ES.escribir("Escribe la matricula del ciclomotor: ");
        matricula = entrada.nextLine();

        Pattern p = Pattern.compile("[b-zB-Z([^aieou])]{1}[0-9]{4}[b-zB-Z([^aieou])]{3}");
        Matcher m = p.matcher(matricula);

        /*if (m.matches()) {
            System.out.println("Matrícula correcta");
        } else {
            System.out.println("La matrícula no es correcta");
        }
        return true;*/
        return m.matches();
    }
}
