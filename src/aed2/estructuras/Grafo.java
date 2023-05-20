package aed2.estructuras;

import aed2.dominio.Estacion;

public class Grafo <T> implements IGrafo <T> {

    private int cantidadMaxima;
    private int  cantidadActual;

    private int autoID;

    private int[][] adyacencias;
    private Vertex<T>[] vertices;

    public Grafo (int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.autoID = 0;
        this.adyacencias = new int[cantidadMaxima + 1][cantidadMaxima + 1];
    }
    @Override
    public void addVertex(Vertex<T> v) {
        this.cantidadActual ++;
        Estacion station = (Estacion) v.getData();
        vertices[this.autoID] = v;
    }

    @Override
    public void addEdge(Vertex<T> origin, Vertex<T> destination, float weight) {

    }

    @Override
    public void removeVertex(Vertex<T> v) {

    }

    @Override
    public void removeEdge(Vertex<T> origin, Vertex<T> destination) {

    }

    @Override
    public void vertexExists(Vertex<T> v) {

    }
}
