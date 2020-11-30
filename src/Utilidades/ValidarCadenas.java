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
        //4 números seguida de 3 letras. Ejemplo: 4231BBC
        Scanner entrada = new Scanner(System.in);
        String matricula;

        System.out.println("Escribe la matricula del automóvil: ");
        matricula = entrada.nextLine();

        Pattern p = Pattern.compile("[0-9]{4}[a-zA-Z]{3}");
        Matcher m = p.matcher(matricula);

        if (m.matches()) {
            System.out.println("Matrícula correcta");
        } else {
            System.out.println("La matrícula no es correcta");
        }

    }

    private static void comprobarMatriculaCiclomotor() {
        //1 letra seguida de 4 números y, posteriormente, 3 letras más. Ejemplo: C8731BTJ
        Scanner entrada = new Scanner(System.in);
        String matricula;

        System.out.println("Escribe la matricula del ciclomotor: ");
        matricula = entrada.nextLine();

        Pattern p = Pattern.compile("[a-zA-Z]{1}[0-9]{4}[a-zA-Z]{3}");
        Matcher m = p.matcher(matricula);

        if (m.matches()) {
            System.out.println("Matrícula correcta");
        } else {
            System.out.println("La matrícula no es correcta");
        }

    }
}
