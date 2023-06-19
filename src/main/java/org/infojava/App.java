package org.infojava;


import org.infojava.servicio.GestionMenu;
import org.infojava.servicio.entrada.file.impl.ServicioConsola;
import org.infojava.servicio.inicio.impl.ServicioInicioImpl;
import org.infojava.servicio.salida.file.ServicioSalidaArchivo;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        ServicioConsola.abrirScanner();
        new ServicioInicioImpl().iniciar();
        new GestionMenu().gestionarMenu();
        ServicioConsola.cerrarScanner();

        String rutaArchivo = "org/infojava/resources/jugadores_entrada.txt";

        String rutaDeDestino = "org/infojava/resources/jugadores_salida.txt";
        
    }
}
