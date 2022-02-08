package model;

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

    public String[] getListaHorarios() {
        return listaHorarios;
    }
    public void setListaHorarios(String[] listaHorarios) {
        this.listaHorarios = listaHorarios;
    }
}
Ca