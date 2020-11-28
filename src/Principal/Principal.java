/**
 *
 */
package Principal;

import ArrysCC.Arrays;
import ArrysCC.CadenaCaracteres;
import Utilidades.ValidarCadenas;
import java.util.Scanner;

/**
 *
 * @author dgdan
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        byte opciones = 0;
        boolean correcto = false;

        do {
            System.out.println("--------------------------------MENU--------------------------------");
            System.out.println("1. Cadena de caracteres");
            System.out.println("2. Validar matrículas");
            System.out.println("3. Arrays");
            System.out.println("4. Hundir la flota");
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
