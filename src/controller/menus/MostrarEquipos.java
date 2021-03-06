package controller.menus;

import controller.Invocador;
import controller.Mostrador;
import model.Entrenador;
import model.Equipo;
import model.Jugador;
import model.Liga;

import java.util.Scanner;

public class MostrarEquipos {
    public static void iniciarMenu(Liga liga) {
        printModificarListaEquipos(liga);
    }

    public static void printModificarListaEquipos(Liga liga) {
        System.out.println("LISTA DE EQUIPOS:");
        System.out.println("1. Mostrar lista de equipos.");
        System.out.println("2. Mostrar un equipo.");
        System.out.println("3. Modificar un equipo.");
        System.out.println("4. Mostrar compromisos de partidos de un equipo.");
        System.out.println("5. Volver.");
        System.out.println();
        System.out.println("Elige una opción: ");
        inputModificarListaEquipos(liga);
        Invocador.generarEspacio();
    }

    public static void inputModificarListaEquipos(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Equipo[] listaEquipo = liga.getListaEquipos();
        int numeroEquipo = 0;
        switch (seleccion) {
            case 1:
                Mostrador.mostrarListaEquipos(listaEquipo, false);
                iniciarMenu(liga);
                break;
            case 2:
                Mostrador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();
                numeroEquipo =  compruebaNumEquipoValido(numeroEquipo, listaEquipo);
                Equipo equipoMostrar = listaEquipo[numeroEquipo - 1];
                Mostrador.mostrarEquipo(equipoMostrar, false);
                Mostrador.mostrarEntrenador(equipoMostrar.getEntrenador(), false);
                Mostrador.mostrarListaJugadores(equipoMostrar, false);
                iniciarMenu(liga);
                break;
            case 3:
                Mostrador.mostrarListaEquipos(listaEquipo, true);
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
            case 4:
                Mostrador.mostrarListaEquipos(listaEquipo, true);
                System.out.print("Elige un equipo: ");
                numeroEquipo = input.nextInt();
                numeroEquipo =  compruebaNumEquipoValido(numeroEquipo, listaEquipo);
                Equipo equipoComprimiso = listaEquipo[numeroEquipo - 1];
                Mostrador.mostrarCompromisosPartidos(liga, equipoComprimiso);
                iniciarMenu(liga);
                break;
            case 5:
                MostrarPartidos.iniciarMenu(liga);
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                printModificarListaEquipos(liga);
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
        System.out.println("5. Formacion: "+ Invocador.obtenerFormacionEquipo(equipo));
        System.out.println("6. Volver.");
        System.out.println();
        System.out.println("Elige una opción:");
        inputModificarEquipo(liga, equipo);
        Invocador.generarEspacio();
    }

    public static void inputModificarEquipo(Liga liga, Equipo equipo) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        Jugador[] listaJugadores = equipo.getJugadores();
        switch (seleccion) {
            case 1:
                System.out.println("Introduce un nombre: ");
                String nombre = introduceTexto();
                equipo.setNombre(nombre);
                printModificarEquipo(liga, equipo);
                break;
            case 2:
                System.out.println("Introduce un nombre de club: ");
                String club = introduceTexto();
                equipo.setClub(club);
                printModificarEquipo(liga, equipo);
                break;
            case 3:
                printModificarEntrenador(liga, equipo.getEntrenador());
                break;
            case 4:
                Mostrador.mostrarListaJugadores(equipo, true);
                System.out.print("Elige un jugador: ");
                int numeroJugador = input.nextInt();
                numeroJugador = compruebaNumJugadorValido(numeroJugador, equipo);
                printModificarJugador(liga, listaJugadores[numeroJugador - 1]);
                break;
            case 5:
                System.out.println("1. Formacion 4-4-2");
                System.out.println("2. Formacion 4-3-3");
                System.out.println("3. Formacion 3-4-3");
                System.out.println("4. Formacion 5-4-1");
                System.out.print("Elige una formación: ");
                equipo = Invocador.cambiarFormacionEquipo(equipo,input.nextInt());
                printModificarEquipo(liga,equipo);
                break;
            case 6:
                printModificarListaEquipos(liga);
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                printModificarEquipo(liga, equipo);
                break;
        }
    }

