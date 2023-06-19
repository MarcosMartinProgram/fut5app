package org.infojava.repository.impl;

import org.infojava.dominio.Equipo;
import org.infojava.repository.RepositoryEquipo;
import org.infojava.servicio.inicio.impl.ServicioInicioImpl;

import java.util.LinkedList;
import java.util.List;

public class RepositoryEquipoImpl implements RepositoryEquipo {
    @Override
    public void guardarEquipo(Equipo equipo) {
        ServicioInicioImpl.listaEquipos.add(equipo);
    }

    @Override
    public void borrarEquipo(Equipo equipo) {
        List<Equipo> equipoLinkedList = new LinkedList<>();
        equipoLinkedList.addAll(ServicioInicioImpl.listaEquipos);
        if(equipoLinkedList.remove(equipo)){
            ServicioInicioImpl.listaEquipos.clear();
            ServicioInicioImpl.listaEquipos.addAll(equipoLinkedList);
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
}
