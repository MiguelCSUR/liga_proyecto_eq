import controller.Invocador;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
//import static model.Liga.crearEquipo;

public class Main {
    public static void main(String[] args) throws ParseException {

        Liga liga = Invocador.crearLiga();
        Calendario calendario = Invocador.crearCalendario(liga);
        Jornada[] listaJornadas = calendario.getListaJornadas();

        int contadorJornadas = 1;
        int contadorPartidos = 1;
        for (int i = 0; i < listaJornadas.length; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            System.out.println(contadorJornadas + ". Jornada\n");
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                System.out.println(contadorPartidos + ". Partido");
                System.out.printf("\t%10s        %10s\n", "Casa", "Visitante");
                System.out.printf("\t%10s contra %10s\n", partido.getEquipoCasa(), partido.getEquipoFuera());
                System.out.printf("\t%5s         %5s\n", partido.getGolesEquipoCasa(), partido.getGolesEquipoFuera());

            }
        }

    }
}