package model;

import controller.Invocador;

import java.time.LocalDate;
import java.util.Arrays;

public class Liga {

    private String nombre;
    private Equipo[] listaEquipos;
    private Calendario calendario;
    private Arbitro[] listaArbitros;
    private Clasificacion clasificacion;
    private LocalDate fechaInicio;

    public Liga(LocalDate fechaInicio, int numeroEquipos, String categoria) {
        this.fechaInicio = fechaInicio;
        this.nombre = generadorNombres();
        this.listaEquipos = Invocador.crearListaEquipos(numeroEquipos, categoria);
        this.listaArbitros = crearListaArbitros(generarNumeroArbitros(numeroEquipos));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo[] getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Arbitro[] getListaArbitros() {
        return listaArbitros;
    }

    //Setter lista arbitros

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    //Generador de nombres aleatorios
    public static String generadorNombres() {
        String[] nombres = {"Juegos Pentacard", "Juegos De Westcoast", "Mightyming Gaming", "Puente Escarlata", "Club De Pixelmate", "Juegos De Appleton",
                "Juegos De Winocrew", "Club De Costa Blanca", "Mysticmerry", "Bridgeburst Club", "Juegos Scruze Mate", "Brightnest",
                "Urbanmad", "Puentesplash", "Beyondhappy", "Cluestatis", "Cappacale", "Bridgestrive", "Ganar Emocionante", "Tripulaci�n Carmes�",
                "Magnizent Gaming", "Betterbuddy Club", "Trujoy Gaming", "Juegos De Sprucecity", "Juegos De Purplemate", "Greyurbener Club",
                "Juegos De Motherbricks", "Secretsquare", "Fusiondream Bri Dge Club", "Club Streetshine", "Avonbuddy Gaming", "Redchromo Gaming",
                "Bringup Gaming", "Serenedive Gaming", "Goodjolly Gaming", "Magma Unido", "Juegos Ascendentes", "El Juego Rejoy", "Juegos De Grandgalas",
                "Delight Wings Gaming", "Alphaberry", "Cardzest", "Juegos De Red Daisy", "Juegos De Maypetals", "Treandybeat Gaming",
                "Madera Amarilla", "Costa De Columbia", "Juegos De Bridge Drive", "Juegos De Crowdvalley", "Seastone Gaming", "Dreamfiesta",
                "Juegos Bluespiritan", "Bridgecube", "Northsmith Gaming", "Goodwish Gaming", "Costa Tropical", "Brazos De Palma", "Bling Coasta",
                "Claramonte Gaming", "Juegos De Starmotion", "Juegos De Ridgeberry", "Whitejets", "Wildhusky", "Gameglider", "Junglegamer",
                "Dungygamer", "Dedos Pegajosos", "Escorpiones Afilados", "F�rrices De Hielo", "Jugador Mortal", "Jugador Extra�o",
                "Reales Arriesgados", "Se�orita Masters", "Fabuskaters", "Espadas De Juego", "Sunnydogs", "Oppo Smashers", "Jugador De Tiro",
                "Cometas C�bicos", "Magnetbuddies", "Charmy Challengers", "Jugadores Poderosos", "Cuchillas Ardientes", "Xtremers De Nieve",
                "Stronggaming", "Mad Heeters", "Scarygoons", "Mad Metroniss", "Mastercrews", "Cuchillas De Acero", "Lave Raisers",
                "Bobcate Blasters", "Thrashers Ordenado", "Doncella Bliss", "Glovegaming", "Bestia Del Este", "Juegos De Bestia Tormentosa",
                "Mettle Blades", "Hat Trick Java", "Juegos De La Ciudad", "Wolverines Salvajes", "H�roes Del Mediocampo", "Carlewild",
                "Acumens", "�rtico Aesthe", "Jadegaming", "Empacadores De Lobos", "Date Prisa, Huracanes", "El Trueno Prospera",
                "Juego Temprano", "Simplemente Adelgazantes", "Planeadores Generales", "Silverkings", "Babie Pluckies", "Starshotters",
                "Palos Cortos", "Juego Skateful", "Luchadores", "Mobeer", "Rinoceronte Albino", "Planet Gaming", "Juegos Avanzados",
                "Sorprendentes Bolas", "Capitales R�pidas", "Codos Voladores", "Ping�ino grupos", "Redflamers", "Oldgaming",
                "Bungy Blues", "Motores M�sticos", "Movimientos �picos", "Juego Mortal", "Estrellas En Ascenso", "Juego Astron�mico",
                "Llamada De Hierba", "Lago Esparta", "Objetivo Espartano", "Campeonato De La Guerra De Las Galaxias",
                "Casa De Guerra", "Juego De Sicario", "Aplastamiento De Aves", "Aplastar Al Hombre", "Rey Del Cosmos", "Rey De Pandora",
                "Versos Sicario", "Cobes Ultimate Battle", "Esp�ritu Nova", "Juegos Extra", "Juegos R�pidos", "Juegos Grady",
                "Gradiente De Juegos", "Juego De Contraste", "Juegos Alphabate", "Uno Diez Juegos", "Futura Juegos", "Vivid Smash Gaming",
                "Copa Hombre Cubo", "Ea Sparatan", "La Candovell", "Juegos Colombiana", "Aplastadores Africanos", "Juegos Hitbird",
                "Ca Go Gaming", "Juego Competitivo", "Juego Inferno", "Juego De Platino", "Imperra Gaming"};

        int nombre = (int) Math.floor(Math.random() * nombres.length);

        return nombres[nombre];
    }

    public static Jugador[] crearJugadores(String categoria) {
        int numJugadores = Invocador.asigNumJugadores();
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


    //Crear función para determinar número de árbitros
    //Se basa en numero de equipos, donde se divide el numero de Equipos entre 2 y se crea ese numero de arbitros
    public static int generarNumeroArbitros(int numEquipos) {
        int numeroArbitros = numEquipos / 2;

        return numeroArbitros;
    }

    //Generador de árbitros
    public static Arbitro[] crearListaArbitros(int numeroArbitro) {
        Arbitro[] listaArbitro = new Arbitro[numeroArbitro];

        for (int i = 0; i < numeroArbitro; i++) {
            Arbitro arbitro = new Arbitro();
            listaArbitro[i] = arbitro;
        }
        return listaArbitro;
    }

    public void setListaArbitros(Arbitro[] listaArbitros) {
        this.listaArbitros = listaArbitros;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public static int numArbitros(int numEquipos) {
        int numArbitros = numEquipos / 2;
        return numArbitros;
    }

    @Override
    public String toString() {
        return
                "Nombre de Liga= " + nombre + '\'' +
                        ", Equipos= " + Arrays.toString(listaEquipos) + '\'' +

                        ", Arbitros= " + Arrays.toString(listaArbitros);
    }
}