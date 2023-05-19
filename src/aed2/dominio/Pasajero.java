package aed2.dominio;

import aed2.dominio.vo.Identificador;
import aed2.dominio.vo.NoVacio;
public class Pasajero implements Comparable{
    private Identificador id;
    private int nro;
    private NoVacio nombre;
    private int edad;
    public Pasajero (Identificador id, NoVacio nombre, int edad) {
        id = id;
        nombre = nombre;
        edad = edad;
    }

    public Identificador getId() {
        return id;
    }

    public void setId(Identificador id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public NoVacio getNombre() {
        return nombre;
    }

    public void setNombre(NoVacio nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
