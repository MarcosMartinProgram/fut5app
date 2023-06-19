package org.infojava.servicio.jugador;

import org.infojava.dominio.Jugador;

public interface ServicioJugador {
    void buscarJugadorPorNombre();

    Jugador crearJugador();
}
