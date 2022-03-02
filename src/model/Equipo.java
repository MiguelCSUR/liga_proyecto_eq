package model;


public class Equipo {
    private String      nombre;
    private String      club;
    private Entrenador  entrenador;
    private String      equipacionCasa;
    private String      equipacionFuera;
    private int         numJugadores;
    private Jugador[]   jugadores;

    private int puntos;
    private int goles;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public int getPuntos() {
        return puntos;
    }

    public String getEquipacionCasa() {
        return equipacionCasa;
    }
    public void setEquipacionCasa(String equipacionCasa) {
        this.equipacionCasa = equipacionCasa;
    }

    public String getEquipacionFuera() {
        return equipacionFuera;
    }
    public void setEquipacionFuera(String equipacionFuera) {
        this.equipacionFuera = equipacionFuera;
    }

    public int getNumJugadores() {
        return numJugadores;
    }
    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    public int getGoles() {
        return goles;
    }


}

