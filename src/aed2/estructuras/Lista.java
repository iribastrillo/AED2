package aed2.estructuras;

public class Lista<T extends Comparable<T>> implements ILista<T> {
    private Nodo inicio;
    private class Nodo {
        T dato;
        Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    @Override
    public void insertar(T dato) {
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

    @Override
    public String toString() {
        String s = "";
        Nodo aux = this.inicio;
        while (aux != null) {
            s = s + aux.dato.toString();
            aux = aux.siguiente;
        }
        return s;
    }
}