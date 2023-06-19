package org.infojava.servicio.inicio.impl;

import org.infojava.dominio.Equipo;
import org.infojava.dominio.Posicion;
import org.infojava.servicio.inicio.ServicioInicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioInicioImpl implements ServicioInicio {

        public static List<Equipo> listaEquipos = new ArrayList<>();
        public static List<Posicion> listaPosiciones = new ArrayList<>();


    @Override
    public void iniciar() {
        Posicion posicion1 = new Posicion("Arquero");
        Posicion posicion2 = new Posicion("Defensa");
        Posicion posicion3 = new Posicion("Mediocampista");
        Posicion posicion4 = new Posicion("Delantero");

        listaPosiciones.add(posicion1);
        listaPosiciones.add(posicion2);
        listaPosiciones.add(posicion3);
        listaPosiciones.add(posicion4);
    }
}
