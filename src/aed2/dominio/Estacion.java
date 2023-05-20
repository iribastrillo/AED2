package aed2.dominio;

import aed2.dominio.vo.Codigo;

public class Estacion implements Comparable<Estacion> {
    private String codigo;
    private String nombre;
    public Estacion (String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    @Override
    public int compareTo(Estacion o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ESTACIÓN: " + nombre;
    }
}
