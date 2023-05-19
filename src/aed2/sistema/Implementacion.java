package aed2.sistema;

import aed2.dominio.vo.*;
import aed2.interfaz.Consulta;
import aed2.interfaz.Retorno;
import aed2.interfaz.Sistema;
import aed2.sistema.servicios.Pasajeros;

public class Implementacion implements Sistema {
    private int maxEstaciones;
    private Pasajeros servicioPasajeros;
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
        this.servicioPasajeros = new Pasajeros();
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
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarPasajerosAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarPasajerosDescendente() {
        return Retorno.noImplementada();
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

}
