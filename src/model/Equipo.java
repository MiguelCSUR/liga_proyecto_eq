package model;
import java.util.Arrays;


//En equipo generamos lo que pertenece a equipo, excepto la lista de jugadores
//TODO: pasar a una clase generadora o GenerarEquipos, los metodos generadores
public class Equipo {
    private String      nombre;
    private String      club;
    private Entrenador  entrenador; //Cualidad de Agregación
    private String      equipacionCasa;
    private String      equipacionFuera;
    private int         numJugadores;
    private Jugador[]   jugadores;

    //TODO: Estas propiedades son probisionales deberian estar en otro sitio.
    private int puntos;
    private int goles;

    public Equipo() {
        setNombre();
        setClub();
        Entrenador entrenador = new Entrenador();
        setEntrenador(entrenador);
        setEquipacionCasa();
        setEquipacionFuera();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = generadorMascota() + " de " + generadorCiudad();
    }

    public String getClub() {
        return club;
    }

    public void setClub() {
        this.club = generadorCiudad() + " F.C.";
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getEquipacionCasa() {
        return equipacionCasa;
    }

    public void setEquipacionCasa() {
        this.equipacionCasa = equipacionCasa();
    }

    public String getEquipacionFuera() {
        return equipacionFuera;
    }

    public void setEquipacionFuera() {
        this.equipacionFuera = equipacionesFuera();
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getGoles() {
        return goles;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public static int asigNumJugadores() {
        int numJugadores = (int) Math.floor(Math.random() * 9) + 11;
        return numJugadores;
    }



    //String de Equipo-----03/02  Artsiom-Tsume
    //Para invocar desde Liga correctamente.
    @Override
    public String toString() {
        return
                "Mombre de Equipo= " + nombre + "\n" +
                        ", Nombre de Club= " + club + "\n" +
                        ", Entrenador= " + entrenador +"\n" +
                        ", Equipacion Casa= " + equipacionCasa + '\'' +
                        ", Equipacion Fuera= " + equipacionFuera + "\n" +
                        ", Numero de Jugadores= " + numJugadores +"\n"+
                        ", Jugador= " + Arrays.toString(jugadores) +"\n"+"\n"
                ;
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

    //TODO renombrar equipacioncasa() y equipfuera(), no cumplen con lowerCamelCase.
    public static String equipacionCasa() {

        String[] equipC = {"Rojo-Amarillo", "Verde-Blanco", "Azul-Blanco", "Rojo-Negro", "Amarillo-Azul",
                "Naranja-Verde", "Rosa-Blanco", "Negro-Blanco", "Gris-Negro"};

        int numero = (int) Math.floor(Math.random() * equipC.length);
        // String equipacioncasa = equipC[numero];

        return equipC[numero];

    }

    public static String equipacionesFuera() {

        String[] equipF = {"Rojo", "Verde", "Azul", "Negro", "Amarillo",
                "Naranja", "Rosa", "Blanco", "Gris"};

        int numero = (int) Math.floor(Math.random() * equipF.length);
        //String equipacionfuera = equipF[numero];

        return equipF[numero];

    }
}

