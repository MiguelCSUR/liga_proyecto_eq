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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invocador {

    static DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO: DATE
    public static String dateToString(LocalDate fecha) {
        return fecha.format(FORMATOFECHA);
    }

    public static LocalDate stringToDate(String fecha) {
        return LocalDate.parse(fecha, FORMATOFECHA);
    }

    //TODO: PERSONA - PABLO
    public static Persona crearPersona(int edadMin, int edadMax) {
        Persona persona = new Persona(generarNombrePersona(), generarApellidos(), generarEdad(edadMin, edadMax));
        return persona;
    }


    public static String generarNombrePersona() {

        String[] listaNombres = {"Altair", "Ezio", "Sora", "Connor", "Kratos", "Link", "Zelda", "Kirby", "Megaman", "Bowser",
                "Ratchet", "Donkey Kong", "Goku", "Doraemon", "Perchita", "Suneo", "Gandalf", "Frodo", "Bilbo",
                "Dovahkiin", "Sonic", "Cloud", "Sephiroth", "Dante", "Geralt", "Trevor", "Victor", "Jinx", "VI", "Catelyn",
                "Katarina", "Treiny", "Shuna", "Talim", "Ivy", "CJ", "Spyro", "Squall", "Yuna", "Riku", "Jill", "Wesker",
                "Kassandra", "Alexios", "Luigi", "C�trico", "Culo", "Duke", "Tifa", "Alucard", "Drake", "Koopa", "Axel", "Arwen",
                "Eowyn", "Sakura", "Naruto", "Ash", "Sasuke", "Vegeta", "Sauron", "Legolas", "Leia", "Luke", "Vader", "FerNardo", "PENElope"};

        int random = (int) Math.floor(Math.random() * listaNombres.length);
        return listaNombres[random];
    }

    public static String generarApellidos() {
        String listaApellidos[] = {"Marui", "Shima", "Sawa", "Toyo", "Cromwell", "Keller", "Perdido", "Zimmerman", "Anderson", "Gasper", "Degurechaff", "Jimenez",
                "Gonzalez", "Lamata", "Feliz", "Bragueta", "Amiano", "Enamorado", "Nigote", "Delano", "Messina",
                "Di Montelroso", "Krauser", "Marston", "Auditore", "Bernstein", "Bogard", "Briggs", "Chaolan", "Eggman", "Dorian", "Dragunov",
                "Drake", "Winters", "Falcon", "Freeman", "Hudson", "Ibn-La' Ahad", "Yamazaki", "Wesker", "Snake", "Tsung", "Takahashi", "Strife",
                "Schugerg", "Schtauffen", "Sakazaki", "Hayabusa", "Porter", "Nikaido", "Nanakase", "Chief", "Tyrell", "Lannister", "Baratheon",
                "Martell", "Stark", "Targaryen", "Tully", "Okabe", "Krusoe", "Vergassola", "Ali Baba", "Serebriakov", "Sempai"};

        int random1 = (int) Math.floor(Math.random() * listaApellidos.length);
        int random2 = (int) Math.floor(Math.random() * listaApellidos.length);
        return listaApellidos[random1] + " " + listaApellidos[random2];
    }

    public static int generarEdad(int edadMax, int edadMin) {
        return (int) Math.floor(Math.random() * (edadMax - edadMin)) + edadMin;
    }

    //TODO: JUGADOR - PABLO
    //TODO: ENTRENADOR - PABLO
    public static int generarLicencia() {
        return (int) Math.floor(Math.random() * 10000);
    }

    //TODO: ARBITRO - PABLO

    public static void crearArbitro(int edadMin, int edadMax) {
        Arbitro arbitro = new Arbitro(
                generarNombrePersona(),
                generarApellidos(),
                generarEdad(edadMin, edadMax),
                generarLicencia());
    }

    //TODO: ARBITRO - PABLO

    //TODO: EQUIPO - NACHO
    //Generador de mascotas de los equipos
    public static String generadorMascota() {
        String[] nombre = {"Los Anfisbenas", "Las Aracnes", "Los Argos", "Los Basiliscos", "Los Centauros", "Los Ceerberos", "Los Cetus",
                "Los Cercopes", "Los Carontes", "Los Caribdis", "Los Ciclopes", "Los Demonios", "Los Eurinomos", "Las Empusas",
                "Las Erinias", "Los Gegenes", "Los Geriones", "Los Gigantes", "Las Gorgonas", "Las Grayas", "Los Hecatonquiros",
                "Las Arpias", "Los Hipocampos", "Los Ictiocentauros", "Los Ipotanes", "Los Keres", "Los Kobalos", "Los Lestrigones",
                "Los Licaones", "Las Lamias", "Las Hidras de Lerna", "Los Leones", "Las Manticoras", "Los Makhais",
                "Los Minotauros", "Los Mormos", "Los Onocentauros", "Los Ofiotauros", "Los Oriones", "Los Ortros", "Los Panes",
                "Los Satiros", "Las Escilas", "Las Sirenas", "Los Taraxipos", "Los Telequines", "Los Tifones", "Los Grifos",
                "Los Fenix", "Los Alkonostes", "Los Balwani", "Los Koscheii", "Los Lisovikii", "Los Peruni", "Las Rusalki",
                "Los Vodianie", "Los Vondiki", "Los Domovie", "Los Chleni", "Los Jui", "Las Siski", "Las Zhopi", "Los Mineti"};

        int nom = (int) Math.floor(Math.random() * nombre.length);

        return nombre[nom];
    }

    //Generador de nombres equipos
    public static String generadorCiudad() {
        String[] nombre = {"Pueblo Paleta", "Ciudad Verde", "Ciudad Plateada", "Ciudad Celeste", "Ciudad Carmin", "Ciudad Lavanda",
                "Ciudad Azulona", "Ciudad Azafran", "Ciudad Fucsia", "Isla Canela", "Pueblo Primavera", "Ciudad Cerezo",
                "Ciudad Malva", "Pueblo Azalea", "Ciudad Trigal", "Ciudad Iris", "Ciudad Olivo", "Ciudad Orquidea",
                "Pueblo Caoba", "Ciudad Endrino", "Ciudad Blanca", "Villa Raiz", "Pueblo Escaso", "Ciudad Petalia",
                "Ciudad Ferrica", "Pueblo Azuliza", "Ciudad Portual", "Ciudad Malvalona", "Pueblo Verdegal",
                "Pueblo Paradal", "Pueblo Lavacalda", "Ciudad Arborada", "Ciudad Calagua", "Ciudad Algaria",
                "Arrecipolis", "Pueblo oromar", "Ciudad Colosalia", "Isla Prima", "Isla Secunda", "Isla Tera", "Isla Quarta",
                "Isla Inta", "Isla Eta", "Isla Inta", "Ciudad Oasis", "Pueblo Pirita", "Villa Agata", "Basix", "Puerto Ancla",
                "Isla Tempesta", "Villavera", "Otonia", "Hiberna", "Villaestio", "Ciudad Canal", "Pueblo Caelestis",
                "Pueblo Haruba", "Pueblo Arcilla", "Pueblo Terracota", "Ciudad Gres", "Ciudad Esmalte", "Ciudad Porcelana",
                "Ciudad Mayolica", "Pueblo Biscuit", "Ciudad Fayenza", "Ciudad Caolin"};

        int aleatorio = (int) Math.floor(Math.random() * nombre.length);

        return nombre[aleatorio];
    }

    //Creamos las equipaciones de los equipos de casa y se la damos
    public static String generadorEquipacionCasa() {

        String[] equipC = {"Rojo-Amarillo", "Verde-Blanco", "Azul-Blanco", "Rojo-Negro", "Amarillo-Azul",
                "Naranja-Verde", "Rosa-Blanco", "Negro-Blanco", "Gris-Negro"};

        int numero = (int) Math.floor(Math.random() * equipC.length);
        // String equipacioncasa = equipC[numero];

        return equipC[numero];

    }

    //Creamos las equipaciones de los equipos de fuera y se la damos
    public static String generadorEquipacionFuera() {

        String[] equipF = {"Rojo", "Verde", "Azul", "Negro", "Amarillo",
                "Naranja", "Rosa", "Blanco", "Gris"};

        int numero = (int) Math.floor(Math.random() * equipF.length);
        //String equipacionfuera = equipF[numero];

        return equipF[numero];

    }

    //Creamos un numero aleatorio para elejir el maximo de jugadores que tendra un equipo
    public static int asigNumJugadores() {
        int numJugadores = (int) Math.floor(Math.random() * 9) + 11;
        return numJugadores;
    }

    public static Equipo crearEquipo(String categoria) {
        Equipo equipo = new Equipo();
        equipo.setJugadores(crearJugadores(categoria));
        equipo.setNombre(generarNombreEquipo());
        equipo.setEquipacionCasa(generadorEquipacionCasa());
        equipo.setEquipacionCasa(generadorEquipacionFuera());
        equipo.setClub(generarClub());
        equipo.setEntrenador(generarEntrenador());
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
        String nombre = generadorMascota() + " de " + generadorCiudad();
        return nombre;
    }

    public static String generarClub() {
        String nombre = generadorCiudad() + " F.C ";
        return nombre;
    }

    //TODO: PARTIDO - MIGUE

    //TODO: JORNADA - NACHO
    public static Jornada[] crearListaJornadas(Equipo[] listaEquipos, Arbitro[] listaArbitros) {
        //x y son variables auxiliares para hacer facilmente "la elaboración de fixture" visto en https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
        //Creamos las variables que eligen el numero de partidos que hay
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
    {
        public static Partido[] crearPartidosJornadaParIda ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = numeroEquipos / 2;
        int x = 0;
        int y = numeroEquipos - 2;
        Partido[] partido = new Partido[partidosPorRonda];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                if (numeroJornada % 2 == 0)
                    partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
                else
                    partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
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

        public static Partido[] crearPartidosJornadaParVuelta ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
        int numeroEquipos = listaEquipos.length;
        int partidosPorRonda = numeroEquipos / 2;
        int x = 0;
        int y = numeroEquipos - 2;
        Partido[] partido = new Partido[partidosPorRonda];
        for (int j = 0; j < partidosPorRonda; j++) {
            if (j == 0) {
                if (numeroJornada % 2 == 0)
                    partido[j] = crearPartido(listaEquipos[(numeroEquipos - 1)], listaEquipos[x], listaArbitros[j]);
                else
                    partido[j] = crearPartido(listaEquipos[x], listaEquipos[(numeroEquipos - 1)], listaArbitros[j]);
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

        public static Partido[] crearPartidosJornadaImparIda ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
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

        public static Partido[] crearPartidosJornadaImparVuelta ( int numeroJornada, Equipo[] listaEquipos, Arbitro[]
        listaArbitros){
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
    }


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
