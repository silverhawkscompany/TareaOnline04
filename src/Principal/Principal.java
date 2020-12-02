/**
 *
 */
package Principal;

import ArrysCC.Arrays;
import ArrysCC.CadenaCaracteres;
import Utilidades.IO_ES;
import Utilidades.ValidarCadenas;

/**
 *
 * @author dgdan
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            IO_ES.escribirLN(morado + "--------------------------------MENU PRINCIPAL--------------------------------" + reset);
            IO_ES.escribirLN("1. Cadena de caracteres");
            IO_ES.escribirLN("2. Validar matrículas");
            IO_ES.escribirLN("3. Arrays");
            IO_ES.escribirLN("4. Hundir la flota");
            IO_ES.escribirLN("0. Salir");//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones > -1 && opciones < 5) {
                correcto = true;
            } else {
                IO_ES.escribirLN(rojo + "Escribe una opción posible" + reset);
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    CadenaCaracteres.opcionesMenu();
                    break;
                case 2:
                    correcto = false;
                    ValidarCadenas.opcionesMenu();
                    break;
                case 3:
                    correcto = false;
                    Arrays.opcionesMenu();
                    break;
                case 4:
                    correcto = false;
                    //HundirFlota();
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);

    }
}
