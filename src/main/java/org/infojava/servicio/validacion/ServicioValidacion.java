package org.infojava.servicio.validacion;

import org.infojava.dominio.Jugador;

import java.util.List;

public interface ServicioValidacion {
    boolean hayCapitan(List<Jugador> jugadores);

    boolean existeElNroCamiseta(int nroCamiseta, List<Jugador> jugadores);
}

