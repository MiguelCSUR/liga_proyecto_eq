//Criterios
//CREAR para Objetos propios. Ejemplos: Persona, Equipo, etc
//crearPartido() crearListaPartidos() crearEquipo
//Si creas un array de X será crearListaX(). Ejemplo crearJugador(), crearListaJugadores()

//GENERAR para atributos, propiedades, parámetros que no sean objetos propios
//generarNombre()
//Ejemplo: String, int, Integer, etc

package controller;

import data.Nombres;
import model.Liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invocador {

    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //DATE
    public static String dateToString (LocalDate fecha){
        return fecha.format(FORMATOFECHA);
    }
    public static LocalDate stringToDate (String fecha){
        return LocalDate.parse(fecha, FORMATOFECHA);
    }



    //TODO: PERSONA - PABLO



    //TODO: JUGADOR - PABLO
    //TODO: ENTRENADOR - PABLO
    //TODO: ARBITRO - PABLO
    //TODO: EQUIPO - NACHO
    //TODO: PARTIDO - MIGUE
    //TODO: JORNADA - NACHO
    //TODO: CALENDARIO - MIGUE
    //TODO: CLASIFICACION - PABLO
    //TODO: LIGA - MIGUEL
    public static Liga crearLiga() {
        Liga liga = new Liga(generadorNombresLiga());
        return liga;
    }

    public static String generadorNombresLiga() {
        int nombre = (int) Math.floor(Math.random() * Nombres.ligaNombres().length);
        return Nombres.ligaNombres()[nombre];
    }


}
