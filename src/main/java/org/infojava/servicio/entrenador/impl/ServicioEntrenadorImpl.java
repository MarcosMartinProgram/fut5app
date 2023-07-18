package org.infojava.servicio.entrenador.impl;

import org.infojava.dominio.Entrenador;
import org.infojava.servicio.entrada.file.impl.ServicioConsola;
import org.infojava.servicio.entrenador.ServicioEntrenador;

import java.time.LocalDate;

public class ServicioEntrenadorImpl implements ServicioEntrenador {

    @Override
    public Entrenador crearEntrenador() {
        String nombre = "";
        String apellido = "";
        int diaNacimiento, mesNacimiento, anioNacimiento;
        ServicioConsola servicioConsola = new ServicioConsola();

        nombre = servicioConsola.solicitarString("Nombres del entrenador: ");

        apellido = servicioConsola.solicitarString("Apellido del entrenador: ");

        diaNacimiento = servicioConsola.solicitarInt("Día de nacimiento del entrenador: ");

        mesNacimiento = servicioConsola.solicitarInt("Mes de nacimiento del entrenador: ");

        anioNacimiento = servicioConsola.solicitarInt("Año de nacimiento del entrenador: ");

        return new Entrenador(nombre, apellido, LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento));
    }
}
