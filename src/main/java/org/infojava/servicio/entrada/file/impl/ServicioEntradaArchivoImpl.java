package org.infojava.servicio.entrada.file.impl;

import org.apache.commons.io.FileUtils;
import org.infojava.dominio.Equipo;
import org.infojava.dominio.Jugador;
import org.infojava.dominio.Posicion;


import org.infojava.servicio.entrada.file.ServicioEntradaArchivo;
import org.infojava.servicio.validacion.ServicioValidacion;
import org.infojava.servicio.validacion.impl.ServicioValidacionImpl;


import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServicioEntradaArchivoImpl implements ServicioEntradaArchivo {
    public ServicioEntradaArchivoImpl() {
    }

    @Override
    public List<Jugador> cargarJugadoresDesdeArchivo(String rutaArchivo) {
        List<Jugador> jugadores = new ArrayList<>();
        ServicioValidacion servicioValidacionImpl = new ServicioValidacionImpl();

        try{
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
            Equipo equipo = new Equipo();
            for (String linea: lineas) {
                String[] partes = linea.split(";");

                String nombre = partes[0];
                String apellido = partes[1];
                UUID id = UUID.randomUUID();
                String altura = partes[2];
                String goles = partes[3];
                String posicion = partes[4];
                String esCapitan = partes[5];
                String nroCamiseta = partes[6];

                double doubleAltura = Double.parseDouble(altura);
                int intGoles  = Integer.parseInt(goles);
                Posicion posicionObject = new Posicion(posicion);
                int intNroCamiseta = Integer.parseInt(nroCamiseta);

                // control capitan
                boolean booleanEsCapitan = esCapitan.equalsIgnoreCase("true") &&
                        !servicioValidacionImpl.hayCapitan(jugadores);

                Jugador jugador = new Jugador(nombre, apellido, id, doubleAltura, intGoles, posicionObject, booleanEsCapitan, intNroCamiseta, equipo);
                jugadores.add(jugador);


            }

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }
}

