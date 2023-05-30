package aed2.estructuras;

public class Lista<T extends Comparable<T>> implements ILista<T> {
    private Nodo inicio;

    public Nodo getInicio() {
        return inicio;
    }
    private class Nodo {
        T dato;
        Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    @Override
    public int size() {
        int count = 0;
        Nodo aux = inicio;
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }
    @Override
    public T getElementoEnPosicion(int posicion) {
        int count = 0;
        Nodo aux = inicio;
        while (aux != null) {
            if (count == posicion) {
                return aux.dato;
            }
            count++;
            aux = aux.siguiente;
        }
        return null;
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
        Nodo aux = inicio;
        Nodo previous = null;
        while (aux != null) {
            if (aux.equals(dato)) {
                if (previous == null) {
                    inicio = null;
                } else {
                    previous.siguiente = aux.siguiente;
                }
            }
            aux = aux.siguiente;
            previous = aux;
        }
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
        Nodo buscado = null;
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                buscado = aux;
            }
            aux = aux.siguiente;
        }
        return buscado.dato;
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

    public Lista<String> ordenarAlfabeticamente() {
        Lista<String> listaOrdenada = new Lista<>();

        // Copiar los elementos de la lista original a la lista ordenada
        Nodo aux = inicio;
        while (aux != null) {
            listaOrdenada.insertar(aux.dato.toString()); // Realizar el cast a String
            aux = aux.siguiente;
        }

        int n = listaOrdenada.size();
        if (n <= 1) {
            return listaOrdenada; // No es necesario ordenar una lista vacía o con un solo elemento
        }

        Nodo actual = (Nodo) listaOrdenada.getInicio();
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 0; i < n - 1; i++) {
                String datoActual = actual.dato.toString().substring(0, 3);
                Nodo siguiente = actual.siguiente;
                String datoSiguiente = siguiente.dato.toString().substring(0, 3);
                if (datoActual.compareTo(datoSiguiente) > 0) {
                    // Intercambiar los datos de los nodos
                    String temp = actual.dato.toString();
                    actual.dato = siguiente.dato;
                    siguiente.dato = (T) temp;
                    intercambiado = true;
                }
                actual = siguiente;
            }
            n--;
            actual = (Nodo) listaOrdenada.inicio;
        } while (intercambiado);

        return listaOrdenada;
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