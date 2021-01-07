package Utilidades;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ValidarCadenasAntiguo {

    /**
     * Método para el menu de validar cadenas
     */
    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "-----------------------MENU COMPROBACIÓN DE MATRÍCULAS-----------------------" + Color.reset());
            IO_ES.escribirLN(Color.azul() + "1. Comprobar matrícula de un automóvil");
            IO_ES.escribirLN(Color.azul() + "2. Comprobar matrícula de un ciclomotor");
            IO_ES.escribirLN("0. Atrás" + Color.reset());//Solo se debe salir al pulsar 0
            //If-Else lo utilizamos para solo poder intruducir valores enteros entre 0 y 2, ambos incluidos
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

    /**
     * Método para comprobar las matriculas de los ciclomotores
     *
     * @return Devuelve true o false, según la matricula introducida sea
     * correcta
     */
    private static boolean comprobarMatriculaAutomovil() {
        //4 números seguida de 3 letras. Ejemplo: 4231BBC
        Scanner entrada = new Scanner(System.in);
        String matricula;

        IO_ES.escribir("Escribe la matricula del automóvil: ");
        matricula = entrada.nextLine();
        //Lo que no queremos que incluya va entre parentesis dentro de los corchetes a los que hace referencia
        Pattern p = Pattern.compile("[0-9]{4}[b-d f-h j-n p-t v-z]{3}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(matricula);
        //Nos devuleve true o false
        return m.matches();
    }

    /**
     * Método para comprobar las matriculas de los ciclomotores
     *
     * @return Devuelve true o false, según la matricula introducida sea
     * correcta
     */
    private static boolean comprobarMatriculaCiclomotor() {
        //1 letra seguida de 4 números y, posteriormente, 3 letras más. Ejemplo: C8731BTJ
        Scanner entrada = new Scanner(System.in);
        String matricula;

        IO_ES.escribir("Escribe la matricula del ciclomotor: ");
        matricula = entrada.nextLine();

        Pattern p = Pattern.compile("[b-d f-h j-n p-t v-z]{1}[0-9]{4}[b-d f-h j-n p-t v-z]{3}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(matricula);
        //Nos devuleve true o false
        return m.matches();
    }
}
