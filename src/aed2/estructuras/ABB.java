package aed2.estructuras;

import aed2.dominio.Pasajero;

public class ABB {

    private Nodo raiz;

    private int contador = 0;

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
        contador = 0;
        return buscarRecursivo(raiz, pasajero);
    }

    private Pasajero buscarRecursivo(Nodo nodo, Pasajero pasajero) {
        if (nodo == null) {
            return null;
        }

        contador++;

        if (pasajero.equals(nodo.pasajero)) {
            nodo.pasajero.setTiempoDeBusqueda(contador);
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

    public void imprimirEnOrdenDescendente() {
        imprimirEnOrdenDescendente(raiz);
    }

    private void imprimirEnOrdenDescendente(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenDescendente(nodo.izquierdo);
            System.out.print(nodo.pasajero + "\n");
            imprimirEnOrdenDescendente(nodo.derecho);
        }
    }

    public void imprimirEnOrdenAscendente() {
        imprimirEnOrdenAscedente(raiz);
    }

    private void imprimirEnOrdenAscedente(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenDescendente(nodo.derecho);
            System.out.print(nodo.pasajero + "\n");
            imprimirEnOrdenDescendente(nodo.izquierdo);
        }
    }

//    private void imprimirPorNacionalidad(Nodo nodo) {
//        imprimirPorNacionalidadRecurisvo(nodo.pasajero.getId());
//    }
//
//    private void imprimirPorNacionalidadRecurisvo(Nodo nodo) {
//        if (nodo != null) {
//            imprimirEnOrdenDescendente(nodo.derecho);
//            System.out.print(nodo.pasajero + "\n");
//            imprimirEnOrdenDescendente(nodo.izquierdo);
//        }
//    }


}