    public static void printModificarJugador(Liga liga, Jugador jugador) {
        System.out.println("JUGADOR:");
        System.out.println("1. Dorsal: " + jugador.getDorsal());
        System.out.println("2. Nombre: " + jugador.getNombre() + " "
            + jugador.getApellidos());
        System.out.println("3. Edad: " + jugador.getEdad());
        System.out.println("4. Posición: " + jugador.getPosicion());
        System.out.println("5. Volver.");
        System.out.println();
        System.out.println("Elige una opción:");
        inputModificarJugador(liga, jugador);
    }

    public static void inputModificarJugador(Liga liga, Jugador jugador) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1:
                System.out.println("Introduce un numero de dorsal: ");
                jugador.setDorsal(introduceNumero());
                printModificarJugador(liga, jugador);
                break;
            case 2:
                System.out.println("Introduce un nombre: ");
                jugador.setNombre(introduceTexto());
                System.out.println("Introduce o varios apellidos: ");
                jugador.setApellidos(introduceTexto());
                printModificarJugador(liga, jugador);
                break;
            case 3:
                System.out.println("Introduce una edad: ");
                jugador.setEdad(introduceNumero());
                printModificarJugador(liga, jugador);
                break;
            case 4:
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce una opción: ");
                System.out.println("1. Portero");
                System.out.println("2. Defensa");
                System.out.println("3. Centrocampista");
                System.out.println("4. Delantero");
                int opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        jugador.setPosicion("Portero");
                    case 2:
                        jugador.setPosicion("Defensa");
                    case 3:
                        jugador.setPosicion("Centrocampista");
                    case 4:
                        jugador.setPosicion("Delantero");
                }
                break;
            case 5:
                printModificarEquipo(liga, jugador.getEquipo());
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                printModificarJugador(liga, jugador);
                break;
        }
    }

    public static void printModificarEntrenador(Liga liga, Entrenador entrenador) {
        System.out.println("ENTRENADOR:");
        System.out.println("1. Licencia: " + entrenador.getNumeroLicencia());
        System.out.println("2. Nombre: " + entrenador.getNombre() + entrenador.getApellidos());
        System.out.println("3. Edad: " + entrenador.getEdad());
        System.out.println("4. Volver.");
        System.out.println();
        System.out.println("Elige una opción:");
        inputModificarEntrenador(liga, entrenador);
        Invocador.generarEspacio();
    }

    public static void inputModificarEntrenador(Liga liga, Entrenador entrenador) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1:
                System.out.println("Introduce un numero de licencia: ");
                int licencia = input.nextInt();
                while (licencia < 0) {
                    System.out.println("La licencia tiene que ser mayor que 0");
                    licencia = input.nextInt();
                }
                entrenador.setNumeroLicencia(licencia);
                printModificarEntrenador(liga, entrenador);
                break;
            case 2:
                System.out.println("Introduce un nombre: ");
                entrenador.setNombre(introduceTexto());
                System.out.println("Introduce uno o varios apellidos: ");
                entrenador.setApellidos(introduceTexto());
                printModificarEntrenador(liga, entrenador);
                break;
            case 3:
                System.out.println("Introduce una edad: ");
                entrenador.setEdad(introduceNumero());
                printModificarEntrenador(liga, entrenador);
                break;
            case 4:
                printModificarEquipo(liga, entrenador.getEquipo());
                break;
            default:
                System.out.println("Esta opción no es existe. Elige otra.");
                inputModificarEntrenador(liga, entrenador);
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

    public static String introduceTexto() {
        Scanner input = new Scanner(System.in);
        String nombre = input.nextLine();
        while (nombre.isEmpty()) {
            System.out.println("El campo no puede estar vacio.");
            System.out.println("Introduce otro nombre:");
            nombre = input.nextLine();
        }
        return nombre;
    }

    public static int introduceNumero() {
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        while (numero < 0 || numero > 1000) {
            System.out.println("El numero no es valido.");
            System.out.println("Introduce otro numero:");
            numero = input.nextInt();
        }
        return numero;
    }
}