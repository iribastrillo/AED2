package aed2;

import aed2.dominio.Estacion;
import aed2.dominio.vo.Estado;
import aed2.interfaz.Consulta;
import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion();
        System.out.println(sistema.inicializarSistema(6));

        System.out.println("----------TESTEO METODO registrarPasajero----------" + "\n");

        System.out.println(sistema.registrarPasajero("FR123.123#3", "Ignacio", 30));
        System.out.println(sistema.registrarPasajero("FR524.155#1", "Jimena", 29));
        System.out.println(sistema.registrarPasajero("DE724.187#1", "Pedro", 28));
        System.out.println(sistema.registrarPasajero("UK805.978#8", "Juan", 54));
        System.out.println(sistema.registrarPasajero("FR123.123#3", "Alicia", 35));
        System.out.println(sistema.registrarPasajero("DER23.12353", "Roberto", 42));
        System.out.println(sistema.registrarPasajero("UK505.988#7", "pepe", 42));
        System.out.println(sistema.registrarPasajero("UK400.111#2", "Viviana", 42));
        System.out.println(sistema.registrarPasajero("", "Federico", 42));

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

        System.out.println("\n" + "----------TESTEO METODO filtrarPasajeros----------" + "\n");

        Consulta consulta = Consulta.fromString("[nombre='Ignacio' AND edad > 10]");
        System.out.println("filtrar");
        System.out.println(sistema.filtrarPasajeros(consulta));

        System.out.println("\n" + "----------TESTEO METODO listarPasajerosPorNacionalidad----------" + "\n");

        System.out.println(sistema.listarPasajerosPorNacionalidad("ES"));

        System.out.println("\n" + "----------TESTEO METODO registrarConexion ----------" + "\n");


        System.out.println(sistema.registrarConexion("MMM123", "FFF123",
                1, 50, 50, 50, Estado.BUENO));
        System.out.println(sistema.getConexiones().sonAdyacentes(new Estacion("MMM123"), new Estacion("FFF123")));

    }
}
