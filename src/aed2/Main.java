package aed2;
import aed2.dominio.Pasajero;
import aed2.sistema.Implementacion;

public class Main {
    public static void main(String args[]) {
        Implementacion sistema = new Implementacion();
        sistema.inicializarSistema(8);
        System.out.println(sistema.registrarPasajero("FR123.123#3", "Ignacio", 30));
        System.out.println(sistema.registrarPasajero("DE124.124#5", "Roberto", 30));
        sistema.getAbbPasajeros().imprimirEnOrden();
    }
}
