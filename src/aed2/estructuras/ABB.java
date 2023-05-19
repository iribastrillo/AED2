package aed2.estructuras;

import aed2.dominio.Pasajero;

public class ABB {

    private Nodo raiz;

    private class Nodo {
        Pasajero dato;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(Pasajero dato) {
            this.dato = dato;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }

        return nodo;
    }

    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return false;
        }

        if (dato == nodo.dato) {
            return true;
        } else if (dato < nodo.dato) {
            return buscarRecursivo(nodo.izquierdo, dato);
        } else {
            return buscarRecursivo(nodo.derecho, dato);
        }
    }

    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return null;
        }

        if (dato < nodo.dato) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.dato = obtenerMinimo(nodo.derecho);
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private int obtenerMinimo(Nodo nodo) {
        int minimo = nodo.dato;
        while (nodo.izquierdo != null) {
            minimo = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minimo;
    }

    public void imprimirEnOrden() {
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            imprimirEnOrdenRecursivo(nodo.derecho);
        }
    }
}
