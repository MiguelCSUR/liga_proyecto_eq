//Criterios
//CREAR para Objetos propios. Ejemplos: Persona, Equipo, etc
//crearPartido() crearListaPartidos() crearEquipo
//Si creas un array de X será crearListaX(). Ejemplo crearJugador(), crearListaJugadores()

//GENERAR para atributos, propiedades, parámetros que no sean objetos propios
//generarNombre()
//Ejemplo: String, int, Integer, etc

package controller;

import data.Nombres;
import model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class Invocador {

    final static String[] LISTACATEGORIAS = {"Chupetín", "Prebenjamín", "Benjamín", "Alevín", "Infantil", "Cadete", "Juvenil"};
    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO: HERRAMINTAS

    public static int generarNumeroEntre(int minimo, int maximo) {
        return (int) Math.floor(Math.random() * (maximo - minimo)) + minimo;
    }

    //TODO: DATE

    public static String dateToString(LocalDate fecha) {
        return fecha.format(FORMATOFECHA);
    }

    public static LocalDate stringToDate(String fecha) {
        return LocalDate.parse(fecha, FORMATOFECHA);
    }

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
                while (j < listaHorarios.length && i < listaPartidos.length) {
                    listaPartidos[i].setHoraInicio(listaHorarios[j]);
                    listaPartidos[i].setFecha(fechaInicial);
                    j++;
                    i++;
                }
            } else {
                //j son los partidos a partir de la tarde
                int j = 3;
                while (j < listaHorarios.length && i < listaPartidos.length) {
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

    //TODO: PERSONA
    public static String generarNombrePersona() {
        int random = (int) Math.floor(Math.random() * Nombres.personaNombres().length);
        return Nombres.personaNombres()[random];
    }

    public static String generarApellidosPersona() {
        int random1 = (int) Math.floor(Math.random() * Nombres.personaApellidos().length);
        int random2 = (int) Math.floor(Math.random() * Nombres.personaApellidos().length);
        return Nombres.personaApellidos()[random1] + " " + Nombres.personaApellidos()[random2];
    }

    public static int generarEdadPersona(int edadMin, int edadMax) {
        return (int) Math.floor(Math.random() * (edadMax - edadMin)) + edadMin;
    }

    //TODO: JUGADOR

    //Te he cambiado el codigo de crear jugador y te he creado una lista de jugadores
    public static Jugador crearJugador(String categoria, int dorsal) {
        Jugador jugador = new Jugador();
        jugador.setNombre(generarNombrePersona());
        jugador.setApellidos(generarApellidosPersona());
        jugador.setCategoria(categoria);
        jugador.setDorsal(dorsal);
        jugador.setEdad(generarEdadJugador(categoria));
        return jugador;
    }

    public static Jugador[] crearListaJugadores(String categoria, Equipo equipo) {
        int numJugadores = generarNumeroJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador();
            jugador = crearJugador(categoria, i + 1);
            jugador.setEquipo(equipo);
            jugadores[i] = jugador;
        }
        return jugadores;
    }

    public static int generarEdadJugador(String categoria) {
        switch (categoria) {
            case "Chupetín":
                return generarEdadPersona(4, 5);
            case "Prebenjamín":
                return generarEdadPersona(6, 7);
            case "Benjamín":
                return generarEdadPersona(8, 9);
            case "Alevín":
                return generarEdadPersona(10, 11);
            case "Infantil":
                return generarEdadPersona(12, 13);
            case "Cadete":
                return generarEdadPersona(14, 15);
            case "Juvenil":
                return generarEdadPersona(16, 18);
            default:
                return generarEdadPersona(19, 38);
        }
    }

    public static String generarPosicion(int dorsal) {//Probamos si le metemos el numero del dorsal que tiene le da una posicion exacta.
        while (dorsal > 11) {
            int numeroAleatorio = (int) Math.floor(Math.random() * 12) + 1;
            dorsal = numeroAleatorio;
        }

        switch (dorsal) {
            case 1:
                return "Portero";
            case 2:
                return "Lateral derecho";
            case 3:
                return "Lateral izquierdp";
            case 4:
            case 5:
                return "Central";
            case 6:
                return "Pivote";
            case 7:
                return "Extremo derecho";
            case 8:
                return "Centrocampista";
            case 9:
                return "Delantero";
            case 10:
                return "Mediapunta";
            case 11:
                return "Extremo izquierdo";
            default:
                return "Error se sale de dorsal en Jugador.setPosition()";
        }
    }

    //TODO: ENTRENADOR

    //Te he creado esta clase de entrenador
    public static Entrenador crearEntrenador(Equipo equipo) {
        final int EDADMIN = 18;
        final int EDADMAX = 40;
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(generarNombrePersona());
        entrenador.setApellidos(generarApellidosPersona());
        entrenador.setEdad(generarEdadPersona(EDADMIN, EDADMAX));
        entrenador.setNumeroLicencia(generarLicencia());
        entrenador.setEquipo(equipo);
        return entrenador;
    }

    public static int generarLicencia() {
        return (int) Math.floor(Math.random() * 10000);
    }

    //TODO: ARBITRO

    //Tambien he tocado un poco esto(Nacho)
    public static Arbitro crearArbitro() {
        final int EDADMIN = 18;
        final int EDADMAX = 40;
        Arbitro arbitro = new Arbitro();
        arbitro.setNombre(generarNombrePersona());
        arbitro.setApellidos(generarApellidosPersona());
        arbitro.setEdad(generarEdadPersona(EDADMIN, EDADMAX));
        arbitro.setLicencia(generarLicencia());
        return arbitro;
    }

    public static Arbitro[] crearListaArbitros() {
        int numeroArbitros = (int) Math.floor(generarNumeroEquipos() / 2);
        Arbitro[] listaArbitros = new Arbitro[numeroArbitros];
        for (int i = 0; i < numeroArbitros; i++) {
            Arbitro arbitro = crearArbitro();
            listaArbitros[i] = arbitro;
        }
        return listaArbitros;
    }

    //TODO: EQUIPO

    //Generador de mascotas de los equipos
    public static String generarMascota() {
        int random = (int) Math.floor(Math.random() * Nombres.mascotaNombres().length);
        return Nombres.mascotaNombres()[random];
    }

    //Generador de nombres equipos
    public static String generarCiudad() {
        int random = (int) Math.floor(Math.random() * Nombres.ciudadNombres().length);
        return Nombres.ciudadNombres()[random];
    }

    //Creamos las equipaciones de los equipos de casa y se la damos
    public static String generarEquipacionCasa() {

        String[] equipC = {"Rojo-Amarillo", "Verde-Blanco", "Azul-Blanco", "Rojo-Negro", "Amarillo-Azul", "Naranja-Verde", "Rosa-Blanco", "Negro-Blanco", "Gris-Negro"};

        int numero = (int) Math.floor(Math.random() * equipC.length);
        // String equipacioncasa = equipC[numero];

        return equipC[numero];

    }

    //Creamos las equipaciones de los equipos de fuera y se la damos
    public static String generarEquipacionFuera() {

        String[] equipacionFuera = {"Rojo", "Verde", "Azul", "Negro", "Amarillo", "Naranja", "Rosa", "Blanco", "Gris"};

        int numero = (int) Math.floor(Math.random() * equipacionFuera.length);
        //String equipacionfuera = equipacionFuera[numero];

        return equipacionFuera[numero];

    }

    //Creamos un numero aleatorio para elejir el maximo de jugadores que tendra un equipo
    public static int generarNumeroJugadores() {
        int numJugadores = (int) Math.floor(Math.random() * 9) + 11;
        return numJugadores;
    }

    //Esto crea un equipo en individual
    public static Equipo crearEquipo(String categoria) {
        Equipo equipo = new Equipo();
        equipo.setNombre(generarNombreEquipo());
        equipo.setEquipacionCasa(generarEquipacionCasa());
        equipo.setEquipacionCasa(generarEquipacionFuera());
        equipo.setClub(generarClub());
        equipo.setEntrenador(crearEntrenador(equipo));
        equipo.setJugadores(crearListaJugadores(categoria, equipo));
        return equipo;
    }

    //Asigna los equipos según el número de equipos que se han generado previamente
    public static Equipo[] crearListaEquipos(int numEquipos, String categoria) {
        Equipo[] listaEquipos = new Equipo[numEquipos];

        for (int i = 0; i < numEquipos; i++) {
            Equipo equipo = crearEquipo(categoria);
            listaEquipos[i] = equipo;
        }
        return listaEquipos;
    }

    public static String generarNombreEquipo() {
        String nombre = generarMascota() + " de " + generarCiudad();
        return nombre;
    }

    public static String generarClub() {
        String nombre = generarCiudad() + " F.C ";
        return nombre;
    }

    //TODO: PARTIDO

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

    public static Partido crearPartido(Equipo equipoCasa, Equipo equipoFuera, Arbitro arbitro) {
        Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

        //Generamos los golesEquipoCasa
        int golesEquipoCasa = generadorGoles();
        //Seteamos los goles del Equipo casa, al partido en la propiedad partido.golesEquipoCasa
        partido.setGolesEquipoCasa(golesEquipoCasa);
        //Seteamos los goles del Equipo casa, al equipo en la propiedad equipo.goles
        //TODO: Este último paso es redundante eliminar en el futuro.
        equipoCasa.setGoles(equipoCasa.getGoles() + golesEquipoCasa);

        //Se repite el mismo proceso con golesEquipoFuera.
        int golesEquipoFuera = generadorGoles();
        partido.setGolesEquipoFuera(golesEquipoFuera);
        equipoFuera.setGoles(equipoFuera.getGoles() + golesEquipoFuera);

        //Se asignan los puntos
        asignarPuntos(partido);

        return partido;
    }

    public static Partido[] extraerListaPartidos(Liga liga){
        Equipo[] listaEquipos = liga.getListaEquipos();
        Jornada[] jornadas = liga.getCalendario().getListaJornadas();
        Partido[] listaPartidos =   new Partido[listaEquipos.length * (listaEquipos.length - 1)];
        int contador =0;
        for (int i = 0; i < jornadas.length; i++) {
            for (int j = 0; j < jornadas[i].getlistaPartidos().length; j++) {
                listaPartidos[contador] = jornadas[i].getlistaPartidos()[j];
                listaPartidos[contador].setNumeroPartido(contador + 1);
                contador++;
            }
        }
        return listaPartidos;
    }

    //TODO: JORNADA
    public static Jornada[] crearListaJornadas(Liga liga) {
        //x y son variables auxiliares para hacer facilmente "la elaboración de fixture" visto en https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
        //Creamos las variables que eligen el numero de partidos que hay
        //
        //TODO: pasando liga ya no hace falta pasar listaEquipos, y listaArbitros por separado
        Equipo[] listaEquipos = liga.getListaEquipos();
        Arbitro[] listaArbitros = liga.getListaArbitros();
        int numeroEquipos = listaEquipos.length;
        int numeroPartidosEnTotal = (numeroEquipos * (numeroEquipos - 1)) / 2;
        int numeroRondas;

        //TODO: revisar si esta variable se usa
        int numeroPartidosPorRonda;


        if (numeroEquipos % 2 == 0) {
            numeroRondas = numeroEquipos - 1;
            numeroPartidosPorRonda = numeroEquipos / 2;
        } else {
            numeroRondas = numeroEquipos;
            numeroPartidosPorRonda = (numeroEquipos - 1) / 2;
        }
        Jornada[] listaJornadas = new Jornada[numeroRondas * 2];

        if (numeroEquipos % 2 == 0) {//para los pares
            for (int i = 0; i < numeroRondas; i++) {
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaParIda(i, listaEquipos, listaArbitros));
                listaJornadas[i] = jornada;
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaParVuelta(i, listaEquipos, listaArbitros));
                listaJornadas[i + numeroRondas] = jornada;
            }
        } else {//para los impares
            //para los impares hay que hacerlo como el numero par encima del impar, solo que saltandote la primera fila (j=0).
            //asi que hay que todo lo que tenga que ver con numEquipos y numPartidosPorRonda se le suma uno.
            for (int i = 0; i < numeroRondas; i++) {
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaImparIda(i, listaEquipos, listaArbitros));
                listaJornadas[i] = jornada;
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaImparVuelta(i, listaEquipos, listaArbitros));
                listaJornadas[i + numeroRondas] = jornada;

            }
        }
        System.out.println("Numero Partidos total: " + numeroPartidosEnTotal * 2);
        return listaJornadas;
    }

    //TODO: No se si esto va aqui porque son partidos

    public static Partido[] crearPartidosJornadaParIda(int numeroJornada, Equipo[] listaEquipos, Arbitro[]
            listaArbitros) {
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = numeroEquipos / 2;
        int x = 0;
        int y = numeroEquipos - 2;
        Partido[] partido = new Partido[partidosPorRonda];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                if (numeroJornada % 2 == 0)
                    partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                else partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                x++;
            } else {
                partido[j] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j]);
                x++;
                y--;
            }
            if (x > (numeroEquipos - 2)) x = 0;
            if (y < (0)) y = numeroEquipos - 2;
        }
        return partido;
    }

    public static Partido[] crearPartidosJornadaParVuelta(int numeroJornada, Equipo[] listaEquipos, Arbitro[]
            listaArbitros) {
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = numeroEquipos / 2;
        int x = 0;
        int y = numeroEquipos - 2;
        Partido[] partido = new Partido[partidosPorRonda];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                if (numeroJornada % 2 == 0)
                    partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                else partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                x++;
            } else {
                partido[j] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j]);
                x++;
                y--;
            }
            if (x > (numeroEquipos - 2)) x = 0;
            if (y < (0)) y = numeroEquipos - 2;
        }
        return partido;
    }

    public static Partido[] crearPartidosJornadaImparIda(int numeroJornada, Equipo[] listaEquipos, Arbitro[]
            listaArbitros) {
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = (numeroEquipos / 2) + 1;
        int x = 0;
        int y = numeroEquipos - 1;
        Partido[] partido = new Partido[partidosPorRonda - 1];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                x++;
            } else {
                partido[j - 1] = crearPartido(listaEquipos[x], listaEquipos[y], listaArbitros[j - 1]);
                x++;
                y--;
            }
            if (x > (numeroEquipos - 1)) x = 0;
            if (y < (0)) y = numeroEquipos - 1;
        }
        return partido;
    }

    public static Partido[] crearPartidosJornadaImparVuelta(int numeroJornada, Equipo[] listaEquipos, Arbitro[]
            listaArbitros) {
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = (numeroEquipos / 2) + 1;
        int x = 0;
        int y = numeroEquipos - 1;
        Partido[] partido = new Partido[partidosPorRonda - 1];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                x++;
            } else {
                partido[j - 1] = crearPartido(listaEquipos[y], listaEquipos[x], listaArbitros[j - 1]);
                x++;
                y--;
            }
            if (x > (numeroEquipos - 1)) x = 0;
            if (y < (0)) y = numeroEquipos - 1;
        }
        return partido;
    }


    //TODO: CALENDARIO

    public static Calendario crearCalendario(Liga liga) {
        Calendario calendario = new Calendario();
        calendario.setListaJornadas(crearListaJornadas(liga));
        //TODO: Miguel - No se como sacarlo evitando el partido que nose juega
//        calendario.setListaPartidos();
        return calendario;
    }

    //TODO: CLASIFICACION

    public static void asignarPuntos(Partido partido) {
        Equipo equipoCasa = partido.getEquipoCasa();
        Equipo equipoFuera = partido.getEquipoFuera();

        if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
            //Empate
            equipoCasa.setPuntos(equipoCasa.getPuntos() + 1);
            equipoFuera.setPuntos(equipoFuera.getPuntos() + 1);
        } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
            //Gana Equipo Casa
            equipoCasa.setPuntos(equipoCasa.getPuntos() + 3);
        } else {
            //Gana Equipo Fuera
            equipoFuera.setPuntos(equipoFuera.getPuntos() + 3);
        }
    }

    public static Equipo[] clasificarEquipos(Equipo[] listaEquipos) {

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

    public static void mostarClasificacion() {

    }

    //TODO: LIGA
    public static Liga crearLiga() {
        //TODO: queda por setear Calendario y Clasificacion
        String categoria = generarCategoriaLiga();
        Liga liga = new Liga(generarFechaInicio(), categoria);
        liga.setNombre(generarNombresLiga());
        liga.setListaEquipos(crearListaEquipos(generarNumeroJugadores(), categoria));
        liga.setListaArbitros(crearListaArbitros());
        liga.setFechaInicio(generarFechaInicio());

        return liga;
    }

    public static String generarNombresLiga() {
        int nombre = generarNumeroEntre(0, Nombres.ligaNombres().length);
        return Nombres.ligaNombres()[nombre];
    }

    //Genera una categoria aleatoria de la lista de categorias
    public static String generarCategoriaLiga() {
        int categoria = generarNumeroEntre(0, LISTACATEGORIAS.length);
        return LISTACATEGORIAS[categoria];
    }

    //Genera una fecha aletoria entre mañana y dentro de 10 días
    public static LocalDate generarFechaInicio() {
        int dias = generarNumeroEntre(1, 10);
        LocalDate fecha = LocalDate.now().plusDays(dias);
        return fecha;
    }

    public static int generarNumeroEquipos() {
        return generarNumeroEntre(5, 10);
    }
}
