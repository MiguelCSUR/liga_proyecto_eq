package controller.menus;

import controller.Invocador;
import model.Equipo;
import model.Jugador;
import model.Liga;

import java.util.Scanner;

public class MostrarEquipos {
    public static void iniciarMenu(Liga liga) {
        printMostrarMenu(liga);
    }

    public static void printMostrarMenu(Liga liga) {
        System.out.println("LISTA DE EQUIPOS:");
        System.out.println("1. Mostrar lista de equipos.");
        System.out.println("2. Mostrar un equipo.");
        System.out.println("3. Modificar un equipo.");
        System.out.println("4. Volver.");
        inputMostrarEquipos(liga);
    }

    public static void inputMostrarEquipos(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Equipo[] listaEquipo = liga.getListaEquipos();
        int numeroEquipo = 0;
        switch (seleccion) {
            case 1: //1. Mostrar lista de equipos. HECHO
                Invocador.mostrarListaEquipos(listaEquipo, false);
                iniciarMenu(liga);
                break;
            case 2: //2. Mostrar un equipo. HECHO
                Invocador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();

                compruebaNumEquipoValido(numeroEquipo, listaEquipo);

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
        System.out.println("1. Nombre equipo: " + equipo.getNombre());
        System.out.println("2. Nombre club: " + equipo.getClub());
        System.out.println("3. Entrenador: " + equipo.getEntrenador().getNombre() + " "
                + equipo.getEntrenador().getApellidos());
        System.out.println("4. Jugadores.");
        System.out.println("5. Volver.");
        System.out.println();
        System.out.println("Elige una opción que modificar:");
        inputModificarEquipo(liga, equipo);
    }

    public static void inputModificarEquipo(Liga liga, Equipo equipo) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Jugador[] listaJugadores = equipo.getJugadores();
        switch (seleccion) {
            case 1: //1. Nombre equipo:
                System.out.println("Introduce un nombre: ");
                String nombre = introduceNombre();
                equipo.setNombre(nombre);
                printModificarEquipo(liga, equipo);
                break;
            case 2: //2. Nombre club: 
                System.out.println("Introduce un nombre de club: ");
                String club = introduceNombre();
                equipo.setClub(club);
                printModificarEquipo(liga, equipo);
                break;
            case 3: //3. Entrenador: TODO: Comprobar
                Invocador.mostrarEntrenador(equipo.getEntrenador(), true);
                //TODO: MENU ENTRENADOR
                break;
            case 4: //4. Jugadores. TODO: Comprobar
                Invocador.mostrarListaJugadores(equipo, true);
                System.out.print("Elige un jugador: ");
                int numeroJugador = input.nextInt();
                compruebaNumJugadorValido(numeroJugador, equipo);
                Invocador.mostrarJugador(equipo.getJugadores()[numeroJugador], true);
                //TODO: menu mod datos
                break;
            case 5: //5. Volver. TODO: Comprobar
                printMostrarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                printModificarEquipo(liga, equipo);
                break;
        }
    }

    public static void printModificadorJugador(Liga liga, Jugador jugador) {
        System.out.println("JUGADOR:");
        System.out.println("1. Dorsal: " + jugador.getDorsal());
        System.out.println("2. Nombre: " + jugador.getNombre() + " "
            + jugador.getApellidos());
        System.out.println("3. Edad: " + jugador.getEdad());
        System.out.println("4. Categoría: " + jugador.getCategoria());
        System.out.println("5. Posición: " + jugador.getPosicion());
        System.out.println("6. Volver.");
        System.out.println();
        System.out.println("Elige una opción que modificar:");
        inputModificadorJugador(liga, jugador);
    }

    public static void inputModificadorJugador(Liga liga, Jugador jugador) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1: //Dorsal
                //TODO: setDorsal
                break;
            case 2: //Nombre
                //TODO: setNombre
                break;
            case 3: //Edad
                //TODO: setEdad
                break;
            case 4: //Categoría
                //TODO: setCategoria
                break;
            case 5: //Posición
                //TODO: setPosicion
                break;
            case 6: //Volver
                printModificarEquipo(liga, jugador.getEquipo());
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                printModificadorJugador(liga, jugador);
                break;
        }
    }

        //HERRAMIENTAS

    public static int compruebaNumEquipoValido(int numeroEquipo, Equipo[] listaEquipo) {
        Scanner input = new Scanner(System.in);
        while (numeroEquipo < 1 || numeroEquipo > listaEquipo.length) {
            System.out.println("\nEse Equipo no existe.");
            System.out.print("Elige un equipo: ");
            numeroEquipo = input.nextInt();
        }
        return numeroEquipo;
    }

    public static int compruebaNumJugadorValido(int numeroJugador, Equipo equipo) {
        Scanner input = new Scanner(System.in);
        while (numeroJugador < 1 || numeroJugador > equipo.getJugadores().length) {
            System.out.println("\nEse jugador no existe.");
            System.out.print("Elige un jugador: ");
            numeroJugador = input.nextInt();
        }
        return numeroJugador;
    }

    public static String introduceNombre() {
        Scanner input = new Scanner(System.in);
        String nombre = input.nextLine();
        while (nombre.isEmpty()) {
            System.out.println("El campo no puede estar vacio.");
            System.out.println("Introduce otro nombre:");
            nombre = input.nextLine();
        }
        return nombre;
    }
}