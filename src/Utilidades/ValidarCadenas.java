package Utilidades;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ValidarCadenas {

    /**
     * Menu para validar cadenas
     */
    public static void opcionesMenu() {
        int opciones;
        boolean correcto = false;

        do {
            IO_ES.escribirLN(Color.azul() + "----------------------------MENU VALIDAR CADENAS----------------------------");
            IO_ES.escribirLN(Color.azul() + "1. Verificar un código postal");
            IO_ES.escribirLN(Color.azul() + "2. Verificar una cuenta bancaria");
            IO_ES.escribirLN("0. Atrás" + Color.reset());
            opciones = IO_ES.leerInteger("Elije una opción: ");
            if (opciones > -1 && opciones < 3) {
                correcto = true;
            } else {
                IO_ES.escribirLN(Color.rojo() + "Escribe una opción posible" + Color.reset());
            }

            switch (opciones) {
                case 1:
                    correcto = false;
                    if (verificarCP()) {
                        IO_ES.escribirLN(Color.verde() + "Código postal correcto" + Color.reset());
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "El código postal no es válido" + Color.reset());
                    }
                    break;
                case 2:
                    correcto = false;
                    if (verificarCuenta()) {
                        IO_ES.escribirLN(Color.verde() + "La cuenta introducida es correcta" + Color.reset());
                    } else {
                        IO_ES.escribirLN(Color.rojo() + "La cuenta no es válida" + Color.reset());
                    }
                    break;
                case 0:
                    break;
            }
        } while (correcto == false);

    }

    /**
     * Método para verificar los CP
     *
     * @return Devuelve si el CP introducido es true o false
     */
    public static boolean verificarCP() {
        //el parámetro contiene 5 números comprendidos entre 01001 y 52999, falso en caso contrario
        int postal;
        boolean condicion;

        postal = IO_ES.leerInteger("Introduce el Código postal: ");
        condicion = postal > 1000 && postal < 53000;

        return condicion;
    }

    /**
     * Método para verificar las cuentas bancarias
     *
     * @return Devuelve true o false según si la cuenta introducida es correcta
     */
    public static boolean verificarCuenta() {
        //Cuenta válida ES1901230001180123495789
        Scanner entrada = new Scanner(System.in);
        String cuenta;
        boolean ccc = false;
        //Patron para introducir la CC
        IO_ES.escribir("Introduce la cuenta bancaria: ");
        cuenta = entrada.next();
        Pattern p = Pattern.compile("[es]{2}[0-9]{2}[0-9]{4}[0-9]{4}[0-9]{2}[0-9]{10}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(cuenta);
        if (m.matches() == true) {
            //Código de la cuenta//
            //Extraer dígito de control 1
            String dc1 = cuenta.substring(4, 5);
            int digito1 = Integer.parseInt(dc1);
            digito1 *= 2;
            String dc2 = cuenta.substring(5, 6);
            int digito2 = Integer.parseInt(dc2);
            digito2 *= 8;
            String dc3 = cuenta.substring(6, 7);
            int digito3 = Integer.parseInt(dc3);
            digito3 *= 5;
            String dc4 = cuenta.substring(7, 8);
            int digito4 = Integer.parseInt(dc4);
            digito4 *= 10;
            String dc5 = cuenta.substring(8, 9);
            int digito5 = Integer.parseInt(dc5);
            digito5 *= 9;
            String dc6 = cuenta.substring(9, 10);
            int digito6 = Integer.parseInt(dc6);
            digito6 *= 7;
            String dc7 = cuenta.substring(10, 11);
            int digito7 = Integer.parseInt(dc7);
            digito7 *= 3;
            String dc8 = cuenta.substring(11, 12);
            int digito8 = Integer.parseInt(dc8);
            digito8 *= 6;
            //Sumamos las cadenas convertidas a int
            int sumaDigitos1 = (digito1 + digito2 + digito3 + digito4 + digito5 + digito6 + digito7 + digito8);
            //Calculamos el módulo de la suma de dígitos de 11
            int digitoControl1 = sumaDigitos1 % 11;
            if (digitoControl1 == 10) {
                digitoControl1 = 1;
            }
            if (digitoControl1 == 11) {
                digitoControl1 = 0;
            }
            //Extraer dígito de control 2
            String dc11 = cuenta.substring(14, 15);
            int digito11 = Integer.parseInt(dc11);
            digito11 *= 1;
            String dc12 = cuenta.substring(15, 16);
            int digito12 = Integer.parseInt(dc12);
            digito12 *= 2;
            String dc13 = cuenta.substring(16, 17);
            int digito13 = Integer.parseInt(dc13);
            digito13 *= 4;
            String dc14 = cuenta.substring(17, 18);
            int digito14 = Integer.parseInt(dc14);
            digito14 *= 8;
            String dc15 = cuenta.substring(18, 19);
            int digito15 = Integer.parseInt(dc15);
            digito15 *= 5;
            String dc16 = cuenta.substring(19, 20);
            int digito16 = Integer.parseInt(dc16);
            digito16 *= 10;
            String dc17 = cuenta.substring(20, 21);
            int digito17 = Integer.parseInt(dc17);
            digito17 *= 9;
            String dc18 = cuenta.substring(21, 22);
            int digito18 = Integer.parseInt(dc18);
            digito18 *= 7;
            String dc19 = cuenta.substring(22, 23);
            int digito19 = Integer.parseInt(dc19);
            digito19 *= 3;
            String dc20 = cuenta.substring(23, 24);
            int digito20 = Integer.parseInt(dc20);
            digito20 *= 6;
            //Sumamos las cadenas convertidas a int
            int sumaDigitos2 = (digito11 + digito12 + digito13 + digito14 + digito15 + digito16 + digito17 + digito18 + digito19 + digito20);
            //Calculamos el módulo de la suma de dígitos de 11
            int digitoControl2 = sumaDigitos2 % 11;
            if (digitoControl2 == 10) {
                digitoControl2 = 1;
            }
            if (digitoControl2 == 11) {
                digitoControl2 = 0;
            }
            //Comparación dígito control CC//
            //Convertimos los digitos de control de String a int
            String compararDigitoControl1 = cuenta.substring(12, 13);
            int transformD1 = Integer.parseInt(compararDigitoControl1);
            String compararDigitoControl2 = cuenta.substring(13, 14);
            int transformD2 = Integer.parseInt(compararDigitoControl2);

            if (transformD1 == digitoControl1 && transformD2 == digitoControl2) {
                //IBAN//
                String letraE = "14";
                String letraS = "28";
                //Extraemos la cuenta como cadena y le añadimos al final "142800"
                String cuentaSinIban = cuenta.substring(4) + letraE + letraS + "00";
                //Utilizamos el objeto BigInteger, cuenta demasiado grande
                BigInteger cuentaNumero = new BigInteger(cuentaSinIban);
                BigInteger modulo = new BigInteger("97");
                BigInteger resta = new BigInteger("98");
                BigInteger residuo = cuentaNumero.mod(modulo);
                BigInteger resultado = resta.subtract(residuo);
                //Convertimos el objeto BigInteger en String
                String codigoControlIban = resultado.toString();
                //Comparamos el codigo
                String codigoComparar = cuenta.substring(2, 4);
                ccc = codigoComparar.equals(codigoControlIban);
            }
        }
        return ccc;
    }
}
