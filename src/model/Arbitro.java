package model;

public class Arbitro extends Persona {
    int licencia;


    public Arbitro(String nombre, String apellidos, int edad, int licencia) {
        super(nombre, apellidos, edad);
        this.licencia = licencia;
    }

    public int getLicencia() {
        return licencia;
    }
    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

}
