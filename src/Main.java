import controller.Invocador;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
//import static model.Liga.crearEquipo;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static int[] PROBABILIDADESGOLES = Invocador.generadorProbabilidades();

    public static void main(String[] args) throws ParseException {

        Liga liga = new Liga(Invocador.stringToDate("20-02-2022"), "Chupetín");
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

        Jornada[] listaJornadas = Invocador.crearListaJornadas(listaEquipos, listaArbitro);
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

        //Generador de probabilidades, lo llamamos 1 vez



    }