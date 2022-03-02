package data;

import controller.Invocador;

import java.time.format.DateTimeFormatter;

public class Nombres {

    public static DateTimeFormatter formatoFecha() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatoFecha;
    }

    public static int[] probabilidadesGoles() {
        int[] probabilidadesGoles = Invocador.generadorProbabilidades();
        return probabilidadesGoles;
    }

    public static String[] listaCategorias() {
        return new String[] {"Chupetín", "Prebenjamín", "Benjamín", "Alevín", "Infantil", "Cadete", "Juvenil"};
    }

    public static String[] ligaNombres() {
        return new String[]{"Juegos Pentacard", "Juegos De Westcoast", "Mightyming Gaming", "Puente Escarlata", "Club De Pixelmate", "Juegos De Appleton",
                "Juegos De Winocrew", "Club De Costa Blanca", "Mysticmerry", "Bridgeburst Club", "Juegos Scruze Mate", "Brightnest",
                "Urbanmad", "Puentesplash", "Beyondhappy", "Cluestatis", "Cappacale", "Bridgestrive", "Ganar Emocionante", "Tripulación Carmesí",
                "Magnizent Gaming", "Betterbuddy Club", "Trujoy Gaming", "Juegos De Sprucecity", "Juegos De Purplemate", "Greyurbener Club",
                "Juegos De Motherbricks", "Secretsquare", "Fusiondream Bri Dge Club", "Club Streetshine", "Avonbuddy Gaming", "Redchromo Gaming",
                "Bringup Gaming", "Serenedive Gaming", "Goodjolly Gaming", "Magma Unido", "Juegos Ascendentes", "El Juego Rejoy", "Juegos De Grandgalas",
                "Delight Wings Gaming", "Alphaberry", "Cardzest", "Juegos De Red Daisy", "Juegos De Maypetals", "Treandybeat Gaming",
                "Madera Amarilla", "Costa De Columbia", "Juegos De Bridge Drive", "Juegos De Crowdvalley", "Seastone Gaming", "Dreamfiesta",
                "Juegos Bluespiritan", "Bridgecube", "Northsmith Gaming", "Goodwish Gaming", "Costa Tropical", "Brazos De Palma", "Bling Coasta",
                "Claramonte Gaming", "Juegos De Starmotion", "Juegos De Ridgeberry", "Whitejets", "Wildhusky", "Gameglider", "Junglegamer",
                "Dungygamer", "Dedos Pegajosos", "Escorpiones Afilados", "Jugador Mortal", "Jugador Extraño",
                "Reales Arriesgados", "Señorita Masters", "Fabuskaters", "Espadas De Juego", "Sunnydogs", "Oppo Smashers", "Jugador De Tiro",
                "Cometas Cúbicos", "Magnetbuddies", "Charmy Challengers", "Jugadores Poderosos", "Cuchillas Ardientes", "Xtremers De Nieve",
                "Stronggaming", "Mad Heeters", "Scarygoons", "Mad Metroniss", "Mastercrews", "Cuchillas De Acero", "Lave Raisers",
                "Bobcate Blasters", "Thrashers Ordenado", "Doncella Bliss", "Glovegaming", "Bestia Del Este", "Juegos De Bestia Tormentosa",
                "Mettle Blades", "Hat Trick Java", "Juegos De La Ciudad", "Wolverines Salvajes", "Héroes Del Mediocampo", "Carlewild",
                "Acumens", "Ártico Aesthe", "Jadegaming", "Empacadores De Lobos", "Date Prisa, Huracanes", "El Trueno Prospera",
                "Juego Temprano", "Simplemente Adelgazantes", "Planeadores Generales", "Silverkings", "Babie Pluckies", "Starshotters",
                "Palos Cortos", "Juego Skateful", "Luchadores", "Mobeer", "Rinoceronte Albino", "Planet Gaming", "Juegos Avanzados",
                "Sorprendentes Bolas", "Capitales Rápidas", "Codos Voladores", "Pingüino grupos", "Redflamers", "Oldgaming",
                "Bungy Blues", "Motores Místicos", "Movimientos Épicos", "Juego Mortal", "Estrellas En Ascenso", "Juego Astronómico",
                "Llamada De Hierba", "Lago Esparta", "Objetivo Espartano", "Campeonato De La Guerra De Las Galaxias",
                "Casa De Guerra", "Juego De Sicario", "Aplastamiento De Aves", "Aplastar Al Hombre", "Rey Del Cosmos", "Rey De Pandora",
                "Versos Sicario", "Cobes Ultimate Battle", "Espíritu Nova", "Juegos Extra", "Juegos Rápidos", "Juegos Grady",
                "Gradiente De Juegos", "Juego De Contraste", "Juegos Alphabate", "Uno Diez Juegos", "Futura Juegos", "Vivid Smash Gaming",
                "Copa Hombre Cubo", "La Candovell", "Juegos Colombiana", "Aplastadores Africanos", "Juegos Hitbird",
                "Ca Go Gaming", "Juego Competitivo", "Juego Inferno", "Juego De Platino", "Imperra Gaming"};
    }

    public static String[] personaNombres() {
        return new String[] {"Altair", "Ezio", "Sora", "Connor", "Kratos", "Link", "Zelda", "Kirby", "Megaman", "Bowser",
                "Ratchet", "Donkey Kong", "Goku", "Doraemon", "Perchita", "Suneo", "Gandalf", "Frodo", "Bilbo",
                "Dovahkiin", "Sonic", "Cloud", "Sephiroth", "Dante", "Geralt", "Trevor", "Victor", "Jinx", "VI", "Catelyn",
                "Katarina", "Treiny", "Shuna", "Talim", "Ivy", "CJ", "Spyro", "Squall", "Yuna", "Riku", "Jill", "Wesker",
                "Kassandra", "Alexios", "Luigi", "Cítrico", "Duke", "Tifa", "Alucard", "Drake", "Koopa", "Axel", "Arwen",
                "Eowyn", "Sakura", "Naruto", "Ash", "Sasuke", "Vegeta", "Sauron", "Legolas", "Leia", "Luke", "Vader"};
    }

    public static String[] personaApellidos() {
        return new String[] {"Marui", "Shima", "Sawa", "Toyo", "Cromwell", "Keller", "Perdido", "Zimmerman", "Anderson", "Gasper",
                "Degurechaff", "Jimenez", "Gonzalez", "Lamata", "Feliz", "Bragueta", "Amiano", "Enamorado", "Nigote", "Delano", "Messina",
                "Di Montelroso", "Krauser", "Marston", "Auditore", "Bernstein", "Bogard", "Briggs", "Chaolan", "Eggman", "Dorian", "Dragunov",
                "Drake", "Winters", "Falcon", "Freeman", "Hudson", "Ibn-La' Ahad", "Yamazaki", "Wesker", "Snake", "Tsung", "Takahashi", "Strife",
                "Schugerg", "Schtauffen", "Sakazaki", "Hayabusa", "Porter", "Nikaido", "Nanakase", "Chief", "Tyrell", "Lannister", "Baratheon",
                "Martell", "Stark", "Targaryen", "Tully", "Okabe", "Krusoe", "Vergassola", "Ali Baba", "Serebriakov", "Sempai"};
    }

    public static String[] mascotaNombres(){
        return new String [] {"Los Anfisbenas", "Las Aracnes", "Los Argos", "Los Basiliscos", "Los Centauros", "Los Ceerberos", "Los Cetus",
                "Los Cercopes", "Los Carontes", "Los Caribdis", "Los Ciclopes", "Los Demonios", "Los Eurinomos", "Las Empusas", "Las Erinias",
                "Los Gegenes", "Los Geriones", "Los Gigantes", "Las Gorgonas", "Las Grayas", "Los Hecatonquiros", "Las Arpias", "Los Hipocampos",
                "Los Ictiocentauros", "Los Ipotanes", "Los Keres", "Los Kobalos", "Los Lestrigones", "Los Licaones", "Las Lamias",
                "Las Hidras de Lerna", "Los Leones", "Las Manticoras", "Los Makhais", "Los Minotauros", "Los Mormos", "Los Onocentauros",
                "Los Ofiotauros", "Los Oriones", "Los Ortros", "Los Panes", "Los Satiros", "Las Escilas", "Las Sirenas", "Los Taraxipos",
                "Los Telequines", "Los Tifones", "Los Grifos", "Los Fenix", "Los Alkonostes", "Los Balwani", "Los Koscheii", "Los Lisovikii",
                "Los Peruni", "Las Rusalki", "Los Vodianie", "Los Vondiki", "Los Domovie", "Los Chleni", "Los Jui", "Las Siski", "Las Zhopi", "Los Mineti"};
    }

    public static String [] ciudadNombres(){
        return new String []     {"Pueblo Paleta", "Ciudad Verde", "Ciudad Plateada", "Ciudad Celeste", "Ciudad Carmin", "Ciudad Lavanda", "Ciudad Azulona",
                "Ciudad Azafran", "Ciudad Fucsia", "Isla Canela", "Pueblo Primavera", "Ciudad Cerezo", "Ciudad Malva", "Pueblo Azalea", "Ciudad Trigal",
                "Ciudad Iris", "Ciudad Olivo", "Ciudad Orquidea", "Pueblo Caoba", "Ciudad Endrino", "Ciudad Blanca", "Villa Raiz", "Pueblo Escaso", "Ciudad Petalia",
                "Ciudad Ferrica", "Pueblo Azuliza", "Ciudad Portual", "Ciudad Malvalona", "Pueblo Verdegal", "Pueblo Paradal", "Pueblo Lavacalda", "Ciudad Arborada",
                "Ciudad Calagua", "Ciudad Algaria", "Arrecipolis", "Pueblo oromar", "Ciudad Colosalia", "Isla Prima", "Isla Secunda", "Isla Tera", "Isla Quarta",
                "Isla Inta", "Isla Eta", "Isla Inta", "Ciudad Oasis", "Pueblo Pirita", "Villa Agata", "Basix", "Puerto Ancla", "Isla Tempesta", "Villavera", "Otonia",
                "Hiberna", "Villaestio", "Ciudad Canal", "Pueblo Caelestis", "Pueblo Haruba", "Pueblo Arcilla", "Pueblo Terracota", "Ciudad Gres", "Ciudad Esmalte",
                "Ciudad Porcelana", "Ciudad Mayolica", "Pueblo Biscuit", "Ciudad Fayenza", "Ciudad Caolin"};
    }

    public static String[] equipacionesCasa() {
       return new  String[] {"Rojo-Amarillo", "Verde-Blanco", "Azul-Blanco", "Rojo-Negro", "Amarillo-Azul", "Naranja-Verde", "Rosa-Blanco", "Blanco"};
    }

    public static String[] equipacionesFuera() {
        return new String[] {"Verde", "Rojo", "Amarillo", "Negro", "Morado", "Azul", "Negro", "Morado"};
    }

}
