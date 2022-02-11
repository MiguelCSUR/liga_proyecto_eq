import controller.Invocador;
import controller.menus.Menu;
import controller.menus.MostrarClasificacion;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
//import static model.Liga.crearEquipo;

public class Main {
    static Liga liga = Invocador.crearLiga();

    public static void main(String[] args) throws ParseException {

        Liga liga = Invocador.crearLiga();
        Invocador.mostrarClasificacion(liga);
//        Invocador.mostrarCalendario(liga);

    }
}