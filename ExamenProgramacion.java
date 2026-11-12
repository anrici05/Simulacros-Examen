package clase.simulacroExamen;

import java.util.Arrays;
import java.util.Scanner;


public class ExamenProgramacion {
    public static void main(String[] args) {

        System.out.println("Bienvenido al menú.");

        String op = "";
        while (!op.equals("6")) {

            menu();


            System.out.print("Escribe el número que quiere seleccionar:");
            Scanner entrada = new Scanner(System.in);
            op = entrada.nextLine();
            System.out.println("Has pulsado" + " " + op);

            if (op.equals("1")) {
                System.out.print("Introduzca un número aleatorio:");
                String valor = "";
                Scanner pares = new Scanner(System.in);
                valor = pares.nextLine();

                System.out.println(pares(valor));

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");

            } else if (op.equals("2")) {
                System.out.print("Escriba una frase en minúscula:");
                String frase = "";
                Scanner capital = new Scanner(System.in);
                frase = capital.nextLine();

                System.out.println(capitales(frase));

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");

            } else if (op.equals("3")) {
                System.out.println("Inserte una frase:");
                Scanner b = new Scanner(System.in);
                String frase = "";
                frase = b.nextLine();

                Object[] letra = vocal(frase);
                System.out.println("La vocal más repetida es:" + " " + letra[0]);
                System.out.println("Se ha repetido" + " " + letra[1] + " " + "veces");

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");

            } else if (op.equals("4")) {
                System.out.println("Inserte 10 números reales:");
                Scanner c = new Scanner(System.in);
                String numeros = c.nextLine();

                System.out.println(reales(numeros));

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");

            } else if (op.equals("5")) {
                System.out.println("Inserte múltiples números enteros:");
                Scanner d = new Scanner(System.in);
                String lista = "";
                lista = d.nextLine();
                System.out.println(Arrays.toString(inversos(lista)));

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");

            } else if (!op.equals("6")) {
                System.out.println("El número introducido no es válido.");

                System.out.println("-------------------------------------------------------");
                System.out.println("Estás de vuelta en el menú.");
            }
        }

        System.out.println("¡¡Hasta la próxima!!");


    }


    private static int[] inversos(String lista) {

        String[] partes = lista.split(",");


        int[] inversa = new int[partes.length];
        int j = 0;

        for (int i = partes.length - 1; i >= 0; i--) {
            inversa[j] = Integer.parseInt(partes[i].trim());
            j++;
        }

        return inversa;

    }

    private static String reales(String numeros) {

        String[] partes = numeros.split(",");

        double[] lista = new double[10];

        int j = 0;

        for (int i = 0; i < partes.length; i++) {
            lista[j] = Double.parseDouble(partes[i].trim());
            j++;
        }
        double suma = 0;
        double media = 0;
        double max = lista[0];
        double min = lista[0];

        for (int i = 0; i < lista.length; i++) {
            suma = suma + lista[i];
            media = suma / lista.length;


            if (lista[i] > max) {
                max = lista[i];
            }
            if (lista[i] < min) {
                min = lista[i];
            }

        }
        String medias = String.valueOf(media);
        String maximo = String.valueOf(max);
        String minimo = String.valueOf(min);

        return "La media es:" + medias + "." + "\n" + "El valor máximo es:" + maximo + "." + "\n" + "El valor mínimo es:" + minimo + ".";
    }

    private static Object[] vocal(String frase) {


        int contadorA = 0;
        int contadorE = 0;
        int contadorI = 0;
        int contadorO = 0;
        int contadorU = 0;


        for (int i = 0; i < frase.length(); i++) {

            if (('a' == frase.charAt(i) || 'A' == frase.charAt(i))) {
                contadorA++;
            } else if ('e' == frase.charAt(i) || 'E' == frase.charAt(i)) {
                contadorE++;
            } else if ('i' == frase.charAt(i) || 'I' == frase.charAt(i)) {
                contadorI++;
            } else if ('o' == frase.charAt(i) || 'O' == frase.charAt(i)) {
                contadorO++;
            } else if ('u' == frase.charAt(i) || 'U' == frase.charAt(i)) {
                contadorU++;
            }
        }

        int valor = contadorA;
        char vocal = 'a';


        if (contadorE > valor) {
            vocal = 'e';
            valor = contadorE;
        }
        if (contadorI > valor) {
            vocal = 'i';
            valor = contadorI;
        }
        if (contadorO > valor) {
            vocal = 'o';
            valor = contadorO;
        }
        if (contadorU > valor) {
            vocal = 'u';
            valor = contadorU;
        }
        return new Object[]{vocal, valor};
    }

    private static String capitales(String frase) {

        String inicial = String.valueOf(frase.charAt(0));
        String capital = inicial.toUpperCase();

        String nuevaOracion = capital;

        for (int i = 1; i < frase.length(); i++) {


            if (i >= 2 && frase.charAt(i - 2) == '.' && frase.charAt(i - 1) == ' ') {
                String mayus = String.valueOf(frase.charAt(i));
                nuevaOracion = nuevaOracion + mayus.toUpperCase();
            } else {
                nuevaOracion = nuevaOracion + frase.charAt(i);
            }
        }
        return nuevaOracion;
    }

    private static String pares(String valor) {

        int numero = Integer.parseInt(valor);

        String listaPares = "";
        int contadorPares = 0;

        int siguiente = numero + 1;
        int siguiente2 = numero + 2;

        if (numero % 2 == 0) {
            while (contadorPares != 10) {

                if (siguiente2 % 2 == 0) {
                    contadorPares++;

                    String NumeroString = String.valueOf(siguiente2);
                    if(listaPares.isEmpty()){
                        listaPares = NumeroString;
                    }else {
                        listaPares = listaPares + "," + NumeroString;
                    }
                }
                siguiente2++;
            }
        } else if (numero % 2 != 0) {
            while (contadorPares != 10) {

                if (siguiente % 2 == 0) {
                    contadorPares++;

                    String NumeroString = String.valueOf(siguiente);
                    if(listaPares.isEmpty()){
                        listaPares = NumeroString;
                    }else {
                        listaPares = listaPares + "," + NumeroString;
                    }
                }
                siguiente++;
            }

        }


        return listaPares.trim();
    }

    private static void menu() {
        System.out.println("1. Siguientes 10 números pares.");
        System.out.println("2. Capitalizar inicio de oraciones.");
        System.out.println("3. Vocal más frecuente.");
        System.out.println("4. Análisis de temperaturas estacionales (Arrays).");
        System.out.println("5. Inversión de vectores(Arrays).");
        System.out.println("6. Salir del programa.");
    }

}


