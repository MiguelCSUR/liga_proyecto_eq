import model.*;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) {

        //Instaciar Equipo
        Equipo equipo1 = new Equipo();

        //Asignar lista de jugadores al equipo
        Jugador[] listaJugadores = crearJugadores("Juvenil");
        equipo1.setJugadores(listaJugadores);

        //PARTIDO
        Partido partido = crearPartido("Juvenil");
        System.out.println(
                partido.toString()
        );

        //Aquí comprobamos el ganador
        comprobarGanador(partido);
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

    public static int generadorGoles() {
        int numRamdon = (int) Math.floor(Math.random() * 100);
        return PROBABILIDADESGOLES[numRamdon];
    }

    //TODO: Borrar este metodo, cuando hagamos Clasificacion.java
    //PROBISIONAL Un metodo simple que comprueba el ganador, no develve nada solo imprime texto
    public static void comprobarGanador(Partido partido) {
        if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s y %s han quedado en empate", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoFuera().getNombre(),
                    partido.getEquipoCasa().getNombre());
        }
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

    //Creamos el evento del partido, pero todabia no lo jugamos en este metodo
    public static Partido crearPartido(String categoria) {
        Equipo equipoCasa = crearEquipo(categoria);
        Equipo equipoFuera = crearEquipo(categoria);
        Arbitro arbitro = new Arbitro();
        Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

        partido.setGolesEquipoCasa(generadorGoles());
        partido.setGolesEquipoFuera(generadorGoles());

        return partido;
    }
}

