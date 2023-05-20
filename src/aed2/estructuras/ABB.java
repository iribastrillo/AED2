package aed2.estructuras;

import aed2.dominio.Pasajero;

public class ABB {

    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    private class Nodo {
        Pasajero pasajero;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(Pasajero pasajero) {
            this.pasajero = pasajero;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public void insertar(Pasajero pasajero) {
        raiz = insertarRecursivo(raiz, pasajero);
    }

    private Nodo insertarRecursivo(Nodo nodo, Pasajero pasajero) {
        if (nodo == null) {
            return new Nodo(pasajero);
        }
        if (pasajero.getNro() < nodo.pasajero.getNro()) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, pasajero);
        } else if (pasajero.getNro() > nodo.pasajero.getNro()) {
            nodo.derecho = insertarRecursivo(nodo.derecho, pasajero);
        }
        return nodo;
    }

    public Pasajero buscar(Pasajero pasajero) {
        return buscarRecursivo(raiz, pasajero);
    }

    private Pasajero buscarRecursivo(Nodo nodo, Pasajero pasajero) {
        if (nodo == null) {
            return null;
        }
        if (pasajero.equals(nodo.pasajero)) {
            return nodo.pasajero;
        } else if (pasajero.getNro() < nodo.pasajero.getNro()) {
            return buscarRecursivo(nodo.izquierdo, pasajero);
        } else {
            return buscarRecursivo(nodo.derecho, pasajero);
        }
    }

    public void eliminar(Pasajero pasajero) {
        raiz = eliminarRecursivo(raiz, pasajero);
    }

    private Nodo eliminarRecursivo(Nodo nodo, Pasajero pasajero) {
        if (nodo == null) {
            return null;
        }

//        if (pasajero < nodo.pasajero) {
//            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, pasajero);
//        } else if (pasajero > nodo.pasajero) {
//            nodo.derecho = eliminarRecursivo(nodo.derecho, pasajero);
//        } else {
//            if (nodo.izquierdo == null) {
//                return nodo.derecho;
//            } else if (nodo.derecho == null) {
//                return nodo.izquierdo;
//            }
//
//            // nodo.pasajero = obtenerMinimo(nodo.derecho);
//            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.pasajero);
//        }

        return nodo;
    }

    private int obtenerMinimo(Nodo nodo) {
        //int minimo = nodo.pasajero;
        while (nodo.izquierdo != null) {
            // minimo = nodo.izquierdo.pasajero;
            nodo = nodo.izquierdo;
        }
        return 0;
    }

    public String imprimirEnOrdenDescendente() {
        String valorString = imprimirEnOrdenDescendente(raiz);
        return valorString.substring(0, valorString.length()-1);
    }
//    private void imprimirEnOrdenDescendente(Nodo nodo) {
//        if (nodo != null) {
//            imprimirEnOrdenDescendente(nodo.izquierdo);
//            imprimirEnOrdenDescendente(nodo.derecho);
//            System.out.print(nodo.pasajero+"|");
//        }
//    }
    private String imprimirEnOrdenDescendente(Nodo nodo) {
        if (nodo != null) {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return nodo.pasajero + "|";
            } else {
                return nodo.pasajero + "|"
                        + imprimirEnOrdenDescendente(nodo.izquierdo)
                        + imprimirEnOrdenDescendente(nodo.derecho);
            }
        }
        return "";
    }
    public String imprimirEnOrdenAscendente() {
        String valorString = imprimirEnOrdenAscedente(raiz);
        return valorString.substring(0, valorString.length()-1);
    }
    private String imprimirEnOrdenAscedente(Nodo nodo) {
        if (nodo != null) {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return nodo.pasajero + "|";
            } else {
                return imprimirEnOrdenAscedente(nodo.izquierdo)
                        + imprimirEnOrdenAscedente(nodo.derecho)
                        + nodo.pasajero + "|";
            }
        }
        return "";
    }
}
