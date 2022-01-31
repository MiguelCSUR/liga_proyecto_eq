package model;


public final class Jugador extends Persona{
    private String categoria;
    private String posicion;
    private int dorsal;
    private Equipo equipo;

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
        categoria=setCategoria(edad);

    }

    public String getCategoria() {
        return categoria;
    }

    private String setCategoria(int edad) {
        switch(edad) {
            case 4:
            case 5:
                return "Chupetín";
            case 6:
            case 7:
                return "Prebenjamín";
            case 8:
            case 9:
                return "Benjamín";
            case 10:
            case 11:
                return "Alevín";
            case 12:
            case 13:
                return "Infantil";
            case 14:
            case 15:
                return "Cadete";
            case 16:
            case 17:
            case 18:
                return "Juvenil";
            default:
                return "N/A";

        }
    }

    public String getPosicion() {
        return posicion;
    }

    public String setPosicion(int dorsal) {//Probamos si le metemos el numero del dorsal que tiene le da una posicion exacta.

        while(dorsal>11)
        {
            int numeroAleatorio = (int) Math.floor(Math.random()*12)+1;
            dorsal=numeroAleatorio;
        }
        switch(dorsal) {
            case 1:
                return "Portero";
            case 2:
                return "Lateral derecho";
            case 3:
                return "Lateral izquierdp";
            case 4:
            case 5:
                return "Central";
            case 6:
                return "Pivote";
            case 7:
                return "Extremo derecho";
            case 8:
                return "Centrocampista";
            case 9:
                return "Delantero";
            case 10:
                return "Mediapunta";
            case 11:
                return "Extremo izquierdo";
            default:
                return"Error locotron";

        }
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
        posicion=setPosicion(dorsal);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return super.toString()+", "+categoria+"\n"+
                "Equipo: "+equipo.getNombre()+"\n"+
                "Dorsal: "+dorsal+" Posición: "+posicion+"\n";
    }

}