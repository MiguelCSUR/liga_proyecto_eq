package model;


import java.util.Arrays;

public class Jornada extends Calendario{
    private int numeroRondas;
    private int numeroPartidosPorRonda;
    private int numeroPartidosEnTotal;
    private Partido [][] rondas;

    public Jornada(int numeroRondas, int numeroPartidosPorRonda, int numeroPartidosEnTotal, Partido [][] rondas) {
        this.numeroRondas = numeroRondas;
        this.numeroPartidosPorRonda = numeroPartidosPorRonda;
        this.numeroPartidosEnTotal = numeroPartidosEnTotal;
        this.rondas = rondas;
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }
    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;
    }
    public int getNumeroPartidosPorRonda() {
        return numeroPartidosPorRonda;
    }
    public void setNumeroPartidosPorRonda(int numeroPartidosPorRonda) {
        this.numeroPartidosPorRonda = numeroPartidosPorRonda;
    }
    public int getNumeroPartidosEnTotal() {
        return numeroPartidosEnTotal;
    }
    public void setNumeroPartidosEnTotal(int numeroPartidosEnTotal) {
        this.numeroPartidosEnTotal = numeroPartidosEnTotal;
    }
    public Partido[][] getRondas() {
        return rondas;
    }
    public void setJornadas(Partido[][] rondas) {
        this.rondas = rondas;
    }

    @Override
    public String toString() {
        return "Jornada [numeroRondas=" + numeroRondas + ", numeroPartidosPorRonda=" + numeroPartidosPorRonda
                + ", numeroPartidosEnTotal=" + numeroPartidosEnTotal + ", rondas=" + Arrays.toString(rondas) + "]";
    }

}

