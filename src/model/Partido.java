package model;


import java.time.LocalDate;

public class Partido {

    private Equipo equipoCasa;
    private Equipo equipoFuera;
    private Arbitro arbitro;
    private int golesEquipoCasa;
    private int golesEquipoFuera;
    private String horaInicio;
    private int numeroPartido;
    private LocalDate fecha;

    public Partido(Equipo equipoCasa, Equipo equipoFuera, Arbitro arbitro) {
        this.equipoCasa = equipoCasa;
        this.equipoFuera = equipoFuera;
        this.arbitro = arbitro;
    }

    public Equipo getEquipoCasa() {
        return equipoCasa;
    }
    public void setEquipoCasa(Equipo equipoCasa) {
        this.equipoCasa = equipoCasa;
    }

    public Equipo getEquipoFuera() {
        return equipoFuera;
    }
    public void setEquipoFuera(Equipo equipoFuera) {
        this.equipoFuera = equipoFuera;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public int getGolesEquipoCasa() {
        return golesEquipoCasa;
    }
    public void setGolesEquipoCasa(int golesEquipoCasa) {
        this.golesEquipoCasa = golesEquipoCasa;
    }

    public int getGolesEquipoFuera() {
        return golesEquipoFuera;
    }
    public void setGolesEquipoFuera(int golesEquipoFuera) {
        this.golesEquipoFuera = golesEquipoFuera;
    }

    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }
    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {

        return "Partido: " +
                "\nArbitro: " + arbitro.getNombre() + " " +  arbitro.getApellidos() +
                "\nEquipo Casa: " + equipoCasa.getNombre() +
                "\n\tGoles Equipo Casa: " + golesEquipoCasa +
                "\nEquipo Fuera: " + equipoFuera.getNombre() +
                "\n\tGoles Equipo Fuera: " + golesEquipoFuera;

    }
}
