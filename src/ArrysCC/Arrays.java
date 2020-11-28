/**
 *
 */
package ArrysCC;

import Utilidades.Numeros;
import java.util.Scanner;

/**
 *
 * @author dgdan
 */
public class Arrays {

    public static void opcionesMenu() {
        Scanner entrada = new Scanner(System.in);
        byte opciones = 0;
        boolean correcto = false;

        do {
            System.out.println("--------------------------MENU DE ARRAYS---------------------------");
            System.out.println("1. Mostrar un Array de 10 con 10 primeros números pares");
            System.out.println("2. Acierte un número de un Array de 10 con números aleatorios");
            System.out.println("3. Elije el tamaño de un Array aleatorio, para ver la media, el mayor y el menor valor");
            System.out.println("4. Elije el tamaño de un Array aleatorio para visualizarlo y ver los número mayores y menores de 50");
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
                    int pares[] = new int[10];//Declaración de la matriz
                    for (int i = 0; i < 10; i++) {//Cuidado i siempre es menor al tamaño de la matriz
                        pares[i] = 2 * i;
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Valor del indice: " + i + " = " + pares[i]);
                    }

                    break;
                case 2:
                    correcto = false;

                    break;
                case 3:
                    correcto = false;

                    break;
                case 4:
                    correcto = false;

                    break;
                case 0:
                    break;
            }
        } while (correcto == false);
    }
}
