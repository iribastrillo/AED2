package aed2.dominio;

import aed2.dominio.vo.Identificador;
import aed2.dominio.vo.NoVacio;
public class Pasajero {
    private String id;
    private int nro;
    private String nombre;
    private int edad;
    public Pasajero (String id) {
        this.id = id;
        this.nro = Identificador.getNumber(id);
    }
    public Pasajero (String id, String nombre, int edad) {
        this.id = id;
        this.nro = Identificador.getNumber(id);
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        Pasajero otro = (Pasajero) obj;
        return this.nro == otro.nro;
    }

    @Override
    public String toString() {
        return "PASAJERO: " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
