package aed2;

import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion ();
        System.out.println(sistema.registrarPasajero("FR123.123#3", "Ignacio", 40));
    }
}
