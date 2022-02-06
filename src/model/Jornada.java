package model;


import java.util.Arrays;

public class Jornada {
    //Esto iría en Liga
    private int numeroJornadas;
    private int numeroPartidosJornada;
    private int numeroPartidosLiga;
    private Partido [][] listaJornadas;

    public Jornada(int numeroRondas, int numeroPartidosPorRonda, int numeroPartidosEnTotal, Partido [][] rondas) {
        this.numeroJornadas = numeroRondas;
        this.numeroPartidosJornada = numeroPartidosPorRonda;
        this.numeroPartidosLiga = numeroPartidosEnTotal;
        this.listaJornadas = rondas;
    }

    public int getNumeroJornadas() {
        return numeroJornadas;
    }
    public void setNumeroJornadas(int numeroJornadas) {
        this.numeroJornadas = numeroJornadas;
    }
    public int getNumeroPartidosJornada() {
        return numeroPartidosJornada;
    }
    public void setNumeroPartidosJornada(int numeroPartidosJornada) {
        this.numeroPartidosJornada = numeroPartidosJornada;
    }
    public int getNumeroPartidosLiga() {
        return numeroPartidosLiga;
    }
    public void setNumeroPartidosLiga(int numeroPartidosLiga) {
        this.numeroPartidosLiga = numeroPartidosLiga;
    }
    public Partido[][] getListaJornadas() {
        return listaJornadas;
    }
    public void setJornadas(Partido[][] rondas) {
        this.listaJornadas = rondas;
    }

    @Override
    public String toString() {
        return "Jornada [numeroRondas=" + numeroJornadas + ", numeroPartidosPorRonda=" + numeroPartidosJornada
                + ", numeroPartidosEnTotal=" + numeroPartidosLiga + ", rondas=" + Arrays.toString(listaJornadas) + "]";
    }

}

