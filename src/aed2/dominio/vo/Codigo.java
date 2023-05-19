package aed2.dominio.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Codigo {
    private String valor;
    public Codigo(String data) {
        valor = data;
        this.validate ();
    }
    public boolean validate () {
        Pattern pattern = Pattern.compile("^[aA-zZ]{3}[0-9]{3}$");
        Matcher matcher = pattern.matcher(this.valor);
        boolean found = matcher.find();
        return found;
    }
}
