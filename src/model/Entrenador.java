package model;


public class Entrenador extends Persona{
    private int numeroLicencia;
    private Equipo equipo;

    public Entrenador() {
        super.setEdad(20, 60);
    }

    public int getNumeroLicencia() {
        return numeroLicencia;
    }
    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    public Equipo getEquipo() {
        return equipo;
    }

}
