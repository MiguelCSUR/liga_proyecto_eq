package model;


public class Jugador extends Persona {
    private String categoria;
    private String posicion;
    private int dorsal;
    private Equipo equipo;

    public void setJugador(int dorsal, Equipo equipo) {
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    public String getCategoria(String chupetin) {
        return categoria;
    }

    public int setCategoria(String categoria) {
        switch (categoria) {
            case "Chupetin":
                super.setEdad(4, 5);
                return super.getEdad();
            case "Prebenjamín":
                super.setEdad(6, 7);
                return super.getEdad();
            case "Benjamín":
                super.setEdad(8, 9);
                return super.getEdad();
            case "Alevín":
                super.setEdad(10, 11);
                return super.getEdad();
            case "Infantil":
                super.setEdad(12, 13);
                return super.getEdad();
            case "Cadete":
                super.setEdad(14, 15);
                return super.getEdad();
            case "Juvenil":
                super.setEdad(16, 18);
                return super.getEdad();
            default:
                super.setEdad(19, 38);
                return super.getEdad();
        }
    }

    private String getPosicion() {
        return posicion;
    }

    public String setPosicion(int dorsal) {//Probamos si le metemos el numero del dorsal que tiene le da una posicion exacta.

        while (dorsal > 11) {
            int numeroAleatorio = (int) Math.floor(Math.random() * 12) + 1;
            dorsal = numeroAleatorio;
        }
        switch (dorsal) {
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
                return "Error se sale de dorsal en Jugador.setPosition()";

        }
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
        posicion = setPosicion(dorsal);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + categoria + "\n" +
                "Equipo: " + equipo.getNombre() + "\n" +
                "Dorsal: " + dorsal + " Posición: " + posicion + "\n";
    }

}
