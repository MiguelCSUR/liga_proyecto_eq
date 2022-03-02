package controller.menus;
import controller.Invocador;
import controller.Mostrador;
import model.Liga;

import java.util.Scanner;

public class MostrarClasificacion {
    private Liga liga;

    public static void iniciarMenu(Liga liga) {
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        System.out.printf("CLASIFICACIÓN (Liga de %d Jornadas):\n", liga.getCalendario().getListaJornadas().length);
        System.out.println("1. Mostrar Clasificación.");
        System.out.println("2. Jugar un numero de jornadas. " + textoNumeroJornada(liga));
        System.out.println("3. Jugar todas las jornadas.");
        System.out.println("4. Seleccionar hasta que jornada hacer reset.");
        System.out.println("5. Hacer reset de todas las jornadas.");
        System.out.println("6. Volver.");
        seleccionClasificacion(liga);
        Invocador.generarEspacio();
    }

    public static void seleccionClasificacion(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1:
                Mostrador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 2:
                System.out.println("Elige la jornada que quieres jugar, " + textoNumeroJornada(liga));
                int numeroJornadasJugar = inputJornadaJugar(liga);
                Invocador.jugarJornada(liga, numeroJornadasJugar);
                Mostrador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 3:
                Invocador.jugarJornada(liga, liga.getCalendario().getListaJornadas().length);
                Mostrador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 4:
                System.out.println("Elige una jornada a la que quieras volver, " + textoNumeroJornada(liga));
                System.out.println("(Los goles y los puntos se resetearan desde esta jornada en adelante.)");
                int jornadaHastaReset = inputJornadasReset(liga);
                Invocador.deshacerJornada(liga, jornadaHastaReset);
                Mostrador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 5:
                Invocador.deshacerJornada(liga, 0);
                Mostrador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 6:
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es correcta. Elige otra.");
                imprimirMenu(liga);
                break;
        }
    }

    //HERRAMIENTAS

    public static String textoNumeroJornada(Liga liga) {
        String textoNumeroJornada = "";
        if (liga.getUltimaJornadaJugada() > 0) {
            textoNumeroJornada = "La liga va por la jornada " + (liga.getUltimaJornadaJugada());
            if (liga.getUltimaJornadaJugada() == (liga.getCalendario().getListaJornadas().length)) {
                textoNumeroJornada += " (última)";
            }
            textoNumeroJornada += ".";
        } else {
            textoNumeroJornada = "la liga no ha empezado.";
        }
        return textoNumeroJornada;
    }

    public static int inputJornadaJugar(Liga liga) {
        Scanner input = new Scanner(System.in);
        int numeroJornadasJugar = input.nextInt();
        while (numeroJornadasJugar < liga.getUltimaJornadaJugada() || numeroJornadasJugar < 1 || numeroJornadasJugar > liga.getCalendario().getListaJornadas().length) {
            System.out.println("No puedes jugar esta clasificación, tienes que elegir una posterior a la actual, y menor que la última."); //TODO: revisar este texto
            System.out.println("Elige otra, " + textoNumeroJornada(liga));
            numeroJornadasJugar = input.nextInt();
        }

        return numeroJornadasJugar;
    }

    public static int inputJornadasReset(Liga liga) {
        Scanner input = new Scanner(System.in);
        int jornadaHastaResetear = input.nextInt();
        while (jornadaHastaResetear > liga.getUltimaJornadaJugada() || jornadaHastaResetear < 0 ) {
            System.out.println("La jornada tiene que ser menor que la ultima jornada jugada, y mayor que -1.");
            System.out.println("Elige otra, " + textoNumeroJornada(liga));
            jornadaHastaResetear = input.nextInt();
        }
        return jornadaHastaResetear;
    }
}
