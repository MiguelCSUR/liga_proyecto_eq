package model;


public class Jugador extends Persona {
    private String categoria;
    private String posicion;
    private int dorsal;
    private Equipo equipo;

    public Jugador(String nombre, String apellidos, int edad, String categoria, String posicion, int dorsal, Equipo equipo) {
        super(nombre, apellidos, edad);
        this.categoria = categoria;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "categoria='" + categoria + '\'' +
                ", posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                ", equipo=" + equipo +
                '}';
    }
}

