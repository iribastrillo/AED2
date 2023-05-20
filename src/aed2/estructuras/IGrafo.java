package aed2.estructuras;

public interface IGrafo <T> {
    void addVertex (Vertex<T> v);
    void addEdge (Vertex <T> origin, Vertex <T> destination, float weight);
    void removeVertex (Vertex <T> v);
    void removeEdge (Vertex <T> origin, Vertex<T> destination);
    void vertexExists (Vertex <T> v);
}
