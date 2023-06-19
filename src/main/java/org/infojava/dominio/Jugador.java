package org.infojava.dominio;

import java.util.UUID;

public class Jugador extends Persona {
    private UUID id;
    private double altura;
    private int goles;
    private Posicion posicion;
    private boolean esCapitan;
    private int nroCamiseta;
    private Equipo equipo;





    public Jugador(String nombre, String apellido, UUID id, double altura, int goles,
                   Posicion posicion, boolean esCapitan, int nroCamiseta, Equipo equipo) {
        super(nombre, apellido);
        this.id = id;
        this.altura = altura;
        this.goles = goles;
        this.posicion = posicion;
        this.esCapitan = esCapitan;
        this.nroCamiseta = nroCamiseta;
        this.equipo = equipo;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean isEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString(){
        return this.getNombre() + " " + this.getApellido() + " " + this.getNroCamiseta();
    }
}
