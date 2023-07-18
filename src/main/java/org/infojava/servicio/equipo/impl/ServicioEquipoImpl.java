package org.infojava.servicio.equipo.impl;

import org.infojava.dominio.Entrenador;
import org.infojava.dominio.Equipo;
import org.infojava.dominio.Jugador;
import org.infojava.servicio.entrada.file.ServicioEntradaArchivo;
import org.infojava.servicio.entrada.file.impl.ServicioConsola;
import org.infojava.servicio.entrada.file.impl.ServicioEntradaArchivoImpl;
import org.infojava.servicio.entrenador.ServicioEntrenador;
import org.infojava.servicio.entrenador.impl.ServicioEntrenadorImpl;
import org.infojava.servicio.equipo.ServicioEquipo;
import org.infojava.servicio.inicio.impl.ServicioInicioImpl;
import org.infojava.servicio.jugador.ServicioJugador;
import org.infojava.servicio.jugador.impl.ServicioJugadorImpl;
import org.infojava.servicio.validacion.ServicioValidacion;
import org.infojava.servicio.validacion.impl.ServicioValidacionImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServicioEquipoImpl implements ServicioEquipo {

    private ServicioEntrenador servicioEntrenador = new ServicioEntrenadorImpl();
    @Override
    public void crearEquipo() {
        String entrada = "";
        String nombreEquipo = "";
        int dia, mes, anio;
        ServicioConsola servicioConsola = new ServicioConsola();

        do {

            nombreEquipo = servicioConsola.solicitarString("Nombre del equipo: ");

            dia = servicioConsola.solicitarInt("Día de creación: ");

            mes = servicioConsola.solicitarInt("Mes de creación: ");

            anio = servicioConsola.solicitarInt("Año de creación: ");

            System.out.println();

            Entrenador entrenador = servicioEntrenador.crearEntrenador();

            List<Jugador> jugadores = this.cargarJugadores();

            Equipo equipo = new Equipo(nombreEquipo, LocalDate.of(anio, mes, dia),
                    jugadores, entrenador);

            entrada = servicioConsola.solicitarSiNo("¿Cargar otro equipo?");

            ServicioInicioImpl.listaEquipos.add(equipo);

        } while (!entrada.equalsIgnoreCase("N"));
    }


    private List<Jugador> cargarJugadores() {
        String agregaDesdeArchivo = new ServicioConsola().solicitarSiNo("¿Agregar jugadores desde archivo 'jugadores.txt'?");

        if (agregaDesdeArchivo.equalsIgnoreCase("S")) {
            String rutaArchivo = "src/main/java/org/infojava/resources/jugadores.txt";
            ServicioEntradaArchivo entradaArchivo = new ServicioEntradaArchivoImpl();
            return entradaArchivo.cargarJugadoresDesdeArchivo(rutaArchivo);
        } else {
            return this.cargarJugadoresPorConsola();
        }
    }

    private List<Jugador> cargarJugadoresPorConsola() {
        List<Jugador> jugadores;
        ServicioValidacion servicioValidacionImpl = new ServicioValidacionImpl();

        ServicioJugador servicioJugador = new ServicioJugadorImpl();
        jugadores = new ArrayList<>();
        Jugador jugador = null;

        for (int i = 0; i < 5; i++) {
            jugador = servicioJugador.crearJugador();
            jugador.setEsCapitan(jugador.isEsCapitan() && !servicioValidacionImpl.hayCapitan(jugadores));

            while (servicioValidacionImpl.existeElNroCamiseta(jugador.getNroCamiseta(), jugadores)) {
                int nroCamiseta = new ServicioConsola().solicitarInt("Número de camiseta repetido, ingrese otro: ");
                jugador.setNroCamiseta(nroCamiseta);
            }
            jugadores.add(jugador);
            System.out.println();
        }
        return jugadores;
    }

    @Override
    public void borrarEquipo() {
        System.out.println("*** Borrar un equipo ***");
        String nombreEquipo = new ServicioConsola().solicitarString("Nombre del equipo a borrar: ");

        List<Equipo> equipoLinkedList = new LinkedList<>();
        equipoLinkedList.addAll(ServicioInicioImpl.listaEquipos);
        boolean seEncontro = false;
        for (Equipo equipo: equipoLinkedList) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)){
                seEncontro = true;
                equipoLinkedList.remove(equipo);
                break;
            }
        }
        ServicioInicioImpl.listaEquipos.clear();
        ServicioInicioImpl.listaEquipos.addAll(equipoLinkedList);
        if (seEncontro) {
            System.out.println("El equipo " + nombreEquipo + " fue borrado.");
        } else {
            System.out.println(nombreEquipo + " no figura en la lista de equipos.");
        }
    }

    @Override
    public Equipo buscarEquipo(String nombre) {
        Equipo equipoEncontrado = null;
        for (Equipo equipo: ServicioInicioImpl.listaEquipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)){
                equipoEncontrado = equipo;
                break;
            }
        }
        if (equipoEncontrado == null) {
            System.out.println("No se encontró el equipo " + nombre);
        }
        return equipoEncontrado;
    }

    @Override
    public Jugador getCapitan(Equipo equipo) {
        Jugador capitan = null;
        for (Jugador jugador : equipo.getListaDeJugadores()) {
            if (jugador.isEsCapitan()) {
                capitan = jugador;
                break;
            }
        }
        return capitan;
    }

    @Override
    public String getStringJugadores(List<Jugador> jugadores) {
        String respuesta = "";
        for (Jugador jugador : jugadores) {
            respuesta = respuesta +
                    " - " + jugador.getNombre().toUpperCase() + " " + jugador.getApellido().toUpperCase() +
                    " " + jugador.getNroCamiseta() +
                    "\n";
        }
        return respuesta;
    }

    @Override
    public String getNombreMasEntrenador(Equipo equipo) {
        String entrenador = (equipo.getEntrenador() != null ?
                equipo.getEntrenador().getNombre() + " " + equipo.getEntrenador().getApellido() :
                "Sin entrenador");
        String respuesta = "" +
                "* Nombre: " + equipo.getNombre().toUpperCase() +
                "\n* Entrenador: " + entrenador.toUpperCase();
        return respuesta;
    }


}
