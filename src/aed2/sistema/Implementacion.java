package aed2.sistema;

import aed2.dominio.Estacion;
import aed2.dominio.Pasajero;
import aed2.dominio.vo.*;
import aed2.estructuras.ABB;
import aed2.estructuras.Lista;
import aed2.interfaz.Consulta;
import aed2.interfaz.Retorno;
import aed2.interfaz.Sistema;

public class Implementacion implements Sistema {
    private int maxEstaciones;
    private int cantidadActual;
    private ABB abbPasajeros;
    private Lista<Estacion> stations;

    private int cantidadEstacionesRegistradas = 0;

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

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
        setCantidadActual(0);
        abbPasajeros = new ABB();
        stations = new Lista<Estacion>();
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

        Retorno existe = buscarPasajero(identificador);

        if (existe.isOk()) {
            return Retorno.error3("E3: El pasajero ya está registrado.");
        }

        Pasajero pasajero = new Pasajero(identificador, nombre, edad);
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

        Pasajero existe = abbPasajeros.buscar(new Pasajero(identificador));

        if (existe == null) {
            return Retorno.error2("E2: No hay un pasajero registrado con ese identificador.");
        }

        String message = "Nombre: " + existe.getNombre() + " | " + "Pasaporte: " + existe.getId() + " | " + "Edad: " + existe.getEdad();

        return Retorno.ok(existe.getTiempoDeBusqueda(), message);
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
        if (getCantidadActual() == getMaxEstaciones()) {
            return Retorno.error1("E1: Ya se registró el máximo permitido de estaciones");
        }

        if (!NoVacio.validate(nombre)) {
            return Retorno.error2("E2: El nombre de la estación no puede ser vacío.");
        }
        if (!NoVacio.validate(codigo)) {
            return Retorno.error2("E2: El código de la estación no puede ser vacío.");
        }
        if (!Codigo.validate(codigo)) {
            return Retorno.error3("E3: El código de la estación no es válido.");
        }


        Estacion station = new Estacion(codigo, nombre);

        if (stations.existe(station)) {
            return Retorno.error4("E4: Ya existe una estación con ese código.");
        }
        cantidadEstacionesRegistradas++;
        setCantidadActual(cantidadEstacionesRegistradas);
        stations.insertar(station);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarConexion(String codigoEstacionOrigen, String codigoEstacionDestino,
                                     int identificadorConexion, double costo, double tiempo, double kilometros,
                                     Estado estadoDeLaConexion) {
        if (costo <= 0 || tiempo <= 0 || kilometros <= 0) {
            return Retorno.error1("E1: Costo, tiempo y kilómetros deben ser mayores que 0.");
        }
        if (NoVacio.validate(codigoEstacionOrigen) || NoVacio.validate(codigoEstacionDestino)) {
            return Retorno.error2("E2: El código de origen y destino no pueden ser vacíos.");
        }
        if (estadoDeLaConexion == null) {
            return Retorno.error2("E2: El estado de la conexión no puede ser nulo.");
        }
        if (!Codigo.validate(codigoEstacionOrigen)) {
            return Retorno.error3("E2: El código de origen no es válido.");
        }
        if (!Codigo.validate(codigoEstacionDestino)) {
            return Retorno.error3("E2: El código de destino no es válido.");
        }

        Estacion origin = new Estacion(codigoEstacionOrigen);
        Estacion destination = new Estacion(codigoEstacionDestino);

        if (!stations.existe(origin)) {
            return Retorno.error4("E4: No existe la estación de origen");
        }

        if (!stations.existe(destination)) {
            return Retorno.error4("E4: No existe la estación de destino");
        }


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

    public Lista<Estacion> getStations() {
        return stations;
    }

    public void setStations(Lista<Estacion> stations) {
        this.stations = stations;
    }
}
