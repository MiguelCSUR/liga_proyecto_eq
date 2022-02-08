package model;

import java.time.LocalDate;
import java.util.Arrays;

public class Liga {

    private String nombre;
    private Equipo[] listaEquipos;
    private Calendario calendario;
    private Arbitro[] listaArbitros;
    private Clasificacion clasificacion;
    private LocalDate fechaInicio;

    public Liga(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo[] getListaEquipos() {
        return listaEquipos;
    }
    public void setListaEquipos(Equipo[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Calendario getCalendario() {
        return calendario;
    }
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Arbitro[] getListaArbitros() {
        return listaArbitros;
    }
    public void setListaArbitros(Arbitro[] listaArbitros) {
        this.listaArbitros = listaArbitros;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", listaEquipos=" + Arrays.toString(listaEquipos) +
                ", calendario=" + calendario +
                ", listaArbitros=" + Arrays.toString(listaArbitros) +
                ", clasificacion=" + clasificacion +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}