/**
 *
 */
package Utilidades;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel Díaz González
 */
public class ValidarCadenas {

    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "-----------------------MENU COMPROBACIÓN DE MATRÍCULAS-----------------------" + Color.reset());
            IO_ES.escribirLN("1. Comprobar matrícula de un automóvil");
            IO_ES.escribirLN("2. Comprobar matrícula de un ciclomotor");
            IO_ES.escribirLN("0. Atrás");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones > -1 && opciones < 3) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    if (comprobarMatriculaAutomovil()) {
                        IO_ES.escribirLN(Color.verde() + "Matrícula correcta" + Color.reset());
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "La matrícula no es válida" + Color.reset());
                    }
                    break;
                case 2:
                    correcto = false;
                    if (comprobarMatriculaCiclomotor()) {
                        System.out.println(Color.verde() + "Matrícula correcta" + Color.reset());
                    } else {
                        System.out.println(Color.rojo() + "La matrícula no es válida" + Color.reset());
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
        //Lo que no queremos que incluya va entre parentesis dentro de los corchetes a los que hace referencia
        Pattern p = Pattern.compile("[0-9]{4}[b-zB-Z([^aieou])]{3}");
        Matcher m = p.matcher(matricula);
        //Nos devuleve true o false
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
        //Nos devuleve true o false
        return m.matches();
    }
}
