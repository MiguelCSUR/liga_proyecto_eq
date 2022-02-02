import model.*;

public class Main {

    public static void main(String[] args) {

        //Inicializamos las probabilidades de Goles, una vez
        int[] probabilidadGoles = generadorProbabilidades();

        //Instaciar Equipo
        Equipo equipo1 = new Equipo();

        //Asignar lista de jugadores al equipo
        Jugador[] listaJugadores = crearJugadores("Juvenil");
        equipo1.setJugadores(listaJugadores);

        //PARTIDO
        Partido partido = crearPartido("Juvenil");

        //TODO: quedan por asignar los goles
    }

    //Generador de probabilidades, lo llamamos 1 vez
    public static int[] generadorProbabilidades() {

        int[] probabilidad = new int[100];

        for (int i = 0; i < probabilidad.length; i++) {
            if (i <= 24) {
                probabilidad[i] = 1;
            }
            if (i > 24 && i <= 49) {
                probabilidad[i] = 2;
            }
            if (i > 49 && i <= 69) {
                probabilidad[i] = 3;
            }
            if (i > 69 && i <= 89) {
                probabilidad[i] = 0;
            }
            if (i > 89 && i <= 96) {
                probabilidad[i] = 4;
            }
            if (i > 96 && i <= 99) {
                probabilidad[i] = 5;
            }
        }
        return probabilidad;
    }

    //Crea un array de jugadores, con un tam variable entre 11 y 20,
    //Este tamaño: numJugadores, sale de Equipo.java
    public static Jugador[] crearJugadores(String categoria) {
        int numJugadores = Equipo.asigNumJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        Equipo equipo = new Equipo();

        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador(categoria, i + 1);
            jugador.setEquipo(equipo);
            jugadores[i] = jugador;
        }
        return jugadores;
    }

    public static Equipo crearEquipo(String categoria) {
        Equipo equipo = new Equipo();
        equipo.setJugadores(crearJugadores(categoria));
        return equipo;
    }

    //Creamos partido nuevo
    public static Partido crearPartido(String categoria) {
        Equipo equipoCasa = crearEquipo(categoria);
        Equipo equipoFuera = crearEquipo(categoria);
        Arbitro arbitro = new Arbitro();
        Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

        return partido;
    }
}

