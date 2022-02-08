package model;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;


    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getApellidos() {
        return apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getEdad() {
        return this.edad;
    }


    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " " + this.apellidos + " " + "Edad: " + this.edad;
    }


}
