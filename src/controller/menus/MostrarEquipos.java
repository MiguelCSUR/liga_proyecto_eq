package controller.menus;

import controller.Invocador;
import model.Equipo;
import model.Jugador;
import model.Liga;

import java.util.Scanner;
import java.util.SortedMap;

public class MostrarEquipos {
    public static void iniciarMenu(Liga liga) {
        printMostrarMenu(liga);
    }

    public static void printMostrarMenu(Liga liga) {
        System.out.println("EQUIPOS:");
        System.out.println("1. Mostrar lista de equipos.");
        System.out.println("2. Mostrar platilla de un equipo.");
        System.out.println("3. Modificar un equipos.");
        System.out.println("4. Volver.");
        inputMostrarEquipos(liga);
    }

    public static void inputMostrarEquipos(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Equipo[] listaEquipo = liga.getListaEquipos();
        int numeroEquipo = 0;
        switch (seleccion) {
            case 1:
                Invocador.mostrarListaEquipos(listaEquipo, false);
                iniciarMenu(liga);
                break;
            case 2:
                Invocador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo para mostrar su plantilla: ");
                numeroEquipo = input.nextInt();
                while(numeroEquipo < 1 || numeroEquipo > listaEquipo.length) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroEquipo = input.nextInt();
                }
                Invocador.mostarPlantilla(listaEquipo[numeroEquipo - 1], false);
                iniciarMenu(liga);
                break;
            case 3:
                Invocador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();
                while(numeroEquipo < 1 || numeroEquipo > listaEquipo.length) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroEquipo = input.nextInt();
                }
                printModificarEquipo(liga);
                inputModificarEquipo(liga, numeroEquipo);
                break;
            case 4:
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                break;
        }
    }
    public static void printModificarEquipo(Liga liga) {
        System.out.println("EQUIPO:");
        System.out.println("1. Modificar Nombre del Equipo.");
        System.out.println("2. Modificar Nombre del Club.");
        System.out.println("3. Modificar Plantilla.");
        System.out.println("4. Volver.");
    }

    public static void inputModificarEquipo(Liga liga, int numeroEquipo) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Equipo equipo = liga.getListaEquipos()[numeroEquipo];
        Jugador[] listaJugadores = equipo.getJugadores();
        switch (seleccion) {
            case 1:
                //TODO: Mod nombre del equipo
                break;
            case 2:
                //TODO: Mod nombre del club
                break;
            case 3:
                Invocador.mostarPlantilla(equipo, true);
                System.out.print("Elige un jugador o entrenador: ");
                numeroEquipo = input.nextInt();
                while(numeroEquipo < 1 || numeroEquipo > (listaJugadores.length + 1)) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroEquipo = input.nextInt();
                }
                //TODO: Mod plantilla
                break;
            case 4:
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es correcta. Elige otra.");
                iniciarMenu(liga);
                break;
        }
    }
}

