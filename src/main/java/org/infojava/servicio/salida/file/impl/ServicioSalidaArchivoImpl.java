package org.infojava.servicio.salida.file.impl;

import org.infojava.dominio.Jugador;
import org.infojava.servicio.salida.file.ServicioSalidaArchivo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServicioSalidaArchivoImpl implements ServicioSalidaArchivo {
    @Override
    public void exportarJugadoresEquipo(List<Jugador> jugadores, String rutaDeDestino) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))) {
            for (Jugador jugador : jugadores) {
                String linea = jugador.getNombre() + ";" +
                        jugador.getApellido() + ";" +
                        jugador.getAltura() + ";" +
                        jugador.getGoles() + ";" +
                        jugador.getPosicion() + ";" +
                        jugador.isEsCapitan() + ";" +
                        jugador.getNroCamiseta() + ";" +
                        jugador.getEquipo().getNombre();

                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportarAArchivo(String listado, String rutaDeDestino) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))) {
            writer.write(listado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


