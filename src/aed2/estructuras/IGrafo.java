package aed2.estructuras;

import aed2.dominio.Estacion;

public interface IGrafo {
    void agregarVertice(Estacion nombre);
    void agregarArista(Estacion origen, Estacion destino, double costo, double distancia);
    void eliminarVertice(Estacion v);
    void eliminarArista(int origen, int destino);
    boolean existeVertice(Estacion v);
    boolean sonAdyacentes(Estacion a, Estacion b);
    Lista<Integer> verticesAdyacentes(Estacion v);
    boolean esVacio();
    boolean estaLlena();

}
