package aed2.estructuras;

public interface ILista<T> {
    void insertar(T dato);
    void borrar(T dato);
    int largo();
    int size();
    T getElementoEnPosicion(int posicion);
    boolean existe(T dato);
    Lista<String> ordenarAlfabeticamente();
    T recuperar(T dato);
    boolean esVacia();
    boolean esLlena();
    void imprimirDatos();
}
