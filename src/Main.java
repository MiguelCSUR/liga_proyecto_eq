import controller.Invocador;
import controller.Mostrador;
import controller.menus.*;
import model.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.*;
//import static model.Liga.crearEquipo;

public class Main {
    //static Liga liga = Invocador.crearLiga();

    public static void main(String[] args) throws ParseException {

        Liga liga = Invocador.crearLiga();
//        Invocador.mostrarClasificacion(liga);

//        System.out.println("Numero de Rondas" + Invocador.calcularNumeroJornadas(liga.getListaEquipos().length));


        //TODO: DEBUG - jugar Jornanda, luego en mostartCalendarioConGoles, los goles estan a 0
//        Invocador.jugarJornada(liga, 2);

//        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(liga.getCalendario().getListaJornadas()[0].getlistaPartidos()[0].getEquipoCasa().getClub());
//        System.out.println(liga.getCalendario().getListaJornadas()[0].getlistaPartidos()[0].getGolesEquipoCasa());
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
//
//        Invocador.mostrarCalendarioConGoles(liga);
//
//        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(liga.getCalendario().getListaJornadas()[0].getlistaPartidos()[0].getEquipoCasa().getClub());
//        System.out.println(liga.getCalendario().getListaJornadas()[0].getlistaPartidos()[0].getGolesEquipoCasa());
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");

        //TODO: DEBUG
//        GenerarLiga.iniciarImprimirMenuLiga();
//        Invocador.mostrarCalendario(liga);
//        GenerarLiga.iniciarImprimirMenuLiga();

        MostrarEquipos.iniciarMenu(liga);
    }
}