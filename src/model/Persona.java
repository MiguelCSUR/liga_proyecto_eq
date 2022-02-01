package model;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    //Constructor
    public Persona() {
        this.apellidos = apellidoCreador() + " " + apellidoCreador();
        this.nombre = nombreCreador();
    }


    //NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //APELLIDOS
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos() {
        this.apellidos = apellidoCreador();
    }

    //EDAD
    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edadMin, int edadMax) {
        int edad = (int) Math.floor(Math.random() * (edadMax - edadMin)) + edadMin;
        this.edad = edad;
    }

    //GENERADOR SYSO
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " " + this.apellidos + "\n" + "Edad: " + this.edad;
    }


    //Generador de Apellidos aleatorios
    public static String apellidoCreador() {
        String apellidos[] = {"Marui", "Shima", "Sawa", "Toyo", "Cromwell", "Keller", "Perdido", "Zimmerman", "Anderson", "Gasper", "Degurechaff", "Jimenez",
                "Gonzalez", "Lamata", "Feliz", "Bragueta", "Amiano", "Enamorado", "Nigote", "Delano", "Messina",
                "Di Montelroso", "Krauser", "Marston", "Auditore", "Bernstein", "Bogard", "Briggs", "Chaolan", "Eggman", "Dorian", "Dragunov",
                "Drake", "Winters", "Falcon", "Freeman", "Hudson", "Ibn-La' Ahad", "Yamazaki", "Wesker", "Snake", "Tsung", "Takahashi", "Strife",
                "Schugerg", "Schtauffen", "Sakazaki", "Hayabusa", "Porter", "Nikaido", "Nanakase", "Chief", "Tyrell", "Lannister", "Baratheon",
                "Martell", "Stark", "Targaryen", "Tully", "Okabe", "Krusoe", "Vergassola", "Ali Baba", "Serebriakov"};


        int numero = (int) Math.floor(Math.random() * apellidos.length);
        //String apellido = apellidos[numero];
        return apellidos[numero];
    }


    public static String nombreCreador() {

        String[] nombres = {"Altair", "Ezio", "Sora", "Connor", "Kratos", "Link", "Zelda", "Kirby", "Megaman", "Bowser",
                "Ratchet", "Donkey Kong", "Goku", "Doraemon", "Perchita", "Suneo", "Gandalf", "Frodo", "Bilbo",
                "Dovahkiin", "Sonic", "Cloud", "Sephiroth", "Dante", "Geralt", "Trevor", "Victor", "Jinx", "VI", "Catelyn",
                "Katarina", "Treiny", "Shuna", "Talim", "Ivy", "CJ", "Spyro", "Squall", "Yuna", "Riku", "Jill", "Wesker",
                "Kassandra", "Alexios", "Luigi", "Cicerón", "Duke", "Tifa", "Alucard", "Drake", "Koopa", "Axel", "Arwen",
                "Eowyn", "Sakura", "Naruto", "Ash", "Sasuke", "Vegeta", "Sauron", "Legolas", "Leia", "Luke", "Vader", "Rosa"};


        int numero = (int) Math.floor(Math.random() * nombres.length);
        String nombre = nombres[numero];

        return nombres[numero];

    }
}
