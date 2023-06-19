package org.infojava.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import org.infojava.dominio.Entrenador;


public class Equipo {

    private String nombre;
    private LocalDate fechaDeCreacion;
    private List<Jugador> listaDeJugadores;
    private Entrenador entrenador;


    public Equipo(String nombre, LocalDate fechaDeCreacion, List<Jugador> jugadores, Entrenador entrenador){
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.entrenador = entrenador;
        for (Jugador jugador : jugadores) {
            jugador.setEquipo(this);
        }
        this.listaDeJugadores = jugadores;
    }

    public Equipo() {

    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Jugador> getListaDeJugadores() {
        return listaDeJugadores;
    }

    public void setListaDeJugadores(List<Jugador> listaDeJugadores) {
        this.listaDeJugadores = listaDeJugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "{Nombre: " +
                this.nombre +
                " * Fecha de creación: " +
                fecha.format(this.fechaDeCreacion) +
                "}";
    }
}
