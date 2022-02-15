package model;

import java.util.Arrays;

public class Calendario {
    private Jornada[] listaJornadas;
    private Partido[] listaPartidos;
    private String[] listaHorarios = {
            "9:00", "10:30", "12:00", "16:00", "17:30", "19:00"
    };

    public Jornada[] getListaJornadas() {
        return listaJornadas;
    }
    public void setListaJornadas(Jornada[] listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public Partido[] getListaPartidos() {
        return listaPartidos;
    }
    public void setListaPartidos(Partido[] listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public void setListaPartidosConcreto(Partido partido, int i){
        this.listaPartidos[i]=partido;
    }

    public String[] getListaHorarios() {
        return listaHorarios;
    }
    public void setListaHorarios(String[] listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "listaJornadas=" + Arrays.toString(listaJornadas) +
                ", listaPartidos=" + Arrays.toString(listaPartidos) +
                ", listaHorarios=" + Arrays.toString(listaHorarios) +
                '}';
    }
}
