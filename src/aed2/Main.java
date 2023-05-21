package aed2;

import aed2.dominio.Estacion;
import aed2.dominio.Pasajero;
import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion();
        System.out.println(sistema.inicializarSistema(6));


        System.out.println("----------TESTEO METODO registrarPasajero----------" + "\n");

        System.out.println(sistema.registrarPasajero("FR123.123#3", "Ignacio", 30));
        System.out.println(sistema.registrarPasajero("DE724.187#1", "Pedro", 28));
        System.out.println(sistema.registrarPasajero("UK805.978#8", "Juan", 54));
        System.out.println(sistema.registrarPasajero("FR123.123#3", "Alicia", 35));
        System.out.println(sistema.registrarPasajero("DER23.12353", "Roberto", 42));

        System.out.println("\n" + "----------TESTEO METODO buscarPasajero----------" + "\n");

        System.out.println(sistema.buscarPasajero("FR123.123#3"));
        System.out.println(sistema.buscarPasajero("UK805.978#8"));
        System.out.println(sistema.buscarPasajero("ES134.167#3"));
        System.out.println(sistema.buscarPasajero("FRR34.16783"));

        System.out.println("\n" + "----------TESTEO METODO registrarEstacionDeTren----------" + "\n");

        System.out.println(sistema.registrarEstacionDeTren("MMM123", "Madrid"));
        System.out.println(sistema.registrarEstacionDeTren("FFF123", "Paris"));
        System.out.println(sistema.registrarEstacionDeTren("AAA143", "Dortmund"));
        System.out.println(sistema.registrarEstacionDeTren("ABQ143", "NANTES"));
        System.out.println(sistema.registrarEstacionDeTren("QZY143", "LONDRES"));
        System.out.println(sistema.registrarEstacionDeTren("MMM123", "Berlin"));
        System.out.println(sistema.registrarEstacionDeTren("LLL00", "Malaga"));
        System.out.println(sistema.registrarEstacionDeTren("AAA1234", "Barcelona"));
        System.out.println(sistema.registrarEstacionDeTren("A♪B456", "Valencia"));
        System.out.println(sistema.registrarEstacionDeTren("", "Niza"));
        System.out.println(sistema.registrarEstacionDeTren("AEA143", "MANCHESTER"));
        System.out.println(sistema.registrarEstacionDeTren("ZZZ258", "MONTPELLIER"));

    }
}
