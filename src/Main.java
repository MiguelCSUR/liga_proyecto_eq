import model.*;

import javax.swing.text.DateFormatter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.time.DayOfWeek.*;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) throws ParseException {

        //CALENDARIO

//        Calendar cal=Calendar.getInstance();
//        System.out.println("Time is "+cal.getTime());
//        String str=cal.toString();
//        System.out.println("Time is "+str);


        //CALENDARIO!!
        int numPartidos = 20;
//        LocalDate myObj = LocalDate.now(); // Create a date object
//        System.out.println(myObj); // Display the current date

        //Fecha Inicial Liga.
        String fechaInicial = "20-02-2222";
        LocalDate date = stringToDate(fechaInicial);

        //Sumar dias.
//        date = date.plusDays(1);

        //Coger dia del mes
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        DayOfWeek dayOfWeek1 = THURSDAY;
        //Comparar dias del mes
        if (dayOfWeek == dayOfWeek1) {
            System.out.println("Equivalente!");
        } else {
            System.out.println("NO equivalente");
        }

        String categoria = "Chupetin";
        Calendario calendario = new Calendario();
        Partido[] listaPartido = new Partido[numPartidos];
        Arbitro arbitro = new Arbitro();
        for (int i = 0; i < numPartidos; i++) {
            Partido partido = crearPartido(crearEquipo(categoria), crearEquipo(categoria), arbitro);
            partido.setNumeroPartido(i + 1);
            listaPartido[i] = partido;
        }

        asignarHoraPartidos(listaPartido, stringToDate(fechaInicial));

        //Printa Calendario
        for (Partido partido : listaPartido) {
            System.out.printf("El Partido %d será el %s, %s a las %s\n", partido.getNumeroPartido(),
                    dateToString(partido.getFecha()), partido.getFecha().getDayOfWeek(), partido.getHoraInicio());
        }

        {
//        System.out.println(
//                crearJornada(crearListaEquipo("Chupetin", 10), crearListaArbitro()).toString()
//        );

//        Equipo equipo1 = new Equipo();
//
//        //Asignar lista de jugadores al equipo
//        Jugador[] listaJugadores = crearJugadores("Juvenil");
//        equipo1.setJugadores(listaJugadores);
//
//        //PARTIDO
//        Partido partido = crearPartido("Juvenil");
//        System.out.println(
//                partido.toString()
//        );

            //Crear Jornada


            //Aquí comprobamos el ganador
//        comprobarGanador(partido);
        }
    }

    public static String dateToString(LocalDate fecha) {
        return fecha.format(FORMATOFECHA);
    }

    public static LocalDate stringToDate(String fecha) {
        return LocalDate.parse(fecha, FORMATOFECHA);
    }

    //Asigna las fechas a una lista de partidos
    public static void asignarHoraPartidos(Partido[] listaPartidos, LocalDate fechaInicial) {
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
                while (j < 6 && i < listaPartidos.length) {
                    listaPartidos[i].setHoraInicio(listaHorarios[j]);
                    listaPartidos[i].setFecha(fechaInicial);
                    j++;
                    i++;
                }
            } else {
                int j = 3;
                while (j < 6 && i < listaPartidos.length) {
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
    public static int[] generadorProbabilidades() {

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

    public static int generadorGoles() {
        int numRamdon = (int) Math.floor(Math.random() * 100);
        return PROBABILIDADESGOLES[numRamdon];
    }

    //TODO: Borrar este método, cuando hagamos Clasificacion.java
    //PROVISIONAL Un método simple que comprueba el ganador, no devuelve nada solo imprime texto
    public static void comprobarGanador(Partido partido) {
        if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s y %s han quedado en empate", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoFuera().getNombre(),
                    partido.getEquipoCasa().getNombre());
        }
    }

    //Crea un array de jugadores, con un tam variable entre 11 y 20,
    //Este tamaño: numJugadores, sale de Equipo.java
    public static Jugador[] crearJugadores(String categoria) {
        int numJugadores = Equipo.asigNumJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        Equipo equipo = new Equipo();

        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador(categoria, i + 1);
            jugador.setEquipo(equipo);
            jugadores[i] = jugador;
        }
        return jugadores;
    }

    public static Equipo crearEquipo(String categoria) {
        Equipo equipo = new Equipo();
        equipo.setJugadores(crearJugadores(categoria));
        return equipo;
    }

    //Crear lista de Equipos
    public static Equipo[] crearListaEquipo(String categoria, int numEquipos) {
        Equipo[] listaEquipos = new Equipo[numEquipos];
        for (int i = 0; i < 5; i++) {
            listaEquipos[i] = crearEquipo("Juvenil");
        }
        return listaEquipos;
    }

    //TODO: Esto es un creacion de lista de arbitros provisional para provar el crear las jornadas
    //RECORDAR QUE RAFA DIJO QUE NO NOS COMIERAMOS EL COCO Y QUE PUSIESEMOS int numeroArbitros = numeroEquipos/2;
    public static int numArbitros(int numEquipos) {
        int numArbitros = (int) Math.floor(numEquipos / 2);
        return numArbitros;
    }

    public static Arbitro[] crearListaArbitro() {
        int numeroArbitros = numArbitros(numeroEquipos());
        Arbitro[] listaArbitro = new Arbitro[numeroArbitros];
        for (int i = 0; i < numeroArbitros; i++) {
            Arbitro arbitro = new Arbitro();
            listaArbitro[i] = arbitro;
        }

        return listaArbitro;
    }


    //Creamos el evento del partido, pero todavía no lo jugamos en este método
    public static Partido crearPartido(Equipo eq1, Equipo eq2, Arbitro arbitro) {
        Equipo equipoCasa = eq1;
        Equipo equipoFuera = eq2;
        Partido partido = new Partido(eq1, eq2, arbitro);

        partido.setGolesEquipoCasa(generadorGoles());
        partido.setGolesEquipoFuera(generadorGoles());

        return partido;
    }

    //TODO: método provisional.
    //Pide un número de numeroEquipos, solo lo acepta si es mayor de 1.
    public static int numeroEquipos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de equipos: ");
        int numeroEquipos = sc.nextInt();
        while (numeroEquipos < 2) {
            System.out.println("\nSe necesitan mas de un equipo para una liga.");
            System.out.print("Introduce de nuevo otro número de equipos: ");
            numeroEquipos = sc.nextInt();
        }
        return numeroEquipos;
    }

    //TODO: este metodo crea Ligas, por lo que seria,
    //TODO: public static Liga crearLiga(etc..)
    public static Jornada crearJornada(Equipo[] listaEquipos, Arbitro[] listaArbitros) {

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

        Partido[][] rondas;
        rondas = new Partido[numeroRondas * 2][numeroPartidosPorRonda];
        rondas = crearListaJornadas(listaEquipos, listaArbitros, numeroEquipos, numeroRondas, numeroPartidosPorRonda, rondas);
        Jornada jornada = new Jornada(numeroRondas * 2, numeroPartidosPorRonda, numeroPartidosEnTotal, rondas);

        return jornada;
    }

    //TODO: posiblemente crearCalendario
    public static Partido[][] crearListaJornadas(Equipo[] listaEquipos, Arbitro[] listaArbitros, int numeroEquipos, int numeroRondas, int numeroPartidosPorRonda, Partido[][] rondas) {
        //x y son variables auxiliares para hacer facilmente "la elaboración de fixture" visto en https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
        int x = 0;
        int y = numeroEquipos - 2;

        if (numeroEquipos % 2 == 0) {//para los pares
            for (int i = 0; i < numeroRondas; i++) {
                for (int j = 0; j < numeroPartidosPorRonda; j++) {
                    if (j == 0) {
                        if (i % 2 == 0)
                            rondas[i][j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                        else
                            rondas[i][j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                        x++;
                    } else {
                        rondas[i][j] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j]);
                        x++;
                        y--;
                    }
                    if (x > (numeroEquipos - 2)) x = 0;
                    if (y < (0)) y = numeroEquipos - 2;
                }
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                for (int j = 0; j < numeroPartidosPorRonda; j++) {
                    if (j == 0) {
                        if (i % 2 == 0)
                            rondas[i + numeroRondas][j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                        else
                            rondas[i + numeroRondas][j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                        x++;
                    } else {
                        rondas[i + numeroRondas][j] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j]);
                        x++;
                        y--;
                    }
                    if (x > (numeroEquipos - 2)) x = 0;
                    if (y < (0)) y = numeroEquipos - 2;
                }
            }

        } else {//para los impares
            //para los impares hay que hacerlo como el numero par encima del impar, solo que saltandote la primera fila (j=0).
            //asi que hay que todo lo que tenga que ver con numEquipos y numPartidosPorRonda se le suma uno.

            y++;//esto es por lo que he puesto en la linea de arriba
            for (int i = 0; i < numeroRondas; i++) {
                for (int j = 0; j < numeroPartidosPorRonda + 1; j++) {
                    if (j == 0) x++;//aunque nos lo saltemos la x hay que seguir sumandola en j = 0
                    else {
                        rondas[i][j - 1] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j - 1]);//la j-1 porque el 0 nos lo habiamos saltado
                        x++;
                        y--;
                    }
                    if (x > (numeroEquipos - 1)) x = 0;
                    if (y < (0)) y = numeroEquipos - 1;
                }
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                for (int j = 0; j < numeroPartidosPorRonda + 1; j++) {
                    if (j == 0) x++;
                    else {
                        rondas[i + numeroRondas][j - 1] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j - 1]);
                        x++;
                        y--;
                    }
                    if (x > (numeroEquipos - 1)) x = 0;
                    if (y < (0)) y = numeroEquipos - 1;
                }
            }
        }
        return rondas;
    }

    public static Equipo[] ordenarEquipos(Equipo[] listaEquipos) {

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

    //MÉTODOS CALENDARIOS

    //TODO: nombre provisional, listado de dias y horas para los partidos
//    public static String[][] calendarioFechas() {
//
//    }
}