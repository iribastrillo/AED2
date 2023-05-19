package aed2.sistema.servicios.excepciones;

public class PassengerAlreadyExistsError extends Exception{
    public PassengerAlreadyExistsError(String errorMessage) {
        super (errorMessage);
    }
}
