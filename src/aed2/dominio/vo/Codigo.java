package aed2.dominio.vo;

import aed2.dominio.excepciones.DomainException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Codigo {
    private String valor;
    public Codigo(String data) throws DomainException {
        valor = data;
        this.validate ();
    }
    public void validate () throws DomainException {
        Pattern pattern = Pattern.compile("^[aA-zZ]{3}[0-9]{3}$");
        Matcher matcher = pattern.matcher(this.valor);
        boolean found = matcher.find();
        if (!found) {
            throw new DomainException ("ValueError: Station code is not valid.");
        }
    }
}
