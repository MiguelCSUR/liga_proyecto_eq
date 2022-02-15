//Criterios
//CREAR para Objetos propios. Ejemplos: Persona, Equipo, etc
//crearPartido() crearListaPartidos() crearEquipo
//Si creas un array de X será crearListaX(). Ejemplo crearJugador(), crearListaJugadores()

//GENERAR para atributos, propiedades, parámetros que no sean objetos propios
//generarNombre()
//Ejemplo: String, int, Integer, etc

package controller;

import data.Nombres;
import jdk.swing.interop.SwingInterOpUtils;
import model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class Invocador {

    final static Liga LIGA = crearLiga();


    //TODO: HERRAMINTAS

    public static int generarNumeroEntre(int minimo, int maximo) {
        return (int) Math.floor(Math.random() * (maximo - minimo)) + minimo;
    }

    //TODO: DATE

    public static String dateToString(LocalDate fecha) {
        return fecha.format(Nombres.formatoFecha());
    }

    public static LocalDate stringToDate(String fecha) {
        return LocalDate.parse(fecha, Nombres.formatoFecha());
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
    public static Jugador crearJugador(String categoria, int dorsal,int formacion) {
        Jugador jugador = new Jugador();
        jugador.setNombre(generarNombrePersona());
        jugador.setApellidos(generarApellidosPersona());
        jugador.setCategoria(categoria);
        jugador.setDorsal(dorsal);
        jugador.setEdad(generarEdadJugador(categoria));
        jugador.setPosicion(generarPosicion(dorsal,formacion));
        return jugador;
    }

    public static Jugador[] crearListaJugadores(String categoria, Equipo equipo,int formacion) {
        int numJugadores = generarNumeroJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador();
            jugador = crearJugador(categoria, i + 1,formacion);
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

    public static String generarPosicion(int dorsal,int formacion) {//Probamos si le metemos el numero del dorsal que tiene le da una posicion exacta.
        while (dorsal > 11) {
            int numeroAleatorio = (int) Math.floor(Math.random() * 12) + 1;
            dorsal = numeroAleatorio;
        }
        if (formacion == 1) {//Formacion 4-4-2
            switch (dorsal) {
                case 1:
                    return "Portero";
                case 2:
                case 3:
                case 4:
                case 5:
                    return "Defensa";
                case 6:
                case 7:
                case 8:
                case 9:
                    return "Centrocampista";
                case 10:
                case 11:
                    return "Delantero";
                default:
                    return "Error se sale de dorsal en Jugador.setPosition()";
            }
        }
        if (formacion == 2) {//Formacion 4-3-3
            switch (dorsal) {
                case 1:
                    return "Portero";
                case 2:
                case 3:
                case 4:
                case 5:
                    return "Defensa";
                case 6:
                case 7:
                case 8:
                    return "Centrocampista";
                case 9:
                case 10:
                case 11:
                    return "Delantero";
                default:
                    return "Error se sale de dorsal en Jugador.setPosition()";
            }
        }
        if (formacion == 3) {//Formacion 3-4-3
            switch (dorsal) {
                case 1:
                    return "Portero";
                case 2:
                case 3:
                case 4:
                    return "Defensa";
                case 5:
                case 6:
                case 7:
                case 8:
                    return "Centrocampista";
                case 9:
                case 10:
                case 11:
                    return "Delantero";
                default:
                    return "Error se sale de dorsal en Jugador.setPosition()";
            }
        }
        if (formacion == 4) {//Formacion 5-4-1
            switch (dorsal) {
                case 1:
                    return "Portero";
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return "Defensa";
                case 7:
                case 8:
                case 9:
                case 10:
                    return "Centrocampista";
                case 11:
                    return "Delantero";
                default:
                    return "Error se sale de dorsal en Jugador.setPosition()";
            }
        }
        return "Error no ha elegido una posicion/formacion posible";
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

    public static void mostrarJugador(Jugador jugador, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("\t1. Nombre: " + jugador.getNombre() + jugador.getApellidos());
            System.out.println("\t2. Dorsal: " + jugador.getDorsal());
            System.out.println("\t3. Edad: " + jugador.getEdad());
            System.out.println("\t4. Posición: " + jugador.getPosicion());
            System.out.println();
        } else {
            System.out.println("\tNombre: " + jugador.getNombre() + jugador.getApellidos());
            System.out.println("\tDorsal: " + jugador.getDorsal());
            System.out.println("\tEdad: " + jugador.getEdad());
            System.out.println("\tPosición: " + jugador.getPosicion());
            System.out.println();
        }
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

    public static Arbitro[] crearListaArbitros(int numeroEquipos) {
        int numeroArbitros = (int) Math.floor(numeroEquipos / 2);
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
    public static String generarEquipacionCasa(int numeroEquipacion) {
        String[] listaEquipacion = {"Rojo-Amarillo", "Verde-Blanco", "Azul-Blanco", "Rojo-Negro", "Amarillo-Azul", "Naranja-Verde", "Rosa-Blanco", "Negro-Blanco", "Gris-Negro"};
        return listaEquipacion[numeroEquipacion];

    }

    //Creamos las equipaciones de los equipos de fuera y se la damos
    public static String generarEquipacionFuera(int numeroEquipacion) {
        String[] equipacionFuera = {"Rojo", "Verde", "Azul", "Negro", "Amarillo", "Naranja", "Rosa", "Blanco", "Gris"};
        return equipacionFuera[numeroEquipacion];
    }

    //Creamos un numero aleatorio para elejir el maximo de jugadores que tendra un equipo
    public static int generarNumeroJugadores() {
        int numJugadores = (int) Math.floor(Math.random() * 9) + 11;
        return numJugadores;
    }

    //Esto crea un equipo en individual
    public static Equipo crearEquipo(String categoria,int formacion) {
        Equipo equipo = new Equipo();
        equipo.setNombre(generarNombreEquipo());
        int numeroEquipacion = generarNumeroEntre(0, 8);
        equipo.setEquipacionCasa(generarEquipacionCasa(numeroEquipacion));
        equipo.setEquipacionFuera(generarEquipacionFuera(numeroEquipacion));
        equipo.setClub(generarClub());
        equipo.setEntrenador(crearEntrenador(equipo));
        equipo.setJugadores(crearListaJugadores(categoria, equipo,formacion));
        return equipo;
    }

    //Asigna los equipos según el número de equipos que se han generado previamente
    public static Equipo[] crearListaEquipos(int numEquipos, String categoria,int formacion) {
        Equipo[] listaEquipos = new Equipo[numEquipos];

        for (int i = 0; i < numEquipos; i++) {
            Equipo equipo = crearEquipo(categoria,formacion);
            listaEquipos[i] = equipo;
        }
        return listaEquipos;
    }

    public static String generarNombreEquipo() {
        String nombre = generarMascota() + " de " + generarCiudad();
        return nombre;
    }

    public static String generarClub() {
        String nombre = generarCiudad() + " F.C.";
        return nombre;
    }

    //Si le pasas true, te numero los equipos, false no los numera
    public static void mostrarListaEquipos(Equipo[] listaEquipo, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("     Número total de equipos: " + listaEquipo.length + ".\n");
            for (int i = 0; i < listaEquipo.length; i++) {
                System.out.printf("%3d. %s\n", (i + 1), listaEquipo[i].getNombre());
                System.out.println("     " + listaEquipo[i].getClub());
                System.out.println();
            }
        } else {
            System.out.println("Número total de equipos: " + listaEquipo.length + ".\n");
            for (int i = 0; i < listaEquipo.length; i++) {
                System.out.println(listaEquipo[i].getNombre());
                System.out.println(listaEquipo[i].getClub());
                System.out.println();
            }
        }
    }
    public static void mostrarEntrenador(Entrenador entrenador, boolean estanNumerados) {
        if (estanNumerados) {
            System.out.println("    Entrenador: ");
            System.out.println("\t1. Nombre: " + entrenador.getNombre() + entrenador.getApellidos());
            System.out.println("\t2. Edad: " + entrenador.getEdad());
            System.out.println("\t3. Licencia: " + entrenador.getNumeroLicencia());
        } else {
            System.out.println("Entreador: ");
            System.out.println("\tNombre: " + entrenador.getNombre() + entrenador.getApellidos());
            System.out.println("\tEdad: " + entrenador.getEdad());
            System.out.println("\tLicencia: " + entrenador.getNumeroLicencia());
        }
    }

    public static void mostrarEquipo(Equipo equipo, boolean estanNumerados) {
        Entrenador entrenador = equipo.getEntrenador();
        if (estanNumerados) {
            System.out.println("1. Nombre equipo: " + equipo.getNombre());
            System.out.println("2. Nombre club: " + equipo.getClub());
            System.out.println("3. Categoria: " + equipo.getJugadores()[0].getCategoria());
        } else {
            System.out.println("Nombre equipo: " + equipo.getNombre());
            System.out.println("Nombre club: " + equipo.getClub());
            System.out.println("Categoria: " + equipo.getJugadores()[0].getCategoria());
            System.out.println("Equipación Casa: " + equipo.getEquipacionCasa());
            System.out.println("Equipación Fuera: " + equipo.getEquipacionCasa());
            System.out.println("Formacion: " + obtenerFormacionEquipo(equipo));
        }
    }

    public static void mostrarListaJugadores(Equipo equipo, boolean estanNumerados) {
        Jugador[] listaJugadores = equipo.getJugadores();
        if (estanNumerados) {
            System.out.println("    Jugadores: ");
            for (int i = 0; i < listaJugadores.length; i++) {
                Jugador jugador = listaJugadores[i];
                System.out.printf("\t%2d. Nombre: " + jugador.getNombre() + jugador.getApellidos() + "\n", (i + 2));
                System.out.println("\t    Dorsal: " + jugador.getDorsal());
                System.out.println("\t    Edad: " + jugador.getEdad());
                System.out.println("\t    Posición: " + jugador.getPosicion());
                System.out.println();
            }
        } else {
            System.out.println("Jugadores: ");
            for (int i = 0; i < listaJugadores.length; i++) {
                Jugador jugador = listaJugadores[i];
                System.out.println("\tNombre: " + jugador.getNombre() + jugador.getApellidos());
                System.out.println("\tDorsal: " + jugador.getDorsal());
                System.out.println("\tEdad: " + jugador.getEdad());
                System.out.println("\tPosición: " + jugador.getPosicion());
                System.out.println();
            }
        }
    }

    public static int generarFormacionAleatoria(){
        int numero = (int) Math.floor(Math.random()*4)+1;
        return numero;
    }

    public static Equipo cambiarFormacionEquipo(Equipo equipo,int formacion){
        for (int i = 0; i <equipo.getJugadores().length ; i++) {
            equipo.getJugadores()[i].setPosicion(generarPosicion(i+1,formacion));
        }
        return equipo;
    }

    public static String obtenerFormacionEquipo(Equipo equipo){
        int contadorDelantero = 0;
        int contadorCentro = 0;
        int contadorDefensa = 0;
        Jugador[] jugadores = equipo.getJugadores();
        for (int i = 0; i < 11; i++) {
            if(jugadores[i].getPosicion()=="Delantero"){
                contadorDelantero++;
            }
            else if(jugadores[i].getPosicion()=="Defensa"){
                contadorDefensa++;
            }
            else if(jugadores[i].getPosicion()=="Centrocampista"){
                contadorCentro++;
            }
        }
        if(contadorDefensa==4&&contadorCentro==4&&contadorDelantero==2){
            return "4-4-2";
        }
        else if(contadorDefensa==4&&contadorCentro==3&&contadorDelantero==3){
            return "4-3-3";
        }
        else if(contadorDefensa==3&&contadorCentro==4&&contadorDelantero==3){
            return "3-4-3";
        }
        else if(contadorDefensa==5&&contadorCentro==4&&contadorDelantero==1){
            return "5-4-1";
        }
        else return "ERROR";

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
        int gol = Nombres.probabilidadesGoles()[numRamdon];
        return gol;
    }

    public static Partido crearPartido(Equipo equipoCasa, Equipo equipoFuera, Arbitro arbitro) {
        return new Partido(equipoCasa, equipoFuera, arbitro);
    }

    //Este metodo no crea nada, solo extrae la lista de partidos de una jornada previamente creada
    private static Partido[] extraerListaPartidos(Liga liga, Jornada[] listaJornadas) {
        Equipo[] listaEquipos = liga.getListaEquipos();
        Partido[] listaPartidos = new Partido[listaEquipos.length * (listaEquipos.length - 1)];
        int contador = 0;
        for (int i = 0; i < listaJornadas.length; i++) {
            for (int j = 0; j < listaJornadas[i].getlistaPartidos().length; j++) {
                listaPartidos[contador] = listaJornadas[i].getlistaPartidos()[j];
                listaPartidos[contador].setNumeroPartido(contador + 1);
                contador++;
            }
        }
        asignarHoraPartidos(listaPartidos, liga.getFechaInicio());
        return listaPartidos;
    }

    public static void jugarPartido(Partido partido) {
        Equipo equipoCasa = partido.getEquipoCasa();
        Equipo equipoFuera = partido.getEquipoFuera();

        System.out.println();
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

        //DEBUG
        System.out.println("DEBUG jugarPartido()");
        System.out.println("Partido" + partido.getNumeroPartido());
//        System.out.println(equipoCasa.getClub() + " Goles: " + golesEquipoCasa + " Puntos: " + equipoCasa.getPuntos());
//        System.out.println(equipoFuera.getClub() + " Goles: " + golesEquipoFuera + " Puntos: " + equipoFuera.getPuntos());

        System.out.println(equipoCasa.getClub() + " Goles: " + partido.getGolesEquipoCasa() + " Puntos: " + equipoCasa.getPuntos());
        System.out.println(equipoFuera.getClub() + " Goles: " + partido.getGolesEquipoFuera() + " Puntos: " + equipoFuera.getPuntos());
    }

    //TODO: JORNADA

    public static int calcularNumeroJornadas(int numeroEquipos) {
        int numeroRondas;
        if (numeroEquipos % 2 == 0) {
            numeroRondas = numeroEquipos - 1;
        } else {
            numeroRondas = numeroEquipos;
        }
        return numeroRondas * 2;
    }

    //TODO: NotasDeMigue: No asignar goles ni puntos a los partidos que se generen en la lista.
    //TODO: hacerlo en otro metodo que luego se podra decidir que jornadas jugar.
    //TODO: metodo que coja la lista y se vaya jugando hasta la jornada que se indique, luego almacenar,
    //TODO: en que jornada nos hemos quedado. numJornadaClasificacion = 0. y siempre se gette.

    public static Jornada[] crearListaJornadas(Liga liga, int maximoJornadas) {
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

        int contadorJornadas = 0;
        if (numeroEquipos % 2 == 0) {//para los pares
            for (int i = 0; i < numeroRondas; i++) {
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaParIda(i, listaEquipos, listaArbitros));
                listaJornadas[i] = jornada;
                if (contadorJornadas > maximoJornadas) {
                    return listaJornadas;
                }
                contadorJornadas++;
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaParVuelta(i, listaEquipos, listaArbitros));
                listaJornadas[i + numeroRondas] = jornada;
                if (contadorJornadas > maximoJornadas) {
                    return listaJornadas;
                }
                contadorJornadas++;
            }
        } else {//para los impares
            //para los impares hay que hacerlo como el numero par encima del impar, solo que saltandote la primera fila (j=0).
            //asi que hay que todo lo que tenga que ver con numEquipos y numPartidosPorRonda se le suma uno.
            for (int i = 0; i < numeroRondas; i++) {
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaImparIda(i, listaEquipos, listaArbitros));
                listaJornadas[i] = jornada;
                if (contadorJornadas > maximoJornadas) {
                    return listaJornadas;
                }
                contadorJornadas++;
            }
            for (int i = 0; i < numeroRondas; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
                Jornada jornada = new Jornada();
                jornada.setListaPartidos(crearPartidosJornadaImparVuelta(i, listaEquipos, listaArbitros));
                listaJornadas[i + numeroRondas] = jornada;
                if (contadorJornadas > maximoJornadas) {
                    return listaJornadas;
                }
                contadorJornadas++;
            }
        }
        //debertia de borrarse este syso, ya que este metodo solo deberia crear el array y no imprimir NADA
        System.out.println("DEBUG crearListaJornadas: Numero Partidos total: " + numeroPartidosEnTotal * 2);
        return listaJornadas;
    }

    //Overloading
    public static Jornada[] crearListaJornadas(Liga liga) {
        int maximoJornadas = calcularNumeroJornadas(liga.getListaEquipos().length) + 1;
        return crearListaJornadas(liga, maximoJornadas);
    }

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

    public static void jugarJornada(Liga liga, int numeroJornadasAJugar) {
        Jornada[] listajornada = liga.getCalendario().getListaJornadas();
        int ultimaJornadaJugada = liga.getUltimaJornadaJugada();
        if (ultimaJornadaJugada > listajornada.length) ultimaJornadaJugada = listajornada.length;
        if (numeroJornadasAJugar > listajornada.length) numeroJornadasAJugar = listajornada.length;

        for (int i = ultimaJornadaJugada; i < numeroJornadasAJugar; i++) {
            System.out.println("DEBUG jugarJornada: Numero Jornada: " + i);
            Partido[] listasPartidos = listajornada[i].getlistaPartidos();
            for (int j = 0; j < listasPartidos.length; j++) {
//                jugarPartido(listasPartidos[j]);
                jugarPartido(
                        liga.getCalendario().getListaJornadas()[i].getlistaPartidos()[j]
                );
            }
        }
        if (numeroJornadasAJugar > ultimaJornadaJugada) {
            liga.setUltimaJornadaJugada(numeroJornadasAJugar);
        }
    }

    //TODO: CALENDARIO

    public static Calendario crearCalendario(Liga liga) {
        Calendario calendario = new Calendario();
        Jornada[] listaJornadas = crearListaJornadas(liga);
        calendario.setListaJornadas(listaJornadas);
        Partido[] listaPartidos = extraerListaPartidos(liga, listaJornadas);
        calendario.setListaPartidos(listaPartidos);
        return calendario;
    }

    //Falta asignar horas a la lista de partidos, que no hay lista de partidos.
    public static void mostrarCalendario(Liga liga, int numeroJornadas) {
        int maximoJornadas = liga.getCalendario().getListaJornadas().length;
        //Para mostar la jornada 5 que es la posicion array 6.

        if (numeroJornadas > maximoJornadas) {
            numeroJornadas = maximoJornadas;
        } else if (numeroJornadas < 0) {
            numeroJornadas = 0;
        }

        Calendario calendario = Invocador.crearCalendario(liga);
        Jornada[] listaJornadas = calendario.getListaJornadas();

        int contadorJornadas = 1;
        for (int i = 0; i < numeroJornadas; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            if (i != 0) System.out.println("───────────────────────────────────────────────────────");
            System.out.println("\nJornada " + contadorJornadas + ".\n");
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                System.out.printf("\tPartido " + partido.getNumeroPartido() + ". %27s %5s\n", dateToString(partido.getFecha()), partido.getHoraInicio());
                System.out.printf("\t%-20s  VS  %20s\n", "Casa", "Visitante");
                System.out.printf("\t%-20s      %20s\n\n", partido.getEquipoCasa().getClub(), partido.getEquipoFuera().getClub());
            }
            contadorJornadas++;
        }
    }

    public static void mostrarCalendario(Liga liga) {
        int numeroJornadas = liga.getCalendario().getListaJornadas().length;

        mostrarCalendario(liga, numeroJornadas);
    }

    public static void mostrarCalendarioConGoles(Liga liga) {
        int numeroJornadas = liga.getUltimaJornadaJugada();
        int maximoJornadas = liga.getCalendario().getListaJornadas().length;
        //Para mostar la jornada 5 que es la posicion array 6.

        if (numeroJornadas > maximoJornadas) {
            numeroJornadas = maximoJornadas;
        } else if (numeroJornadas < 0) {
            numeroJornadas = 0;
        }

        Calendario calendario = Invocador.crearCalendario(liga);
        Jornada[] listaJornadas = calendario.getListaJornadas();

        int contadorJornadas = 1;
        for (int i = 0; i < numeroJornadas; i++) {
            Partido[] listaPartidos = listaJornadas[i].getlistaPartidos();
            if (i != 0) System.out.println("───────────────────────────────────────────────────────");
            System.out.println("\nJornada " + contadorJornadas + ".\n");
            for (int j = 0; j < listaPartidos.length; j++) {
                Partido partido = listaPartidos[j];
                System.out.printf("\tPartido %4s. %25s %6s\n", partido.getNumeroPartido(), dateToString(partido.getFecha()), partido.getHoraInicio());
                System.out.printf("\t%-20s  VS  %20s\n", "Casa", "Visitante");
                System.out.printf("\t%-20s      %20s\n", partido.getEquipoCasa().getClub(), partido.getEquipoFuera().getClub());
                System.out.printf("\t%10s%-10s      %10s%-10s\n\n", "Goles: ", partido.getGolesEquipoCasa(), "Goles: ", partido.getGolesEquipoFuera());
            }
            contadorJornadas++;
        }
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

    //TODO: Mirar si conviene que sea bubblesort o quicksort. Este es un bubble muy sencillito, que al menos funciona
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

    public static void mostrarClasificacion(Liga liga) {
        Equipo[] listaEquipos = liga.getListaEquipos();
        Equipo[] clasificacion = clasificarEquipos(listaEquipos);
        System.out.println("Jornada " + liga.getUltimaJornadaJugada() + ".");
        System.out.printf("%-23s      %5s%5s\n", "Nombre", "P", "G");
        System.out.println("────────────────────────────────────────");
        for (int i = clasificacion.length - 1; i >= 0; i--) {
            System.out.printf("%-23s      %5s%5s\n\n", clasificacion[i].getClub(),
                    clasificacion[i].getPuntos(), clasificacion[i].getGoles());
        }
        System.out.println("(P : Puntos totales, G : Goles totales)");
    }

    //TODO: LIGA
    public static Liga crearLiga() {
        //TODO: queda por setear Calendario, clasificacion se setea en el menu MostrarClasificacion
        String categoria = generarCategoriaLiga();
        int formacion = generarFormacionAleatoria();
        Liga liga = new Liga();
        int numeroEquipos = generarNumeroJugadores();
        liga.setNombre(generarNombresLiga());
        liga.setListaEquipos(crearListaEquipos(numeroEquipos, categoria,formacion));
        liga.setListaArbitros(crearListaArbitros(numeroEquipos));
        liga.setFechaInicio(generarFechaInicio());
        liga.setCalendario(crearCalendario(liga));
        liga.setUltimaJornadaJugada(0);

        return liga;
    }

    public static String generarNombresLiga() {
        int nombre = generarNumeroEntre(0, Nombres.ligaNombres().length);
        return Nombres.ligaNombres()[nombre];
    }

    //Genera una categoria aleatoria de la lista de categorias
    public static String generarCategoriaLiga() {
        int numeroCategorias = Nombres.listaCategorias().length - 1;
        int categoria = generarNumeroEntre(0, numeroCategorias);
        return Nombres.listaCategorias()[categoria];
    }

    //Genera una fecha aleatoria entre mañana y dentro de 10 días
    public static LocalDate generarFechaInicio() {
        int dias = generarNumeroEntre(1, 10);
        LocalDate fecha = LocalDate.now().plusDays(dias);
        return fecha;
    }

    public static int generarNumeroEquipos() {
        return generarNumeroEntre(5, 10);
    }

    public static void generarEspacio() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //TODO: revisar
    public static Liga resetLigaConEquipo(Liga liga) {
        Equipo[] listaEquipo = liga.getListaEquipos();
        liga = new Liga();
        liga.setListaEquipos(listaEquipo);
        return liga;
    }
}
