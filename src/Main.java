import controller.Invocador;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
import static model.Liga.crearEquipo;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) throws ParseException {

        Liga liga = new Liga(Invocador.stringToDate("20-02-2022"), 20, "Chupetín");
        for (int i = 0; i < liga.getListaArbitros().length; i++) {
            System.out.println(
                    liga.getListaArbitros()[i].getNombre()
            );
        }
        for (int i = 0; i < liga.getListaEquipos().length; i++) {
            System.out.println(
                    liga.getListaEquipos()[i].getNombre()
            );
        }

        Equipo[] listaEquipos = liga.getListaEquipos();
        for (int i = 0; i < listaEquipos.length; i++) {
            listaEquipos[i] = Invocador.crearEquipo("Juvenil");
        }
        Arbitro[] listaArbitro = liga.getListaArbitros();

        Jornada[] listaJornadas = crearListaJornadas(listaEquipos, listaArbitro);
        for (int i = 0; i < listaJornadas.length; i++) {
            System.out.println("Jornada numero " + i);
            Jornada temporal = listaJornadas[i];
            System.out.println(temporal.getlistaPartidos().length);
            for (int j = 0; j < temporal.getlistaPartidos().length; j++) {
                System.out.println(temporal.getlistaPartidos()[j].toString());
            }
        }
    } //FIN MAIN


        //Asigna las fechas a una lista de partidos
        public static void asignarHoraPartidos (Partido[]listaPartidos, LocalDate fechaInicial){
//        String[] listaHorarios = calendario.getListaHorarios();
            //TODO: hay que instanciar calendario
            String[] listaHorarios = {
                    "9:00", "10:30", "12:00", "16:00", "17:30", "19:00"
            };

            int i = 0;
            while (i < listaPartidos.length) {
                DayOfWeek diaSemana = fechaInicial.getDayOfWeek();
                if (diaSemana == SATURDAY || diaSemana == SUNDAY) {
                    //En findes semana se puede jugar por la mañana, los horarios de las posiciones 0, 1 y 2
                    int j = 0;
                    while (j < listaHorarios.length && i < listaPartidos.length) {
                        listaPartidos[i].setHoraInicio(listaHorarios[j]);
                        listaPartidos[i].setFecha(fechaInicial);
                        j++;
                        i++;
                    }
                } else {
                    //j son los partidos a partir de la tarde
                    int j = 3;
                    while (j < listaHorarios.length && i < listaPartidos.length) {
                        //Entre semana solo se juega por la tarde, los horarios de 3, 4 y 5
                        listaPartidos[i].setHoraInicio(listaHorarios[j]);
                        listaPartidos[i].setFecha(fechaInicial);
                        j++;
                        i++;
                    }
                }
                fechaInicial = fechaInicial.plusDays(1);
            }
        }

        //Generador de probabilidades, lo llamamos 1 vez
        public static int[] generadorProbabilidades () {

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

        public static int generadorGoles () {
            int numRamdon = (int) Math.floor(Math.random() * 100);
            return PROBABILIDADESGOLES[numRamdon];
        }

        //TODO: Borrar este método, cuando hagamos Clasificacion.java
        //PROVISIONAL Un método simple que comprueba el ganador, no devuelve nada solo imprime texto
        public static void asignarPuntos (Partido partido){
            Equipo equipoCasa = partido.getEquipoCasa();
            Equipo equipoFuera = partido.getEquipoFuera();

            if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
                //Empate
                equipoCasa.setPuntos(equipoCasa.getPuntos() + 1);
                equipoFuera.setPuntos(equipoFuera.getPuntos() + 1);
            } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
                //Gana Equipo Casa
                equipoCasa.setPuntos(equipoCasa.getPuntos() + 3);
            } else {
                //Gana Equipo Fuera
                equipoFuera.setPuntos(equipoFuera.getPuntos() + 3);
            }
        }

        //Crea un array de jugadores, con un tam variable entre 11 y 20,
        //Este tamaño: numJugadores, sale de Equipo.java

        public static Partido crearPartido (Equipo equipoCasa, Equipo equipoFuera, Arbitro arbitro){
            Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

            //Generamos los golesEquipoCasa
            int golesEquipoCasa = generadorGoles();
            //Seteamos los goles del Equipo casa, al partido en la propiedad partido.golesEquipoCasa
            partido.setGolesEquipoCasa(golesEquipoCasa);
            //Seteamos los goles del Equipo casa, al equipo en la propiedad equipo.goles
            //TODO: Este último paso es redundante eliminar en el futuro.
            equipoCasa.setGoles(equipoCasa.getGoles() + golesEquipoCasa);

            //Se repite el mismo proceso con golesEquipoFuera.
            int golesEquipoFuera = generadorGoles();
            partido.setGolesEquipoFuera(golesEquipoFuera);
            equipoFuera.setGoles(equipoFuera.getGoles() + golesEquipoFuera);

            //Se asignan los puntos
            asignarPuntos(partido);

            return partido;
        }

        //TODO: este metodo crea Ligas, por lo que seria,
        //TODO: public static Liga crearLiga(etc..)
        //TODO: posiblemente crearCalendario
        public static Jornada[] crearListaJornadas (Equipo[]listaEquipos, Arbitro[]listaArbitros){
            //x y son variables auxiliares para hacer facilmente "la elaboración de fixture" visto en https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
            //Creamos las variables que eligen el numero de partidos que hay
            int numeroEquipos = listaEquipos.length;
            int numeroPartidosEnTotal = (numeroEquipos * (numeroEquipos - 1)) / 2;
            int numeroRondas;
            int numeroPartidosPorRonda;


            if (numeroEquipos % 2 == 0) {
                numeroRondas = numeroEquipos - 1;
                numeroPartidosPorRonda = numeroEquipos / 2;
            } else {
                numeroRondas = numeroEquipos;
                numeroPartidosPorRonda = (numeroEquipos - 1) / 2;
            }
            Jornada[] listaJornadas = new Jornada[numeroRondas * 2];

            if (numeroEquipos % 2 == 0) {//para los pares
                for (int i = 0; i < numeroRondas; i++) {
                    Jornada jornada = new Jornada();
                    jornada.setListaPartidos(crearPartidosJornadaParIda(i, listaEquipos, listaArbitros));
                    listaJornadas[i] = jornada;
                }
                for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                    Jornada jornada = new Jornada();
                    jornada.setListaPartidos(crearPartidosJornadaParVuelta(i, listaEquipos, listaArbitros));
                    listaJornadas[i + numeroRondas] = jornada;
                }
            } else {//para los impares
                //para los impares hay que hacerlo como el numero par encima del impar, solo que saltandote la primera fila (j=0).
                //asi que hay que todo lo que tenga que ver con numEquipos y numPartidosPorRonda se le suma uno.
                for (int i = 0; i < numeroRondas; i++) {
                    Jornada jornada = new Jornada();
                    jornada.setListaPartidos(crearPartidosJornadaImparIda(i, listaEquipos, listaArbitros));
                    listaJornadas[i] = jornada;
                }
                for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                    Jornada jornada = new Jornada();
                    jornada.setListaPartidos(crearPartidosJornadaImparVuelta(i, listaEquipos, listaArbitros));
                    listaJornadas[i + numeroRondas] = jornada;

                }
            }
            System.out.println("Numero Partidos total: " + numeroPartidosEnTotal * 2);
            return listaJornadas;

        }

        public static Partido[] crearPartidosJornadaParIda ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
            int numeroEquipos = listaEquipos.length;
            int partidosPorRonda = numeroEquipos / 2;
            int x = 0;
            int y = numeroEquipos - 2;
            Partido[] partido = new Partido[partidosPorRonda];
            for (int j = 0; j < partidosPorRonda; j++) {
                if (j == 0) {
                    if (numeroJornada % 2 == 0)
                        partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                    else
                        partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                    x++;
                } else {
                    partido[j] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j]);
                    x++;
                    y--;
                }
                if (x > (numeroEquipos - 2)) x = 0;
                if (y < (0)) y = numeroEquipos - 2;
            }
            return partido;
        }

        public static Partido[] crearPartidosJornadaParVuelta ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
            int numeroEquipos = listaEquipos.length;
            int partidosPorRonda = numeroEquipos / 2;
            int x = 0;
            int y = numeroEquipos - 2;
            Partido[] partido = new Partido[partidosPorRonda];
            for (int j = 0; j < partidosPorRonda; j++) {
                if (j == 0) {
                    if (numeroJornada % 2 == 0)
                        partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                    else
                        partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                    x++;
                } else {
                    partido[j] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j]);
                    x++;
                    y--;
                }
                if (x > (numeroEquipos - 2)) x = 0;
                if (y < (0)) y = numeroEquipos - 2;
            }
            return partido;
        }

        public static Partido[] crearPartidosJornadaImparIda ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
            int numeroEquipos = listaEquipos.length;
            int partidosPorRonda = (numeroEquipos / 2) + 1;
            int x = 0;
            int y = numeroEquipos - 1;
            Partido[] partido = new Partido[partidosPorRonda - 1];
            for (int j = 0; j < partidosPorRonda; j++) {
                if (j == 0) {
                    x++;
                } else {
                    partido[j - 1] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j - 1]);
                    x++;
                    y--;
                }
                if (x > (numeroEquipos - 1)) x = 0;
                if (y < (0)) y = numeroEquipos - 1;
            }
            return partido;
        }

        public static Partido[] crearPartidosJornadaImparVuelta ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
            int numeroEquipos = listaEquipos.length;
            int partidosPorRonda = (numeroEquipos / 2) + 1;
            int x = 0;
            int y = numeroEquipos - 1;
            Partido[] partido = new Partido[partidosPorRonda - 1];
            for (int j = 0; j < partidosPorRonda; j++) {
                if (j == 0) {
                    x++;
                } else {
                    partido[j - 1] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j - 1]);
                    x++;
                    y--;
                }
                if (x > (numeroEquipos - 1)) x = 0;
                if (y < (0)) y = numeroEquipos - 1;
            }

            return partido;
        }
        public static Equipo[] ordenarEquipos (Equipo[]listaEquipos){

            Equipo aux;
            boolean cambios = true;//empieza true para meterse en el while

            while (cambios) {
                cambios = false;
                for (int i = 1; i < listaEquipos.length; i++) {
                    if (listaEquipos[i].getPuntos() < listaEquipos[i - 1].getPuntos()) {
                        aux = listaEquipos[i];
                        listaEquipos[i] = listaEquipos[i - 1];
                        listaEquipos[i - 1] = aux;
                        cambios = true;
                    } else if (listaEquipos[i].getPuntos() == listaEquipos[i - 1].getPuntos()) {//si los puntos son iguales se miran los goles
                        if (listaEquipos[i].getGoles() < listaEquipos[i - 1].getGoles()) {
                            aux = listaEquipos[i];
                            listaEquipos[i] = listaEquipos[i - 1];
                            listaEquipos[i - 1] = aux;
                            cambios = true;
                        }
                    }
                }
            }
            return listaEquipos;
        }

    }