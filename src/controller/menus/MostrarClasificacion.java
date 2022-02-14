package controller.menus;
import controller.Invocador;
import model.Liga;

import java.util.Scanner;

public class MostrarClasificacion {
    private Liga liga;

    public static void iniciarMenu(Liga liga) {
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        String textoNumeroJornada = "";
        if (liga.getUltimaJornadaJugada() > 0) {
            textoNumeroJornada = "La liga va por la jornada " + liga.getUltimaJornadaJugada();
            if (liga.getUltimaJornadaJugada() == (liga.getCalendario().getListaJornadas().length)) {
                textoNumeroJornada += " (última)";
            }
            textoNumeroJornada += ".";
        }
        System.out.println("CLASIFICACIÓN:");
        System.out.println("1. Mostrar selección de jornadas. " + textoNumeroJornada);
        System.out.println("2. Mostrar todas las jornadas.");
        System.out.println("3. Volver.");
        seleccionClasificacion(liga);
    }

    public static void seleccionClasificacion(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1:
                String textoNumeroJornada = "";
                if (liga.getUltimaJornadaJugada() > 0) {
                    textoNumeroJornada = "La liga va por la jornada " + liga.getUltimaJornadaJugada();
                    if (liga.getUltimaJornadaJugada() == (liga.getCalendario().getListaJornadas().length)) {
                        textoNumeroJornada += " (última)";
                    }
                    textoNumeroJornada += ".";
                } else {
                    textoNumeroJornada = "la liga no ha empezado.";
                }
                System.out.println("Elije la jornada que quieres mostrar, " + textoNumeroJornada); //TODO: Tal vez sea mejor poner Jugar
                int numeroJornadasJugar = input.nextInt();
                while (numeroJornadasJugar < liga.getUltimaJornadaJugada() || numeroJornadasJugar == 0) {
                    if (numeroJornadasJugar == 0) {
                        System.out.println("La Jornada 0, no existe, Elige otra.");
                    } else {
                        System.out.println("No puedes mostrar Clasificación de una Jornada anterior a la actual.");
                        System.out.println("Elige otra, " + textoNumeroJornada);
                    }
                    numeroJornadasJugar = input.nextInt();
                }
                Invocador.jugarJornada(liga, numeroJornadasJugar);
                Invocador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 2:
                Invocador.jugarJornada(liga, liga.getCalendario().getListaJornadas().length);
                Invocador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 3:
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es correcta. Elige otra.");
                imprimirMenu(liga);
                break;
        }
    }
}
