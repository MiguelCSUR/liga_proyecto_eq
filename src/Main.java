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

        for (int i = 0; i < calendario.getListaJornadas().length; i++) {

        }

    }
}