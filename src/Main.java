import model.*;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        //Instaciar Equipo
        Equipo equipo1 = new Equipo();

        //Asignar lista de jugadores al equipo
        Jugador[] listaJugadores = crearJugadores("Juvenil");
        equipo1.setJugadores(listaJugadores);

        //PARTIDO

    }

    //Crea un array de jugadores, con un tam variable entre 11 y 20,
    //Este tamaño: numJugadores, sale de Equipo.java
    public static Jugador[] crearJugadores(String categoria) {
        int numJugadores = Equipo.asigNumJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        Equipo equipo = new Equipo();

        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador(categoria, i+1);
            jugador.setEquipo(equipo);
            jugadores[i] = jugador;
        }
        return jugadores;
    }

}
