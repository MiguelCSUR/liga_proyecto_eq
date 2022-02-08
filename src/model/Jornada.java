package model;

import java.util.Arrays;
public class Jornada {
    //Esto iría en Liga
    private Partido [] listaPartidos;

    public Jornada() {
    }
    public Partido[] getlistaPartidos() {
        return listaPartidos;
    }
    public void setListaPartidos(Partido[] partidos) {
        this.listaPartidos = partidos;
    }


}
