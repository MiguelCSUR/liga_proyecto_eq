package model;

public class Arbitro extends Persona {
    int licencia;


    public Arbitro() {
        super.nombre=nombre;
        super.apellidos = apellidos;
        super.edad = edad;
        this.licencia = licencia;
    }


    public int getLicencia() {
        return licencia;
    }
    public void setLicencia() {
        this.licencia = generarLicencia();
    }

}
