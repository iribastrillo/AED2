package aed2.sistema;

import aed2.dominio.Pasajero;
import aed2.dominio.vo.*;
import aed2.estructuras.ABB;
import aed2.interfaz.Consulta;
import aed2.interfaz.Retorno;
import aed2.interfaz.Sistema;

public class Implementacion implements Sistema {
    private int maxEstaciones;
    private ABB abbPasajeros;
    public int getMaxEstaciones() {
        return maxEstaciones;
    }

    public void setMaxEstaciones(int maxEstaciones) {
        this.maxEstaciones = maxEstaciones;
    }
    @Override
    public Retorno inicializarSistema(int maxEstaciones) {
        if (maxEstaciones <= 5) {
            return Retorno.error1("E1: la cantidad de estaciones debe ser mayor que 5.");
        }
        setMaxEstaciones(maxEstaciones);
        abbPasajeros = new ABB();
        return Retorno.ok();
    }
    @Override
    public Retorno registrarPasajero(String identificador, String nombre, int edad) {
        if (!Identificador.validate(identificador)) {
            return Retorno.error2("E2: El identificador no es válido.");
        }
        if (!NoVacio.validate(nombre)) {
            return Retorno.error1("E1: El nombre no puede ser vacío.");
        }

        Pasajero existe = new Pasajero (identificador);

        if (existe == null) {
            return Retorno.error3("E3: El pasajero ya está registrado.");
        }

        Pasajero pasajero = new Pasajero (identificador, nombre, edad);
        abbPasajeros.insertar(pasajero);
        return Retorno.ok();
    }

    @Override
    public Retorno filtrarPasajeros(Consulta consulta) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno buscarPasajero(String identificador) {
        if (!Identificador.validate(identificador)) {
            return Retorno.error1("E1: El identificador no es válido.");
        }

        Pasajero existe = abbPasajeros.buscar(new Pasajero (identificador));

        if (existe == null) {
            return Retorno.error2("E2: No hay un pasajero registrado con ese identificador.");
        }

        return Retorno.ok(existe.toString());
    }

    @Override
    public Retorno listarPasajerosAscendente() {
        return Retorno.ok(abbPasajeros.imprimirEnOrdenAscendente());
    }

    @Override
    public Retorno listarPasajerosDescendente() {
        return Retorno.ok(abbPasajeros.imprimirEnOrdenDescendente());
    }

    @Override
    public Retorno listarPasajerosPorNacionalidad(Nacionalidad nacionalidad) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarEstacionDeTren(String codigo, String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarConexion(String codigoEstacionOrigen, String codigoEstacionDestino,
                                     int identificadorConexion, double costo, double tiempo, double kilometros,
                                     Estado estadoDeLaConexion) {
        return Retorno.noImplementada();
    }
    @Override
    public Retorno actualizarCamino(String codigoEstacionOrigen, String codigoEstacionDestino,
                                    int identificadorConexion, double costo, double tiempo,
                                    double kilometros, Estado estadoDelCamino) {
        return Retorno.noImplementada();
    }
    @Override
    public Retorno listadoEstacionesCantTrasbordos(String codigo, int cantidad) {
        return Retorno.noImplementada();
    }
    @Override
    public Retorno viajeCostoMinimoKilometros(String codigoEstacionOrigen, String codigoEstacionDestino) {
        return Retorno.noImplementada();
    }
    @Override
    public Retorno viajeCostoMinimoEuros(String codigoEstacionOrigen, String codigoEstacionDestino) {
        return null;
    }

    public ABB getAbbPasajeros() {
        return abbPasajeros;
    }

    public void setAbbPasajeros(ABB abbPasajeros) {
        this.abbPasajeros = abbPasajeros;
    }
}
