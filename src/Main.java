import controller.Invocador;
import controller.menus.Menu;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
//import static model.Liga.crearEquipo;

public class Main {
    final static String[] LISTACATEGORIAS = {"Chupetín", "Prebenjamín", "Benjamín", "Alevín", "Infantil", "Cadete", "Juvenil"};


    public static void main(String[] args) throws ParseException {

        Liga liga = Invocador.crearLiga();
        Invocador.mostrarClasificacion(liga);
//        Invocador.mostrarCalendario(liga);

    }
}