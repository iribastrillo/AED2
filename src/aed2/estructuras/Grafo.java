package aed2.estructuras;

import aed2.dominio.Estacion;

import java.util.Objects;

public class Grafo implements IGrafo {
    private final int cantMaxVertices;
    private int cantVertices;
    private boolean esDirigido;
    private Arista[][] matrizAdyacencia;
    private Vertice[] vertices;

    public Grafo(int cantMaxVertices, boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.cantMaxVertices = cantMaxVertices;
        this.matrizAdyacencia = new Arista[cantMaxVertices][cantMaxVertices];
        this.vertices = new Vertice[cantMaxVertices];

        for (int i = 0; i < cantMaxVertices; i++) {
            for (int j = 0; j < cantMaxVertices; j++) {
                matrizAdyacencia[i][j] = new Arista();
            }
        }
    }

    @Override
    public void agregarVertice(Estacion estacion) {
        cantVertices++;
        int posLibre = obtenerPosLibre();
        if (posLibre >= 0) {
            vertices[posLibre] = new Vertice(estacion);
        }
    }

    private int obtenerPosLibre() {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int obtenerPos(Estacion vert) {
        for (int i = 0; i < cantMaxVertices; i++) {
            if (vertices[i] != null && vertices[i].equals(vert))
                return i;
        }
        return -1;
    }

    @Override
    public void agregarArista(Estacion origen, Estacion destino, double costo, double distancia) {
        int obtenerPosOrigen = obtenerPos(origen);
        int obtenerPosDestino = obtenerPos(destino);
        if (obtenerPosOrigen >= 0 && obtenerPosDestino >= 0) {
            matrizAdyacencia[obtenerPosOrigen][obtenerPosDestino] = new Arista(costo, distancia);
            if (!esDirigido) {
                matrizAdyacencia[obtenerPosDestino][obtenerPosOrigen] = matrizAdyacencia[obtenerPosOrigen][obtenerPosDestino];
            }
        }
    }

    @Override
    public void eliminarVertice(Estacion vert) {
        cantVertices--;
        int posVert = obtenerPos(vert);
        if (posVert >= 0) {
            vertices[posVert] = null;
            for (int i = 1; i <= cantMaxVertices; i++) {
                matrizAdyacencia[posVert][i].setExiste(false); //filas
                matrizAdyacencia[posVert][i].setCosto(0); //filas
                matrizAdyacencia[posVert][i].setDistancia(0); //filas
                matrizAdyacencia[i][posVert].setExiste(false); //columnas
                matrizAdyacencia[i][posVert].setCosto(0); //columnas
                matrizAdyacencia[i][posVert].setDistancia(0); //columnas
            }
        }
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino].setExiste(false);
        matrizAdyacencia[origen][destino].setCosto(0);
        matrizAdyacencia[origen][destino].setDistancia(0);
    }

    @Override
    public boolean existeVertice(Estacion vert) {
        return obtenerPos(vert) >= 0;
    }

    @Override
    public boolean sonAdyacentes(Estacion a, Estacion b) {
        int obtenerPosOrigen = obtenerPos(a);
        int obtenerPosDestino = obtenerPos(b);
        if (obtenerPosOrigen >= 0 && obtenerPosDestino >= 0) {
            return matrizAdyacencia[obtenerPosOrigen][obtenerPosDestino].isExiste();
        } else {
            return false;
        }
    }

    @Override
    public Lista<Integer> verticesAdyacentes(Estacion v) {
        Lista<Integer> verticesAdy = new Lista<Integer>();
        int obtenerPosOrigen = obtenerPos(v);
        if (obtenerPosOrigen >= 0) {
            for (int i = 0; i < cantMaxVertices; i++) {
                if (sonAdyacentes(v, vertices[i].dato)) {
                    verticesAdy.insertar(i);
                }
            }
        }
        return verticesAdy;
    }


    @Override
    public boolean esVacio() {
        return cantVertices == 0;
    }

    @Override
    public boolean estaLlena() {
        return cantVertices == cantMaxVertices;
    }

    private class Vertice {
        private Estacion dato;

        public Vertice(Estacion estacion) {
            this.dato = estacion;
        }
        public Vertice(String nombre) {this.dato = new Estacion(nombre); }

        public String getNombre() {
            return dato.getNombre();
        }

        public void setNombre(String nombre) {
            this.dato.setNombre(nombre);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            Estacion vertice = (Estacion) o;
            return this.dato.equals(vertice);
        }
    }

    private class Arista {
        public boolean existe;
        public double costo;
        public double distancia;
        public Arista(double costo, double distancia) {
            this.costo = costo;
            this.distancia = distancia;
            this.existe = true;
        }

        public Arista() {
        }

        public boolean isExiste() {
            return this.existe;
        }

        public void setExiste(boolean existe) {
            this.existe = existe;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(int costo) {
            this.costo = costo;
        }

        public double getDistancia() {
            return distancia;
        }

        public void setDistancia(int distancia) {
            this.distancia = distancia;
        }
    }

}
