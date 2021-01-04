/**
 *
 */
package Principal;

import ArrysCC.*;
import HundirLaFlota.*;
import Utilidades.*;

/**
 *
 * @author Daniel Díaz González
 */
public class Principal {

    public static void main(String[] args) {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "--------------------------------MENU PRINCIPAL--------------------------------" + Color.reset());
            IO_ES.escribirLN(Color.azul() + "1. Cadena de caracteres");
            IO_ES.escribirLN(Color.azul() + "2. Validar matrículas");
            IO_ES.escribirLN(Color.azul() + "3. Arrays");
            IO_ES.escribirLN(Color.azul() + "4. Hundir la flota");
            IO_ES.escribirLN("0. Salir" + Color.reset());//Solo se debe salir al pulsar 0

            opciones = IO_ES.leerInteger("Escribe una opción: ");
            if (opciones > -1 && opciones < 5) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
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
                    HundirFlota.opcionesMenu();
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);

    }
}
