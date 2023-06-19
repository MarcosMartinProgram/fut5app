package org.infojava.servicio.entrada.file;

import org.infojava.dominio.Jugador;
import java.util.List;

public interface ServicioEntradaArchivo {

    List<Jugador> cargarJugadoresDesdeArchivo(String rutaArchivo);
}
