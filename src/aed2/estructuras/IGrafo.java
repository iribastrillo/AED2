package aed2.estructuras;

import aed2.dominio.Estacion;
import aed2.dominio.vo.Estado;

public interface IGrafo {
    void agregarVertice(Estacion nombre);
    void agregarArista(Estacion origen, Estacion destino, int identificador, double costo, double distancia, Estado estado, double tiempo);
    void eliminarVertice(Estacion v);
    void eliminarArista(int origen, int destino);
    void imprimirGrafo();
    boolean existeVertice(Estacion v);
    boolean sonAdyacentes(Estacion a, Estacion b);
    Lista<Integer> verticesAdyacentes(Estacion v);
    boolean esVacio();
    boolean estaLlena();

}
