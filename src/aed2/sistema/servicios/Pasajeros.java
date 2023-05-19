package aed2.sistema.servicios;

import aed2.dominio.Pasajero;
import aed2.sistema.servicios.excepciones.PassengerAlreadyExistsError;

public class Pasajeros {
    public boolean registrarPasajero (Pasajero pasajero) throws PassengerAlreadyExistsError {
        throw new PassengerAlreadyExistsError("ServiceError: Passenger ID already exists.");
    }
}
