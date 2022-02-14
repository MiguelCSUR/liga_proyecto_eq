package controller.menus;

import controller.Invocador;
import model.Entrenador;
import model.Equipo;
import model.Jugador;
import model.Liga;

import java.util.Scanner;

public class MostrarEquipos {
    public static void iniciarMenu(Liga liga) {
        printMostrarMenu(liga);
    }

    public static void printMostrarMenu(Liga liga) {
        System.out.println("EQUIPOS:");
        System.out.println("1. Mostrar lista de equipos.");
        System.out.println("2. Mostrar un equipo.");
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
            case 1: //1. Mostrar lista de equipos.
                Invocador.mostrarListaEquipos(listaEquipo, false);
                iniciarMenu(liga);
                break;
            case 2: //2. Mostrar un equipo.
                Invocador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();
                while (numeroEquipo < 1 || numeroEquipo > listaEquipo.length) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroEquipo = input.nextInt();
                }
                Equipo equipoMostrar = listaEquipo[numeroEquipo - 1];
                Invocador.mostrarEquipo(equipoMostrar, false);
                Invocador.mostrarEntrenador(equipoMostrar.getEntrenador(), false);
                Invocador.mostrarListaJugadores(equipoMostrar, false);
                iniciarMenu(liga);
                break;
            case 3: //3. Modificar un equipos.
                Invocador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();
                while (numeroEquipo < 1 || numeroEquipo > listaEquipo.length) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroEquipo = input.nextInt();
                }
                Equipo equipoModificar = listaEquipo[numeroEquipo - 1];
                printModificarEquipo(liga, equipoModificar);
                break;
            case 4: //4. Volver.
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                break;
        }
    }

    public static void printModificarEquipo(Liga liga, Equipo equipo) {
        System.out.println("EQUIPO:");
        Invocador.mostrarEquipo(equipo, true);
        System.out.println("5. Modificar jugadores.");
        System.out.println("6. Volver.");
        inputModificarEquipo(liga, equipo);
    }

    public static void mostrarModificarEquipo(Liga liga, Equipo equipo) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Jugador[] listaJugadores = equipo.getJugadores();
        switch (seleccion) {
            case 1: //\t1. Nombre: " + jugador.getNombre() + jugador.getApellidos())
                //TODO: Mod set nombre del equipo
                break;
            case 2: //\t2. Dorsal: " + jugador.getDorsal()
                //TODO: Mod set nombre del club
                break;
            case 3: //\t3. Edad: " + jugador.getEdad()
                //TODO: Mod setEdad
                break;
            case 4: //\t4. Posición: " + jugador.getPosicion()
                //TODO: mod setPosicion
                break;
            case 5: //5. Modificar jugadores.
                Invocador.mostrarListaJugadores(equipo, true);
                System.out.print("Elige un jugador: ");
                int numeroJugador = input.nextInt();
                while (numeroJugador < 1 || numeroJugador > equipo.getJugadores().length) {
                    System.out.println("\nEse Equipo no existe.");
                    System.out.print("Elige un equipo: ");
                    numeroJugador = input.nextInt();
                }
                Invocador.mostrarJugador(equipo.getJugadores()[numeroJugador], true);
                //TODO: menu mod datos
                break;
            case 6: //6. Volver.
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es correcta. Elige otra.");
                printModificarEquipo(liga, equipo);
                break;
        }
    }
    public static void inputModificarEquipo(Liga liga, Equipo equipo) {
        //TODO: seleccion de lo que se quiere modifica del equipo
    }
}