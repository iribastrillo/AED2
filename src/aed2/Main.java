package aed2;

import aed2.dominio.vo.Estado;
import aed2.interfaz.Consulta;
import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion();
        System.out.println(sistema.inicializarSistema(9));

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

        System.out.println(sistema.registrarEstacionDeTren("MMM123", "MADRID"));
        System.out.println(sistema.registrarEstacionDeTren("FFF123", "PARIS"));
        System.out.println(sistema.registrarEstacionDeTren("AAA143", "DORTMUND"));
        System.out.println(sistema.registrarEstacionDeTren("ABQ143", "NANTES"));
        System.out.println(sistema.registrarEstacionDeTren("QZY143", "LONDRES"));
        System.out.println(sistema.registrarEstacionDeTren("MMM123", "MADRID"));
        System.out.println(sistema.registrarEstacionDeTren("KJL589", "BERLIN"));
        System.out.println(sistema.registrarEstacionDeTren("UYT896", "OSLO"));
        System.out.println(sistema.registrarEstacionDeTren("LLL00", "MALAGA"));
        System.out.println(sistema.registrarEstacionDeTren("AAA1234", "BARCELONA"));
        System.out.println(sistema.registrarEstacionDeTren("A♪B456", "VALENCIA"));
        System.out.println(sistema.registrarEstacionDeTren("", "NIZA"));
        System.out.println(sistema.registrarEstacionDeTren("AEA143", "MANCHESTER"));
        System.out.println(sistema.registrarEstacionDeTren("ZZZ258", "MONTPELLIER"));

        System.out.println("\n" + "----------TESTEO METODO filtrarPasajeros----------" + "\n");

        Consulta consulta = Consulta.fromString("[nombre='Ignacio' AND edad > 10]");
        System.out.println(sistema.filtrarPasajeros(consulta));

        System.out.println("\n" + "----------TESTEO METODO listarPasajerosPorNacionalidad----------" + "\n");

        System.out.println(sistema.listarPasajerosPorNacionalidad("UK"));

        System.out.println("\n" + "----------TESTEO METODO registrarConexion ----------" + "\n");

        System.out.println(sistema.registrarConexion("MMM123", "FFF123",
                1, 50, 50, 50, Estado.BUENO));
        System.out.println(sistema.registrarConexion("FFF123", "AAA143",
                2, 100, 100, 200, Estado.BUENO));
        System.out.println(sistema.registrarConexion("RRR123", "FFF123",
                3, 50, 50, 50, Estado.BUENO));
        System.out.println(sistema.registrarConexion("MMM123", "WWW123",
                4, 50, 50, 50, Estado.BUENO));
        System.out.println(sistema.actualizarCamino("MMM123", "FFF123",
                5, 30, 30, 30, Estado.BUENO));
        System.out.println(sistema.actualizarCamino("FFF123", "MMM123",
                6, 30, 30, 30, Estado.BUENO));
        System.out.println(sistema.registrarConexion("AAA143", "ABQ143",
                7, 50, 50, 50, Estado.BUENO));
        System.out.println(sistema.registrarConexion("KJL589", "UYT896",
                8, 50, 50, 50, Estado.BUENO));

        System.out.println("\n" + "----------IMPRIMIR GRAFO  ----------" + "\n");

        sistema.getConexiones().imprimirGrafo();

        System.out.println("\n" + "----------TEST: BFS  ----------" + "\n");

        System.out.println(sistema.listadoEstacionesCantTrasbordos("FFF123", 4));

    }
}
