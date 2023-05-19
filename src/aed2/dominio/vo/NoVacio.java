package aed2.dominio.vo;

public class NoVacio {
    public static boolean validate (String valor) {
        if (valor.isEmpty() || valor == null) {
            return false;
        } else {
            return true;
        }
    }
}
