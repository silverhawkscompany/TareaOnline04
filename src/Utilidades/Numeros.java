/**
 * .
 */
package Utilidades;

/**
 *
 * @author dgdan
 */
public class Numeros {

    public static int pares() {
        int numero = 2;
        int contador = 0;

        while (contador < 10) {
            //Con el condicional If decimos que si el módulo(%) del número indruducido da cero que lo imprima y aumente el contador
            if (numero % 2 == 0) {
                numero++;
                contador++;
                //Si no, incrementas la variable número en una unidad
            } else {
                numero++;
            }
        }
        return numero;
    }
}
