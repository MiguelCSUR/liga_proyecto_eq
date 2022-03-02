import controller.Invocador;
import controller.Mostrador;
import controller.menus.*;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        GenerarLiga.iniciarImprimirMenuLiga();
    }
}