package model;


public class Arbitro extends Persona {
    int licencia;

    public Arbitro() {
        super.setEdad(18, 45);
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

}
