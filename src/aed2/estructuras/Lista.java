package aed2.estructuras;
import aed2.interfaz.Sistema;
import aed2.sistema.Implementacion;

public class Lista<T extends Comparable<T>> implements ILista<T> {
    private Nodo inicio;
   // private int contadorEstaciones = 0;

    private class Nodo {
        T dato;
        Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    //Implementacion sistema = new Implementacion();

    @Override
    public void insertar(T dato) {
        //contadorEstaciones++;
        //sistema.setCantidadActual(contadorEstaciones);
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    @Override
    public void borrar(T dato) {

    }

    @Override
    public int largo() {
        return 0;
    }

    @Override
    public boolean existe(T dato) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public T recuperar(T dato) {
        return null;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public boolean esLlena() {
        return false;
    }

    @Override
    public void imprimirDatos() {

    }

    public void insertarElementoInicio(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esVacia()) {
            inicio = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
    }

    public void imprimirLista() {
        imprimirListaRecursivo(inicio);
    }

    private void imprimirListaRecursivo(Nodo nodo) {
        if (nodo == null) {
            System.out.println();
            return;
        }
        System.out.print(nodo.dato + " ");
        imprimirListaRecursivo(nodo.siguiente);
    }
}