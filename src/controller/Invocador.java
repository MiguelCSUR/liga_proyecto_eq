//Criterios
//CREAR para Objetos propios. Ejemplos: Persona, Equipo, etc
//crearPartido() crearListaPartidos() crearEquipo
//Si creas un array de X será crearListaX(). Ejemplo crearJugador(), crearListaJugadores()

//GENERAR para atributos, propiedades, parámetros que no sean objetos propios
//generarNombre()
//Ejemplo: String, int, Integer, etc
package controller;

import model.Equipo;

public class Invocador {

    
    //TODO: PERSONA - PABLO
    //TODO: JUGADOR - PABLO
    //TODO: ENTRENADOR - PABLO
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

    public static String generarNombreEquipo(){
        String nombre = generadorMascota() + " de " + generadorCiudad();
        return nombre;
    }

    public static String generarClub(){
        String nombre = generadorCiudad() + " F.C ";
        return nombre;
    }
    //TODO: PARTIDO - MIGUE
    //TODO: JORNADA - NACHO




    //TODO: CALENDARIO - MIGUE
    //TODO: CLASIFICACION - PABLO
    //TODO: LIGA - MIGUEL



}
