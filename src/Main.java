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
    public static void main(String[] args) throws ParseException {
        Menu.comprobarResolución();
        System.out.println();
        System.out.println();

        Invocador.mostrarCalendario(Invocador.crearLiga());
    }


}