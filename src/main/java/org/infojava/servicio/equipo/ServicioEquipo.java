package org.infojava.servicio.equipo;

import org.infojava.dominio.Equipo;
import org.infojava.dominio.Jugador;
import org.infojava.dominio.Entrenador;

import java.util.List;
import java.time.LocalDate;

public interface ServicioEquipo {
    void crearEquipo();

    void borrarEquipo();

    Equipo buscarEquipo (String nombre);

    Jugador getCapitan(Equipo equipo);

    String getStringJugadores(List<Jugador> jugadores);

    String getNombreMasEntrenador(Equipo equipo);

}
