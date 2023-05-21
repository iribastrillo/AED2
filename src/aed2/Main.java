package aed2;
import aed2.dominio.Pasajero;
import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion();
        sistema.inicializarSistema(8);
        System.out.println(sistema.registrarPasajero("DE123.123#6", "Nacho", 26));
        System.out.println(sistema.registrarPasajero("DE123.123#4", "Francisco", 25));
        System.out.println(sistema.registrarPasajero("DE124.124#5", "Roberto", 30));
        System.out.println(sistema.registrarPasajero("FR123.123#3", "Ignacio", 30));
        System.out.println(sistema.registrarPasajero("DE123.123#7", "Fede", 27));
        System.out.println(sistema.registrarPasajero("DE123.123#5", "Carolina", 20));
        System.out.println(sistema.registrarPasajero("DE123.123#8", "Josefina", 36));
        System.out.println(sistema.buscarPasajero("FR123.123#3"));
        System.out.println(sistema.buscarPasajero("ES134.167#3"));
        System.out.println("des" + sistema.listarPasajerosDescendente());
        System.out.println("asc" + sistema.listarPasajerosAscendente());
    }
}
