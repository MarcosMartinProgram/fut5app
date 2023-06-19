package org.infojava.servicio.jugador.impl;

import org.infojava.dominio.Equipo;
import org.infojava.dominio.Jugador;
import org.infojava.dominio.Posicion;
import org.infojava.servicio.entrada.file.impl.ServicioConsola;
import org.infojava.servicio.inicio.impl.ServicioInicioImpl;
import org.infojava.servicio.jugador.ServicioJugador;

import java.util.UUID;

public class ServicioJugadorImpl implements ServicioJugador {


    @Override
    public void buscarJugadorPorNombre() {
        System.out.println("*** Busqueda de jugadores por su nombre ***");
        String nombre = new ServicioConsola().solicitarString("Ingrese el nombre del jugador: ");

        String respuesta = "";


        for (Equipo equipo: ServicioInicioImpl.listaEquipos) {
            for (Jugador jugador: equipo.getListaDeJugadores()) {
                if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                    respuesta = respuesta +
                            "* Nombre: " + jugador.getNombre().toUpperCase() + " " + jugador.getApellido().toUpperCase() +
                            "\n* Posición: " + jugador.getPosicion().getNombre().toUpperCase() +
                            "\n* Capitán: " + (jugador.isEsCapitan() ? "Si" : "No") +
                            "\n* Equipo: " + jugador.getEquipo().getNombre().toUpperCase() +
                            "\n\n";
                }
            }
        }

        if (respuesta.equals("")) {
            System.out.println("No se encontraron jugadores con el nombre " + nombre);
        } else {
            System.out.println(respuesta);
        }
    }

    @Override
    public Jugador crearJugador() {
        ServicioConsola servicioConsola = new ServicioConsola();

        System.out.println(" * Ingrese datos del jugador *");
        String nombre = servicioConsola.solicitarString("Nombres: ");
        String apellido = servicioConsola.solicitarString("Apellido: ");
        double altura = servicioConsola.solicitarDouble("Altura: ");
        int goles = servicioConsola.solicitarInt("Cantidad de goles: ");
        int nroCamiseta = servicioConsola.solicitarInt("Número de camiseta: ");

        boolean esCapitan;
        String respuestaCapitan;
        do {
            respuestaCapitan = servicioConsola.solicitarSiNo("¿Es capitán?");
            esCapitan = respuestaCapitan.equalsIgnoreCase("S");
        } while (!respuestaCapitan.equalsIgnoreCase("S") &&
                !respuestaCapitan.equalsIgnoreCase("N"));

        System.out.println();
        int respuestaPosicion;
        int indice;
        Posicion posicionJugador = null;
        do {
            System.out.println("- Posiciones: ");
            for (Posicion posicion : ServicioInicioImpl.listaPosiciones) {
                indice = ServicioInicioImpl.listaPosiciones.indexOf(posicion);
                System.out.println("  " + (indice + 1) + ")" + posicion.getNombre());
            }
            respuestaPosicion = servicioConsola.solicitarInt(" - Ingrese la posición: ");
            posicionJugador = ServicioInicioImpl.listaPosiciones.get(respuestaPosicion - 1);
        } while (posicionJugador == null);

        UUID id = UUID.randomUUID();
        Equipo equipo = null; // Valor predeterminado, puedes asignar un equipo específico si es necesario

        return new Jugador(nombre, apellido, id, altura, goles, posicionJugador, esCapitan, nroCamiseta, equipo);
    }


}
