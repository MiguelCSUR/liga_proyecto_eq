package controller;

import data.Nombres;
import model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class Mostrador {

    //JUGADORES
    public static void mostrarListaJugadores(Equipo equipo, boolean estanNumerados) {
        Jugador[] listaJugadores = equipo.getJugadores();
        if (estanNumerados) {
            System.out.println("    Jugadores: ");
            for (int i = 0; i < listaJugadores.length; i++) {
                Jugador jugador = listaJugadores[i];
                System.out.printf("\t%2d. Nombre: " + jugador.getNombre() + jugador.getApellidos() + "\n", (i + 1));
                System.out.println("\t    Dorsal: " + jugador.getDorsal());
                System.out.println("\t    Edad: " + jugador.getEdad());
                System.out.println("\t    Posición: " + jugador.getPosicion());
                System.out.println();
            }
        } else {
            System.out.println("Jugadores: ");
            for (int i = 0; i < listaJugadores.length; i++) {
                Jugador jugador = listaJugadores[i];
                System.out.println("\tNombre: " + jugador.getNombre() + jugador.getApellidos());
                System.out.println("\tDorsal: " + jugador.getDorsal());
                System.out.println("\tEdad: " + jugador.getEdad());
                System.out.println("\tPosición: " + jugador.getPosicion());
                System.out.println();
            }
        }
    }
    public static void mostrarJugador(Jugador jugador, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("\t1. Nombre: " + jugador.getNombre() + jugador.getApellidos());
            System.out.println("\t2. Dorsal: " + jugador.getDorsal());
            System.out.println("\t3. Edad: " + jugador.getEdad());
            System.out.println("\t4. Posición: " + jugador.getPosicion());
            System.out.println();
        } else {
            System.out.println("\tNombre: " + jugador.getNombre() + jugador.getApellidos());
            System.out.println("\tDorsal: " + jugador.getDorsal());
            System.out.println("\tEdad: " + jugador.getEdad());
            System.out.println("\tPosición: " + jugador.getPosicion());
            System.out.println();
        }
    }

    //EQUIPOS
    public static void mostrarEquipo(Equipo equipo, boolean estanNumerados) {
        Entrenador entrenador = equipo.getEntrenador();
        if (estanNumerados) {
            System.out.println("1. Nombre equipo: " + equipo.getNombre());
            System.out.println("2. Nombre club: " + equipo.getClub());
            System.out.println("3. Categoria: " + equipo.getJugadores()[0].getCategoria());
        } else {
            System.out.println("Nombre equipo: " + equipo.getNombre());
            System.out.println("Nombre club: " + equipo.getClub());
            System.out.println("Categoria: " + equipo.getJugadores()[0].getCategoria());
            System.out.println("Equipación Casa: " + equipo.getEquipacionCasa());
            System.out.println("Equipación Fuera: " + equipo.getEquipacionCasa());
        }
    }
    //Si le pasas true, te numero los equipos, false no los numera
    public static void mostrarListaEquipos(Equipo[] listaEquipo, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("     Número total de equipos: " + listaEquipo.length + ".\n");
            for (int i = 0; i < listaEquipo.length; i++) {
                System.out.printf("%3d. %s\n", (i + 1), listaEquipo[i].getNombre());
                System.out.println("     " + listaEquipo[i].getClub());
                System.out.println();
            }
        } else {
            System.out.println("Número total de equipos: " + listaEquipo.length + ".\n");
            for (int i = 0; i < listaEquipo.length; i++) {
                System.out.println(listaEquipo[i].getNombre());
                System.out.println(listaEquipo[i].getClub());
                System.out.println();
            }
        }
    }

    //ENTRENADOR
    public static void mostrarEntrenador(Entrenador entrenador, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("    Entrenador: ");
            System.out.println("\t1. Nombre: " + entrenador.getNombre() + entrenador.getApellidos());
            System.out.println("\t2. Edad: " + entrenador.getEdad());
            System.out.println("\t3. Licencia: " + entrenador.getNumeroLicencia());
        } else {
            System.out.println("Entreador: ");
            System.out.println("\tNombre: " + entrenador.getNombre() + entrenador.getApellidos());
            System.out.println("\tEdad: " + entrenador.getEdad());
            System.out.println("\tLicencia: " + entrenador.getNumeroLicencia());
        }
    }

    //CALENDARIO
    //Falta asignar horas a la lista de partidos, que no hay lista de partidos.
    public static void mostrarCalendario(Liga liga, int numeroJornadas) {
        int maximoJornadas = liga.getCalendario().getListaJornadas().length;
        //Para mostar la jornada 5 que es la posicion array 6.

        if (numeroJornadas > maximoJornadas) {
            numeroJornadas = maximoJornadas;
        } else if (numeroJornadas < 0) {
            numeroJornadas = 0;
        }

        Calendario calendario = Invocador.crearCalendario(liga);
        Jornada[] listaJornadas = calendario.getListaJornadas();

        int contadorJornadas = 1;
        for (int i = 0; i < numeroJornadas; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            if (i != 0) System.out.println("───────────────────────────────────────────────────────");
            System.out.println("\nJornada " + contadorJornadas + ".\n");
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                System.out.printf("\tPartido " + partido.getNumeroPartido() + ". %27s %5s\n", Invocador.dateToString(partido.getFecha()), partido.getHoraInicio());
                System.out.printf("\t%-20s  VS  %20s\n", "Casa", "Visitante");
                System.out.printf("\t%-20s      %20s\n\n", partido.getEquipoCasa().getClub(), partido.getEquipoFuera().getClub());
                
                if (i < liga.getUltimaJornadaJugada()){
                    int golesCasa = liga.getCalendario().getListaJornadas()[i].getlistaPartidos()[j].getGolesEquipoCasa();
                    int golesFuera = liga.getCalendario().getListaJornadas()[i].getlistaPartidos()[j].getGolesEquipoFuera();

                    System.out.println();
                    System.out.println("\t\t  Goles Casa \t\t Goles Fuera");
                    System.out.println("\t\t\t   "+golesCasa+"\tVS\t "+golesFuera+"\t");
                }
            }
            contadorJornadas++;
        }
    }

    public static void mostrarCalendario(Liga liga) {
        int numeroJornadas = liga.getCalendario().getListaJornadas().length;

        mostrarCalendario(liga, numeroJornadas);
    }

    public static void mostrarCalendarioConGoles(Liga liga) {
        int numeroJornadas = liga.getUltimaJornadaJugada();
        int maximoJornadas = liga.getCalendario().getListaJornadas().length;
        //Para mostar la jornada 5 que es la posicion array 6.

        if (numeroJornadas > maximoJornadas) {
            numeroJornadas = maximoJornadas;
        } else if (numeroJornadas < 0) {
            numeroJornadas = 0;
        }

        Calendario calendario = Invocador.crearCalendario(liga);
        Jornada[] listaJornadas = calendario.getListaJornadas();

        int contadorJornadas = 1;
        for (int i = 0; i < numeroJornadas; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            if (i != 0) System.out.println("───────────────────────────────────────────────────────");
            System.out.println("\nJornada " + contadorJornadas + ".\n");
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                System.out.printf("\tPartido %4s. %25s %6s\n", partido.getNumeroPartido(), Invocador.dateToString(partido.getFecha()), partido.getHoraInicio());
                System.out.printf("\t%-20s  VS  %20s\n", "Casa", "Visitante");
                System.out.printf("\t%-20s      %20s\n", partido.getEquipoCasa().getClub(), partido.getEquipoFuera().getClub());
                System.out.printf("\t%10s%-10s      %10s%-10s\n\n", "Goles: ", partido.getGolesEquipoCasa(), "Goles: ", partido.getGolesEquipoFuera());
            }
            contadorJornadas++;
        }
    }
    //CLASIFICACION
    public static void mostrarClasificacion(Liga liga) {
        Equipo[] listaEquipos = liga.getListaEquipos();
        Equipo[] clasificacion = Invocador.clasificarEquipos(listaEquipos);
        if (liga.getUltimaJornadaJugada() > 1) {
            System.out.println("Jornada " + (liga.getUltimaJornadaJugada()) + ".");
        } else {
            System.out.println("Jornada no ha empezado.");
        }
        System.out.printf("%-23s      %5s%5s\n", "Nombre", "P", "G");
        System.out.println("────────────────────────────────────────");
        for (int i = clasificacion.length - 1; i >= 0; i--) {
            System.out.printf("%-23s      %5s%5s\n\n", clasificacion[i].getClub(),
                    clasificacion[i].getPuntos(), clasificacion[i].getGoles());
        }
        System.out.println("(P : Puntos totales, G : Goles totales)");
    }


    //PARTIDOS
    public static void mostrarPartido(Partido partido){

        System.out.println("Partido "+partido.getNumeroPartido()+":");
        System.out.println("────────────────────────────────────────────");
        System.out.println("Equipos Casa: "+partido.getEquipoCasa().getNombre()+"        "+partido.getEquipoCasa().getClub());
        System.out.println("Equipos Fuera: "+partido.getEquipoFuera().getNombre()+"        "+partido.getEquipoFuera().getClub());

        System.out.println("Goles Casa: "+partido.getGolesEquipoCasa()+"                "+
                "Goles Fuera: "+partido.getGolesEquipoFuera());

        System.out.println("Equipación de Casa: "+partido.getEquipoCasa().getEquipacionCasa());
        System.out.println("Equipación de Fuera: "+partido.getEquipoFuera().getEquipacionFuera());

        System.out.println("Árbitro: "+partido.getArbitro().getNombre()+ " " +partido.getArbitro().getApellidos());
        System.out.println("Empezó en "+partido.getFecha()+" a las "+partido.getHoraInicio());
        System.out.println();
        System.out.println();
    }

    public static void mostrarListaPartido(Liga liga){
        Partido [] listaPartidos = liga.getCalendario().getListaPartidos();
        int ultimoPartidoJugado = liga.getUltimaJornadaJugada()*liga.getCalendario().getListaJornadas()[0].getlistaPartidos().length;

        for(int i = 0 ; i < ultimoPartidoJugado ; i++){
            mostrarPartido(listaPartidos[i]);
        }
    }

    public static void mostrarCompromisosPartidos(Liga liga, Equipo equipo) {

        Jornada[] listaJornadas = liga.getCalendario().getListaJornadas();
        System.out.println("Equipo:");
        System.out.println(equipo.getNombre());
        System.out.println(equipo.getClub());
        System.out.println("Enfrentamientos contra:");

        for (int i = 0; i < listaJornadas.length; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                if (equipo == partido.getEquipoCasa()) {
                    System.out.printf("\tPartido " + partido.getNumeroPartido() + ". %27s %5s\n", Invocador.dateToString(partido.getFecha()), partido.getHoraInicio());
                    System.out.printf("\t%s\n", partido.getEquipoFuera().getNombre());
                    System.out.printf("\t%s\n", partido.getEquipoFuera().getClub());
                    System.out.println();
                } else if (equipo == partido.getEquipoFuera()) {
                    System.out.printf("\tPartido " + partido.getNumeroPartido() + ". %27s %5s\n", Invocador.dateToString(partido.getFecha()), partido.getHoraInicio());
                    System.out.printf("\t%s\n", partido.getEquipoCasa().getNombre());
                    System.out.printf("\t%s\n", partido.getEquipoCasa().getClub());
                    System.out.println();
                }
            }
        }
    }

}


