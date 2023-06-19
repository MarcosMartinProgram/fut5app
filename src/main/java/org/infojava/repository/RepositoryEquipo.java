package org.infojava.repository;

import org.infojava.dominio.Equipo;

public interface RepositoryEquipo {

        void guardarEquipo(Equipo equipo);

        void borrarEquipo(Equipo equipo);

        Equipo buscarEquipo(String nombre);
}
