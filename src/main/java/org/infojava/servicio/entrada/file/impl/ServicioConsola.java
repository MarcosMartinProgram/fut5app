package org.infojava.servicio.entrada.file.impl;

import java.util.Scanner;

public class ServicioConsola {
    public static Scanner scanner;

    public static void abrirScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public String solicitarString(String msjSolicitud) {
        System.out.print(msjSolicitud);
        return scanner.nextLine();
    }

    public int solicitarInt(String msjSolicitud){
        System.out.print(msjSolicitud);
        String input = scanner.nextLine();
        int numeroEntero = Integer.parseInt(input);
        return numeroEntero;
    }

    public double solicitarDouble(String msjSolicitud){
        System.out.print(msjSolicitud);
        double numeroDouble = scanner.nextDouble();
        scanner.nextLine();
        return numeroDouble;
    }

    public String solicitarSiNo (String pregunta){
        System.out.print(pregunta + " S) Si - N) No: ");
        String respuesta = scanner.nextLine();
        return respuesta;
    }
}
